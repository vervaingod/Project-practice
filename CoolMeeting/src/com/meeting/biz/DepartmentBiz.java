package com.meeting.biz;

import java.util.List;

import com.meeting.bean.DepartmentBean;
import com.meeting.bean.Department_EmployeeBean;

/**
 * @see 部门管理业务层接口，用于封装部门相关操作
 * @author 刘均前、郭怡君
 * @since 2015-08-29
 * @version V1.0
 */
public interface DepartmentBiz {

	/**
	 * @see 添加部门方法
	 * @author 刘均前
	 * @param departmentBean
	 *            部门类
	 * @return 1--添加部门成功 2--添加部门失败
	 */
	public int addDepartment(DepartmentBean departmentBean);

	/**
	 * @see 按部门名称查询该部门ID
	 * @author 刘均前
	 * @param departmentname
	 *            部门名称
	 * @return 部门ID
	 */
	public int fetchIdByDepartmentName(String departmentname);

	/**
	 * @see 查询所有部门的信息
	 * @author 刘均前
	 * @param pageno
	 *            每页包含的信息行数
	 * @return 部门信息列表
	 */
	public List<DepartmentBean> fetchAllDepartments(int pageno);

	/**
	 * @see 按部门ID删除部门信息
	 * @author 刘均前
	 * @param id
	 *            部门ID
	 * @return 1--删除成功 2--删除失败
	 */
	public int deleteDepartmentById(int id);

	/**
	 * @see 按ID查询部门信息
	 * @author 刘均前
	 * @param id
	 *            部门ID
	 * @return 部门实例对象
	 */
	public DepartmentBean fetchDepartmentById(int id);

	/**
	 * @see 修改部门信息
	 * @author 刘均前
	 * @param departmentBean
	 *            部门实例对象
	 * @return 1--修改成功 2--修改失败
	 */
	public int updateDepartment(DepartmentBean departmentBean);

	/**
	 * @see 查询部门数量
	 * @author 刘均前
	 * @return 部门数量
	 */
	public int fetchDepartmentRows();

	/**
	 * @see 查询员工和部门信息
	 * @author 郭怡君
	 * @return 员工信息列表
	 */
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean();

	/**
	 * @see 查询员工和部门信息
	 * @author 郭怡君
	 * @return 员工信息列表
	 */
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean2();

}
