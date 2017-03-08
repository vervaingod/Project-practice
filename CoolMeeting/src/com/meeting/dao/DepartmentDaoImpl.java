package com.meeting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meeting.bean.DepartmentBean;
import com.meeting.bean.Department_EmployeeBean;

import com.meeting.util.DBUtil;
import com.meeting.bean.PageBean;

/**
 * @see 员工管理数据库层接口，用于封装员工与数据库操作的实现方法
 * @author 刘均前、郭怡君
 * @since 2015-08-29
 * @version V1.0
 */
public class DepartmentDaoImpl implements DepartmentDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public int addDepartment(DepartmentBean departmentBean) throws Exception {
		connection = dbUtil.getConnection();
		int rows = 0;
		String sql = "insert into department(departmentname) values(?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, departmentBean.getDepartmentname());
		rows = preparedStatement.executeUpdate();

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int fetchIdByDepartmentName(String departmentname) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "select * from department where departmentname=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, departmentname);
		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			rows = 1;
		}

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public List<DepartmentBean> fetchAllDepartments(int pageno)
			throws Exception {
		List<DepartmentBean> departmentBeanList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from department limit ?,?";
		int startIndex = (pageno - 1) * PageBean.ROWS_PRO_PAGE;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, startIndex);
		preparedStatement.setInt(2, PageBean.ROWS_PRO_PAGE);

		resultSet = preparedStatement.executeQuery();

		departmentBeanList = new ArrayList<DepartmentBean>();
		while (resultSet.next()) {
			DepartmentBean departmentBean = new DepartmentBean();
			departmentBean.setDepartmentid(resultSet.getInt("departmentid"));
			departmentBean.setDepartmentname(resultSet
					.getString("departmentname"));

			departmentBeanList.add(departmentBean);
		}

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return departmentBeanList;
	}

	@Override
	public int deleteDepartmentById(int id) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "delete from department where departmentid=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		rows = preparedStatement.executeUpdate();

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public DepartmentBean fetchDepartmentById(int id) throws Exception {
		connection = dbUtil.getConnection();
		String sql = "select * from department where departmentid=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();

		DepartmentBean departmentBean = new DepartmentBean();
		while (resultSet.next()) {
			departmentBean.setDepartmentid(resultSet.getInt("departmentid"));
			departmentBean.setDepartmentname(resultSet
					.getString("departmentname"));
		}

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return departmentBean;
	}

	@Override
	public int updateDepartment(DepartmentBean departmentBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "update department set departmentname=? where departmentid=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, departmentBean.getDepartmentname());
		preparedStatement.setInt(2, departmentBean.getDepartmentid());
		rows = preparedStatement.executeUpdate();

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int fetchDepartmentRows() throws Exception {
		int rows=0;
		connection=dbUtil.getConnection();
		String sql="select count(*) from department";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			rows=resultSet.getInt(1);
		}
		
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean()
			throws Exception {
		List<Department_EmployeeBean> department_EmployeeBeanList=null;
		Department_EmployeeBean department_EmployeeBean = null;
		connection = dbUtil.getConnection();
		String sql = "select  d.departmentid,d.departmentname,e.employeeid,e.employeename from department d,employee e where d.departmentid=e.departmentid";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();

		department_EmployeeBeanList = new ArrayList<Department_EmployeeBean>();
		while (resultSet.next()) {
			department_EmployeeBean = new Department_EmployeeBean();
			department_EmployeeBean.setDepartmentid(resultSet.getInt("departmentid"));
			department_EmployeeBean.setDepartmentname(resultSet.getString("departmentname"));
			department_EmployeeBean.setEmployeeid(resultSet.getInt("employeeid"));
			department_EmployeeBean.setEmployeename(resultSet.getString("employeename"));
		    
			department_EmployeeBeanList.add(department_EmployeeBean);

		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return department_EmployeeBeanList;
	}

	@Override
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean2() throws Exception{
	List<Department_EmployeeBean> department_EmployeeBeanList2=null;
	Department_EmployeeBean department_EmployeeBean = null;
	connection = dbUtil.getConnection();
	String sql = "select  d.departmentid,d.departmentname,e.employeeid,e.employeename from department d,employee e where d.departmentid=e.departmentid group by d.departmentid";
	preparedStatement = connection.prepareStatement(sql);
	resultSet = preparedStatement.executeQuery();

	department_EmployeeBeanList2 = new ArrayList<Department_EmployeeBean>();
	while (resultSet.next()) {
		department_EmployeeBean = new Department_EmployeeBean();
		department_EmployeeBean.setDepartmentid(resultSet.getInt("departmentid"));
		department_EmployeeBean.setDepartmentname(resultSet.getString("departmentname"));
		department_EmployeeBean.setEmployeeid(resultSet.getInt("employeeid"));
		department_EmployeeBean.setEmployeename(resultSet.getString("employeename"));
    
		department_EmployeeBeanList2.add(department_EmployeeBean);

	}
	dbUtil.closeDBResource(connection, preparedStatement, resultSet);
	return department_EmployeeBeanList2;
	}

}
