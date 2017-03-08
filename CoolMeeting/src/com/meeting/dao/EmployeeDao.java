package com.meeting.dao;

import java.util.List;

import com.meeting.bean.EmployeeBean;

public interface EmployeeDao {

	/**
	 * @see ʵ�ֵ�¼����
	 * @author �����
	 * @param employeeBean
	 *            Ա����
	 * @return employeebean2 = null--��¼ʧ�� employeebean2 ��Ϊnull--��¼�ɹ�
	 */
	public EmployeeBean login(EmployeeBean employeeBean) throws Exception;

	/**
	 * @see ���ݴ�ע���ʻ��������Ƿ���ڸ��˻���
	 * @author �����
	 * @param accountname
	 *            �ʻ���
	 * @return employeeid = 0--�����ڸ��˻��� employeeid = 1--���ڸ��˻���
	 * @throws Exception
	 */
	public int fetchIdByAccountname(String accountname) throws Exception;

	/**
	 * @see Ա��ע��
	 * @author �����
	 * @param employeeBean
	 *            Ա����
	 * @return rows = 0--ע��ʧ�� rows = 1--ע��ɹ�
	 * @throws Exception
	 */
	public int register(EmployeeBean employeeBean) throws Exception;

	/**
	 * @see �˻��޸�����
	 * @author �����
	 * @param employeeBean
	 *            Ա����
	 * @return rows = 0--�޸�ʧ�� rows = 1--�޸ĳɹ�
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
	 * @see ͨ����¼�˻����Ҹ��û�ԭʼ����
	 * @author �����
	 * @param current_accountname
	 *            ��¼�˻���
	 * @return password �˻�����
	 * @throws Exception
	 */
	public String fetchPwdByAccountname(String current_accountname)
			throws Exception;

	/**
	 * @see ����ע���������źŲ����Ƿ���ڸò���
	 * @author �����
	 * @param departmentid
	 *            ���ź�
	 * @return result = false--�����ڸò��� result = true--���ڸò���
	 * @throws Exception
	 */
	public boolean fetchIdByDepartmentId(int departmentid) throws Exception;

	/**
	 * 
	 * @���� ��ȡ�μӻ�����Ա��Ϣ
	 * @param parseInt
	 *            ��ػ�����Ա���
	 * @return �����Ա��Ϣ
	 * @throws Exception
	 */
	public EmployeeBean fetchEmployeeinfoById(int parseInt) throws Exception;

	public List<EmployeeBean> fetchAllEmployeeListPagination(int pageno)
			throws Exception;

}
