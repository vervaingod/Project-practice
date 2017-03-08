package com.meeting.biz;

import java.util.List;

import com.meeting.bean.DepartmentBean;
import com.meeting.bean.Department_EmployeeBean;

import com.meeting.dao.DepartmentDao;
import com.meeting.dao.DepartmentDaoImpl;

/**
 * @see 部门管理业务层接口的具体实现类，用于封装部门具体操作实现方法
 * @author 刘均前、郭怡君
 * @since 2015-08-29
 * @version V1.0
 */
public class DepartmentBizImpl implements DepartmentBiz {
	DepartmentDao departmentDao = new DepartmentDaoImpl();

	@Override
	public int addDepartment(DepartmentBean departmentBean) {
		int rows = 0;

		try {
			rows = departmentDao.addDepartment(departmentBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int fetchIdByDepartmentName(String departmentname) {
		int rows = 0;
		try {
			rows = departmentDao.fetchIdByDepartmentName(departmentname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public List<DepartmentBean> fetchAllDepartments(int pageno) {
		List<DepartmentBean> departmentBeanList = null;
		try {
			departmentBeanList = departmentDao.fetchAllDepartments(pageno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentBeanList;
	}

	@Override
	public int deleteDepartmentById(int id) {
		int rows=0;
		try {
			rows=departmentDao.deleteDepartmentById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public DepartmentBean fetchDepartmentById(int id) {
		DepartmentBean departmentBean=null;
		try {
			departmentBean=departmentDao.fetchDepartmentById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentBean;
	}

	@Override
	public int updateDepartment(DepartmentBean departmentBean) {
		int rows=0;
		try {
			rows=departmentDao.updateDepartment(departmentBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int fetchDepartmentRows() {
		int rows=0;
		try {
			rows=departmentDao.fetchDepartmentRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	
	@Override
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean() {
		
		DepartmentDao departmentDao=new DepartmentDaoImpl();
		List<Department_EmployeeBean> department_EmployeeBeanList=null;
		try {
			department_EmployeeBeanList=departmentDao.fetchAllDepartment_EmployeeBean();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return department_EmployeeBeanList;
	}
	
	@Override
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean2() {
		List<Department_EmployeeBean> department_EmployeeBeanList2=null;
		try {
			department_EmployeeBeanList2=departmentDao.fetchAllDepartment_EmployeeBean2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return department_EmployeeBeanList2;
	}
}
