package com.meeting.dao;

import java.util.List;

import com.meeting.bean.DepartmentBean;
import com.meeting.bean.Department_EmployeeBean;

/**
 * @see 部门管理数据库层接口，用于封装部门与数据库操作的实现方法
 * @author 刘均前、郭怡君
 * @since 2015-08-29
 * @version V1.0
 */
public interface DepartmentDao {
	
	/**
	 * @see 添加部门
	 * @author 刘均前
	 * @param departmentBean 部门实例对象
	 * @return 1--添加成功  2--添加失败
	 * @throws Exception
	 */
	public int addDepartment(DepartmentBean departmentBean) throws Exception;

	/**
	 * @see 按部门名称查询部门ID
	 * @author 刘均前
	 * @param departmentname 部门名称
	 * @return 部门ID
	 * @throws Exception
	 */
	public int fetchIdByDepartmentName(String departmentname) throws Exception;

	/**
	 * @see 查询所有部门信息
	 * @author 刘均前
	 * @param pageno 分页的当前页码
	 * @return 部门列表
	 * @throws Exception
	 */
	public List<DepartmentBean> fetchAllDepartments(int pageno) throws Exception;

	/**
	 * @see 删除部门
	 * @author 刘均前
	 * @param id 部门ID
	 * @return 1--删除成功  2--删除失败
	 * @throws Exception
	 */
	public int deleteDepartmentById(int id) throws Exception;

	/**
	 * @see 按ID查询部门信息
	 * @author 刘均前
	 * @param id 部门ID
	 * @return 部门实例对象
	 * @throws Exception
	 */
	public DepartmentBean fetchDepartmentById(int id) throws Exception;

	/**
	 * @see 修改部门信息
	 * @author 刘均前
	 * @param departmentBean 部门实例对象
	 * @return 1--修改成功  2--修改失败
	 * @throws Exception
	 */
	public int updateDepartment(DepartmentBean departmentBean) throws Exception;

	/**
	 * @see 查询部门个数
	 * @author 刘均前
	 * @return 部门个数
	 * @throws Exception
	 */
	public int fetchDepartmentRows() throws Exception;

	/**
	 * @see 查询员工和部门信息
	 * @author 郭怡君
	 * @return 员工的信息列表
	 * @throws Exception
	 */
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean()throws Exception;

	/**
	 * @see 查询员工和部门信息
	 * @author 郭怡君
	 * @return 员工信息列表
	 * @throws Exception
	 */
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean2() throws Exception;

}
