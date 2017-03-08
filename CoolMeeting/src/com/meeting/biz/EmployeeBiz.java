package com.meeting.biz;

import java.util.List;

import com.meeting.bean.EmployeeBean;

/**
 * @see 员工管理业务层接口，用于封装员工相关操作
 * @author 李浩榕、郭怡君、刘均前
 * @since 2015-08-29
 * @version V1.0
 */
public interface EmployeeBiz {

	/**
	 * @see 员工登录
	 * @author 李浩榕
	 * @param employeeBean
	 *            员工类
	 * @return employeebean2 = null--登录失败 employeebean2 不为null--登录成功
	 */
	public EmployeeBean login(EmployeeBean employeeBean);

	/**
	 * @see 根据待注册帐户名查找是否存在该账户名
	 * @author 李浩榕
	 * @param accountname
	 *            帐户名
	 * @return id = 0--不存在该账户名 id = 1--存在该账户名
	 */
	public int fetchIdByAccountname(String accountname);

	/**
	 * @see 员工注册方法
	 * @author 李浩榕
	 * @param employeeBean
	 *            员工类
	 * @return rows = 0--注册失败 rows = 1--注册成功
	 */
	public int register(EmployeeBean employeeBean);

	/**
	 * @see 账户修改密码方法
	 * @author 李浩榕
	 * @param employeeBean
	 *            员工类
	 * @return result = 0--修改失败 result = 1--修改成功
	 */
	public int update(EmployeeBean employeeBean);

	public int deleteEmployee(int id);

	/**
	 * @see 查询员工数，用于分页显示
	 * @author 刘均前
	 * @param employeeBean
	 * @return 员工数
	 */
	public int fetchDepartmentRows();

	/**
	 * @see 员工通过审批方法
	 * @author 刘均前
	 * @param id
	 *            员工ID
	 * @return 1--通过成功 2--通过失败
	 */
	public int employeeApproval(int id);

	public int CloseEmployeeById(int employeeid);

	/**
	 * @see 查询员工数，用于分页显示
	 * @author 郭怡君
	 * @param employeeBean
	 * @return 员工数
	 */
	public int fetchEmployeeRows(EmployeeBean employeeBean);

	public List<EmployeeBean> fetchSearchEmployeeList(
			EmployeeBean employeeBean, int pageno);

	/**
	 * @see 根据注册所属部门号查找是否存在该部门
	 * @author 李浩榕
	 * @param departmentid
	 *            部门号
	 * @return result = false--不存在该部门 result = true--存在该部门
	 */
	public boolean fetchIdByDepartmentId(int departmentid);

	/**
	 * @see 通过登录账户查找该用户原始密码
	 * @author 李浩榕
	 * @param current_accountname
	 *            当前登录账户名
	 * @return temp_pwd 账户原始密码
	 */
	public String fetchPwdByAccountname(String current_accountname);

	/**
	 * 
	 * @功能 获取参加会议人员信息
	 * @author 李岩
	 * @param parseInt
	 *            相关会议人员编号
	 * @return 相关人员信息
	 * @throws Exception
	 */
	public EmployeeBean fetchEmployeeinfoById(int parseInt);

	/**
	 * @see 查询所有员工信息且包含分页方法的处理
	 * @author 刘均前
	 * @param pageno
	 *            当前页数
	 * @return 员工列表信息
	 */
	public List<EmployeeBean> fetchAllEmployeeListPagination(int pageno);
}
