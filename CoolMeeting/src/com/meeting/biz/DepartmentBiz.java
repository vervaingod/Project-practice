package com.meeting.biz;

import java.util.List;

import com.meeting.bean.DepartmentBean;
import com.meeting.bean.Department_EmployeeBean;

/**
 * @see ���Ź���ҵ���ӿڣ����ڷ�װ������ز���
 * @author ����ǰ��������
 * @since 2015-08-29
 * @version V1.0
 */
public interface DepartmentBiz {

	/**
	 * @see ��Ӳ��ŷ���
	 * @author ����ǰ
	 * @param departmentBean
	 *            ������
	 * @return 1--��Ӳ��ųɹ� 2--��Ӳ���ʧ��
	 */
	public int addDepartment(DepartmentBean departmentBean);

	/**
	 * @see ���������Ʋ�ѯ�ò���ID
	 * @author ����ǰ
	 * @param departmentname
	 *            ��������
	 * @return ����ID
	 */
	public int fetchIdByDepartmentName(String departmentname);

	/**
	 * @see ��ѯ���в��ŵ���Ϣ
	 * @author ����ǰ
	 * @param pageno
	 *            ÿҳ��������Ϣ����
	 * @return ������Ϣ�б�
	 */
	public List<DepartmentBean> fetchAllDepartments(int pageno);

	/**
	 * @see ������IDɾ��������Ϣ
	 * @author ����ǰ
	 * @param id
	 *            ����ID
	 * @return 1--ɾ���ɹ� 2--ɾ��ʧ��
	 */
	public int deleteDepartmentById(int id);

	/**
	 * @see ��ID��ѯ������Ϣ
	 * @author ����ǰ
	 * @param id
	 *            ����ID
	 * @return ����ʵ������
	 */
	public DepartmentBean fetchDepartmentById(int id);

	/**
	 * @see �޸Ĳ�����Ϣ
	 * @author ����ǰ
	 * @param departmentBean
	 *            ����ʵ������
	 * @return 1--�޸ĳɹ� 2--�޸�ʧ��
	 */
	public int updateDepartment(DepartmentBean departmentBean);

	/**
	 * @see ��ѯ��������
	 * @author ����ǰ
	 * @return ��������
	 */
	public int fetchDepartmentRows();

	/**
	 * @see ��ѯԱ���Ͳ�����Ϣ
	 * @author ������
	 * @return Ա����Ϣ�б�
	 */
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean();

	/**
	 * @see ��ѯԱ���Ͳ�����Ϣ
	 * @author ������
	 * @return Ա����Ϣ�б�
	 */
	public List<Department_EmployeeBean> fetchAllDepartment_EmployeeBean2();

}
