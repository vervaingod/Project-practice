package com.meeting.biz;

import java.util.List;

import com.meeting.bean.EmployeeBean;
import com.meeting.dao.EmployeeDao;
import com.meeting.dao.EmployeeDaoImpl;

public class EmployeeBizImpl implements EmployeeBiz {
	EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public EmployeeBean login(EmployeeBean employeeBean) {
		EmployeeBean employeeBean2 = null;
		try {
			employeeBean2 = employeeDao.login(employeeBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeBean2;
	}

	@Override
	public int fetchIdByAccountname(String accountname) {
		int id = 0;
		try {
			id = employeeDao.fetchIdByAccountname(accountname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public int register(EmployeeBean employeeBean) {
		int rows = 0;
		try {
			rows = employeeDao.register(employeeBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int update(EmployeeBean employeeBean) {
		int result = 0;
		try {
			result = employeeDao.update(employeeBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteEmployee(int id) {
		int rows = 0;
		try {
			rows = employeeDao.deleteEmployee(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int fetchDepartmentRows() {
		int rows = 0;
		try {
			rows = employeeDao.fetchDepartmentRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int employeeApproval(int id) {
		int rows = 0;
		try {
			rows = employeeDao.employeeApproval(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int fetchEmployeeRows(EmployeeBean employeeBean) {
		int employeeRows = 0;
		try {
			employeeRows = employeeDao.fetchEmployeeRows(employeeBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeRows;
	}

	@Override
	public List<EmployeeBean> fetchSearchEmployeeList(
			EmployeeBean employeeBean, int pageno) {
		List<EmployeeBean> employeeBeanList = null;
		try {
			employeeBeanList = employeeDao.fetchSearchEmployeeList(
					employeeBean, pageno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeBeanList;
	}

	@Override
	public int CloseEmployeeById(int employeeid) {
		int rows = 0;
		try {
			rows = employeeDao.CloseEmployeeById(employeeid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public String fetchPwdByAccountname(String current_accountname) {
		String temp_pwd = null;
		try {
			temp_pwd = employeeDao.fetchPwdByAccountname(current_accountname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp_pwd;
	}

	@Override
	public boolean fetchIdByDepartmentId(int departmentid) {
		boolean result = false;
		try {
			result = employeeDao.fetchIdByDepartmentId(departmentid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public EmployeeBean fetchEmployeeinfoById(int parseInt) {
		EmployeeBean employeeBean = null;
		try {
			employeeBean = employeeDao.fetchEmployeeinfoById(parseInt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeBean;
	}

	@Override
	public List<EmployeeBean> fetchAllEmployeeListPagination(int pageno) {
		List<EmployeeBean> employeeBeanList = null;
		try {
			employeeBeanList = employeeDao
					.fetchAllEmployeeListPagination(pageno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeBeanList;
	}
}
