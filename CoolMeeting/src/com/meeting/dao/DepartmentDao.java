package com.meeting.dao;

import java.util.List;

import com.meeting.bean.DepartmentBean;
import com.meeting.bean.Department_EmployeeBean;

/**
 * @see ���Ź������ݿ��ӿڣ����ڷ�װ���������ݿ������ʵ�ַ���
 * @author ����ǰ��������
 * @since 2015-08-29
 * @version V1.0
 */
public interface DepartmentDao {
	
	/**
	 * @see ��Ӳ���
	 * @author ����ǰ
	 * @param departmentBean ����ʵ������
	 * @return 1--��ӳɹ�  2--���ʧ��
	 * @throws Exception
	 */
	public int addDepartment(DepartmentBean departmentBean) throws Exception;

	/**
	 * @see ���������Ʋ�ѯ����ID
	 * @author ����ǰ
	 * @param departmentname ��������
	 * @return ����ID
	 * @throws Exception
	 */
	public int fetchIdByDepartmentName(String departmentname) throws Exception;

	/**
	 * @see ��ѯ���в�����Ϣ
	 * @author ����ǰ
	 * @param pageno ��ҳ�ĵ�ǰҳ��
	 * @return �����б�
	 * @throws Exception
	 */
	public List<DepartmentBean> fetchAllDepartments(int pageno) throws Exception;

	/**
	 * @see ɾ������
	 * @author ����ǰ
	 * @param id ����ID
	 * @return 1--ɾ���ɹ�  2--ɾ��ʧ��
	 * @throws Exception
	 */
	public int deleteDepartmentById(int id) throws Exception;

	/**
	 * @see ��ID��ѯ������Ϣ
	 * @author ����ǰ
	 * @param id ����ID
	 * @return ����ʵ������
	 * @throws Exception
	 */
	public DepartmentBean fetchDepartmentById(int id) throws Exception;

	/**
	 * @see �޸Ĳ�����Ϣ
	 * @author ����ǰ
	 * @param departmentBean ����ʵ������
	 * @return 1--�޸ĳɹ�  2--�޸�ʧ��
	 * @throws Exception
	 */
	public int updateDepartment(DepartmentBean departmentBean) throws Exception;

	/**
	 * @see ��ѯ���Ÿ���
	 * @author ����ǰ
	 * @return ���Ÿ���
	 * @throws Exception
	 */
	public int fetchDepartmentRows() throws Exception;

	/**
	 * @see ��ѯԱ���Ͳ�����Ϣ
	 * @author ������
	 * @return Ա������Ϣ�б�
	 * @throws Exception
	 */
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean()throws Exception;

	/**
	 * @see ��ѯԱ���Ͳ�����Ϣ
	 * @author ������
	 * @return Ա����Ϣ�б�
	 * @throws Exception
	 */
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean2() throws Exception;

}
