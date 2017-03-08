package com.meeting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meeting.bean.EmployeeBean;
import com.meeting.bean.PageBean;
import com.meeting.util.DBUtil;

/**
 * @see 员工管理的数据库层接口，用于封装员工相关操作
 * @author 李浩榕、郭怡君、刘均前
 * @since 2015-08-29
 * @version V1.0
 */
public class EmployeeDaoImpl implements EmployeeDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public EmployeeBean login(EmployeeBean employeeBean) throws Exception {
		EmployeeBean employeeBean2 = new EmployeeBean();
		connection = dbUtil.getConnection();
		String sql = "select * from employee where accountname=? and password=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, employeeBean.getAccountname());
		preparedStatement.setString(2, employeeBean.getPassword());

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			employeeBean2.setEmployeeid(resultSet.getInt("employeeid"));
			employeeBean2.setEmployeename(resultSet.getString("employeename"));
			employeeBean2.setAccountname(resultSet.getString("accountname"));
			employeeBean2.setPassword(resultSet.getString("password"));
			employeeBean2.setDepartmentid(resultSet.getInt("departmentid"));
			employeeBean2.setPhone(resultSet.getString("phone"));
			employeeBean2.setStatus(resultSet.getInt("status"));
			employeeBean2.setRole(resultSet.getInt("role"));
			employeeBean2.setEmail(resultSet.getString("email"));
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return employeeBean2;
	}

	@Override
	public int fetchIdByAccountname(String accountname) throws Exception {
		int employeeid = 0;
		connection = dbUtil.getConnection();
		String sql = "select employeeid from employee where accountname=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, accountname);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			employeeid = resultSet.getInt("employeeid");
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return employeeid;
	}

	@Override
	public int register(EmployeeBean employeeBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "insert into employee (employeename,accountname,password,phone,email,departmentid) values(?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, employeeBean.getEmployeename());
		preparedStatement.setString(2, employeeBean.getAccountname());
		preparedStatement.setString(3, employeeBean.getPassword());
		preparedStatement.setString(4, employeeBean.getPhone());
		preparedStatement.setString(5, employeeBean.getEmail());
		preparedStatement.setInt(6, employeeBean.getDepartmentid());

		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int update(EmployeeBean employeeBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();

		String sql = "update employee set password=? where accountname=?";

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, employeeBean.getPassword());
		preparedStatement.setString(2, employeeBean.getAccountname());

		rows = preparedStatement.executeUpdate();

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int deleteEmployee(int id) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "delete from employee where employeeid=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		rows = preparedStatement.executeUpdate();

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int fetchDepartmentRows() throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "select count(*) from employee where status=0";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			rows = resultSet.getInt(1);
		}

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public int employeeApproval(int id) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "update employee set status=1 where employeeid=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		rows = preparedStatement.executeUpdate();

		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public List<EmployeeBean> fetchSearchEmployeeList(
			EmployeeBean employeeBean, int pageno) throws Exception {
		List<EmployeeBean> employeeBeanList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from employee where employeename like ? and status= ? and accountname like ? limit ?,?";
		int startIndex = (pageno - 1) * PageBean.ROWS_PRO_PAGE;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "%" + employeeBean.getEmployeename()
				+ "%");
		preparedStatement.setInt(2, employeeBean.getStatus());
		preparedStatement.setString(3, "%" + employeeBean.getAccountname()
				+ "%");
		preparedStatement.setInt(4, startIndex);
		preparedStatement.setInt(5, PageBean.ROWS_PRO_PAGE);
		resultSet = preparedStatement.executeQuery();
		employeeBeanList = new ArrayList<EmployeeBean>();
		while (resultSet.next()) {
			EmployeeBean employeeBean2 = new EmployeeBean();
			employeeBean2.setEmployeename(resultSet.getString("employeename"));
			employeeBean2.setAccountname(resultSet.getString("accountname"));
			employeeBean2.setPhone(resultSet.getString("phone"));
			employeeBean2.setEmail(resultSet.getString("email"));
			employeeBean2.setEmployeeid(resultSet.getInt("employeeid"));
			employeeBeanList.add(employeeBean2);
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);

		return employeeBeanList;
	}

	@Override
	public int fetchEmployeeRows(EmployeeBean employeeBean) throws Exception {
		int employeeRows = 0;
		connection = dbUtil.getConnection();
		String sql = "select count(*) from employee where employeename like ? and status= ? and accountname like ? ";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "%" + employeeBean.getEmployeename()
				+ "%");
		preparedStatement.setInt(2, employeeBean.getStatus());
		preparedStatement.setString(3, "%" + employeeBean.getAccountname()
				+ "%");
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			employeeRows = resultSet.getInt(1);
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);

		return employeeRows;

	}

	@Override
	public int CloseEmployeeById(int employeeid) throws Exception {
		int rows = 0;

		connection = dbUtil.getConnection();
		String sql = "update employee set status=2 where employeeid=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, employeeid);

		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);

		return rows;
	}

	@Override
	public String fetchPwdByAccountname(String current_accountname)
			throws Exception {
		String password = null;
		connection = dbUtil.getConnection();
		String sql = "select password from employee where accountname=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, current_accountname);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			password = resultSet.getString("password");
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return password;
	}

	@Override
	public boolean fetchIdByDepartmentId(int departmentid) throws Exception {
		boolean result = false;
		connection = dbUtil.getConnection();
		String sql = "select departmentid from department where departmentid=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, departmentid);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			result = true;
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return result;
	}

	public EmployeeBean fetchEmployeeinfoById(int parseInt) throws Exception {
		EmployeeBean employeeBean = null;
		connection = dbUtil.getConnection();
		String sql = "select * from employee where employeeid = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, parseInt);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			employeeBean = new EmployeeBean();
			employeeBean.setAccountname(resultSet.getString("accountname"));
			employeeBean.setPhone(resultSet.getString("phone"));
			employeeBean.setEmail(resultSet.getString("email"));
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return employeeBean;
	}

	@Override
	public List<EmployeeBean> fetchAllEmployeeListPagination(int pageno)
			throws Exception {
		List<EmployeeBean> employeeBeanList = null;

		connection = dbUtil.getConnection();
		String sql = "select * from employee where status=0 limit ?,?";
		preparedStatement = connection.prepareStatement(sql);
		int startIndex = (pageno - 1) * PageBean.ROWS_PRO_PAGE;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, startIndex);
		preparedStatement.setInt(2, PageBean.ROWS_PRO_PAGE);

		resultSet = preparedStatement.executeQuery();

		employeeBeanList = new ArrayList<EmployeeBean>();
		while (resultSet.next()) {
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployeeid(resultSet.getInt("employeeid"));
			employeeBean.setEmployeename(resultSet.getString("employeename"));
			employeeBean.setAccountname(resultSet.getString("accountname"));
			employeeBean.setPassword(resultSet.getString("password"));
			employeeBean.setDepartmentid(resultSet.getInt("departmentid"));
			employeeBean.setPhone(resultSet.getString("phone"));
			employeeBean.setEmail(resultSet.getString("email"));
			employeeBean.setStatus(resultSet.getInt("status"));
			employeeBean.setRole(resultSet.getInt("role"));

			employeeBeanList.add(employeeBean);
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return employeeBeanList;
	}
}
