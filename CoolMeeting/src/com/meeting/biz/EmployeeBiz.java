package com.meeting.biz;

import java.util.List;

import com.meeting.bean.EmployeeBean;

/**
 * @see Ա������ҵ���ӿڣ����ڷ�װԱ����ز���
 * @author ����š�������������ǰ
 * @since 2015-08-29
 * @version V1.0
 */
public interface EmployeeBiz {

	/**
	 * @see Ա����¼
	 * @author �����
	 * @param employeeBean
	 *            Ա����
	 * @return employeebean2 = null--��¼ʧ�� employeebean2 ��Ϊnull--��¼�ɹ�
	 */
	public EmployeeBean login(EmployeeBean employeeBean);

	/**
	 * @see ���ݴ�ע���ʻ��������Ƿ���ڸ��˻���
	 * @author �����
	 * @param accountname
	 *            �ʻ���
	 * @return id = 0--�����ڸ��˻��� id = 1--���ڸ��˻���
	 */
	public int fetchIdByAccountname(String accountname);

	/**
	 * @see Ա��ע�᷽��
	 * @author �����
	 * @param employeeBean
	 *            Ա����
	 * @return rows = 0--ע��ʧ�� rows = 1--ע��ɹ�
	 */
	public int register(EmployeeBean employeeBean);

	/**
	 * @see �˻��޸����뷽��
	 * @author �����
	 * @param employeeBean
	 *            Ա����
	 * @return result = 0--�޸�ʧ�� result = 1--�޸ĳɹ�
	 */
	public int update(EmployeeBean employeeBean);

	public int deleteEmployee(int id);

	/**
	 * @see ��ѯԱ���������ڷ�ҳ��ʾ
	 * @author ����ǰ
	 * @param employeeBean
	 * @return Ա����
	 */
	public int fetchDepartmentRows();

	/**
	 * @see Ա��ͨ����������
	 * @author ����ǰ
	 * @param id
	 *            Ա��ID
	 * @return 1--ͨ���ɹ� 2--ͨ��ʧ��
	 */
	public int employeeApproval(int id);

	public int CloseEmployeeById(int employeeid);

	/**
	 * @see ��ѯԱ���������ڷ�ҳ��ʾ
	 * @author ������
	 * @param employeeBean
	 * @return Ա����
	 */
	public int fetchEmployeeRows(EmployeeBean employeeBean);

	public List<EmployeeBean> fetchSearchEmployeeList(
			EmployeeBean employeeBean, int pageno);

	/**
	 * @see ����ע���������źŲ����Ƿ���ڸò���
	 * @author �����
	 * @param departmentid
	 *            ���ź�
	 * @return result = false--�����ڸò��� result = true--���ڸò���
	 */
	public boolean fetchIdByDepartmentId(int departmentid);

	/**
	 * @see ͨ����¼�˻����Ҹ��û�ԭʼ����
	 * @author �����
	 * @param current_accountname
	 *            ��ǰ��¼�˻���
	 * @return temp_pwd �˻�ԭʼ����
	 */
	public String fetchPwdByAccountname(String current_accountname);

	/**
	 * 
	 * @���� ��ȡ�μӻ�����Ա��Ϣ
	 * @author ����
	 * @param parseInt
	 *            ��ػ�����Ա���
	 * @return �����Ա��Ϣ
	 * @throws Exception
	 */
	public EmployeeBean fetchEmployeeinfoById(int parseInt);

	/**
	 * @see ��ѯ����Ա����Ϣ�Ұ�����ҳ�����Ĵ���
	 * @author ����ǰ
	 * @param pageno
	 *            ��ǰҳ��
	 * @return Ա���б���Ϣ
	 */
	public List<EmployeeBean> fetchAllEmployeeListPagination(int pageno);
}
