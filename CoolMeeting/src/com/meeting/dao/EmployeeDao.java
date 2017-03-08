package com.meeting.dao;

import java.util.List;

import com.meeting.bean.EmployeeBean;

public interface EmployeeDao {

	/**
	 * @see 实现登录功能
	 * @author 李浩榕
	 * @param employeeBean
	 *            员工类
	 * @return employeebean2 = null--登录失败 employeebean2 不为null--登录成功
	 */
	public EmployeeBean login(EmployeeBean employeeBean) throws Exception;

	/**
	 * @see 根据待注册帐户名查找是否存在该账户名
	 * @author 李浩榕
	 * @param accountname
	 *            帐户名
	 * @return employeeid = 0--不存在该账户名 employeeid = 1--存在该账户名
	 * @throws Exception
	 */
	public int fetchIdByAccountname(String accountname) throws Exception;

	/**
	 * @see 员工注册
	 * @author 李浩榕
	 * @param employeeBean
	 *            员工类
	 * @return rows = 0--注册失败 rows = 1--注册成功
	 * @throws Exception
	 */
	public int register(EmployeeBean employeeBean) throws Exception;

	/**
	 * @see 账户修改密码
	 * @author 李浩榕
	 * @param employeeBean
	 *            员工类
	 * @return rows = 0--修改失败 rows = 1--修改成功
	 * @throws Exception
	 */
	public int update(EmployeeBean employeeBean) throws Exception;

	public int deleteEmployee(int id) throws Exception;

	public int fetchDepartmentRows() throws Exception;

	public int employeeApproval(int id) throws Exception;

	public List<EmployeeBean> fetchSearchEmployeeList(
			EmployeeBean employeeBean, int pageno) throws Exception;

	public int fetchEmployeeRows(EmployeeBean employeeBean) throws Exception;

	public int CloseEmployeeById(int employeeid) throws Exception;

	/**
	 * @see 通过登录账户查找该用户原始密码
	 * @author 李浩榕
	 * @param current_accountname
	 *            登录账户名
	 * @return password 账户密码
	 * @throws Exception
	 */
	public String fetchPwdByAccountname(String current_accountname)
			throws Exception;

	/**
	 * @see 根据注册所属部门号查找是否存在该部门
	 * @author 李浩榕
	 * @param departmentid
	 *            部门号
	 * @return result = false--不存在该部门 result = true--存在该部门
	 * @throws Exception
	 */
	public boolean fetchIdByDepartmentId(int departmentid) throws Exception;

	/**
	 * 
	 * @功能 获取参加会议人员信息
	 * @param parseInt
	 *            相关会议人员编号
	 * @return 相关人员信息
	 * @throws Exception
	 */
	public EmployeeBean fetchEmployeeinfoById(int parseInt) throws Exception;

	public List<EmployeeBean> fetchAllEmployeeListPagination(int pageno)
			throws Exception;

}
