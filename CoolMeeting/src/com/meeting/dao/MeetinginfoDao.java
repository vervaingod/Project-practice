package com.meeting.dao;

import java.util.List;

import com.meeting.bean.MeetinginfoBean;

/**
 * @see ������Ϣ�������ݿ��ӿڣ����ڷ�װ������Ϣ�����ݿ������ʵ�ַ���
 * @author ���ࡢ������
 * @since 2015-08-29
 * @version V1.0
 */
public interface MeetinginfoDao {
	/**
	 * @���ܣ����ڰ�����������ѯ�����ҵ�״̬
	 * @���� ������
	 * @����ֵ 1--ʹ��״̬ 0--δʹ��״̬
	 * @throws Exception
	 *             �������쳣���׸��ϲ������
	 */

	public int fetchRoomstatusBycapacity(String capacity) throws Exception;

	/**
	 * @���ܣ�������ӻ���Ԥ����Ϣ
	 * @���� ������
	 * @����ֵ 1--�����Ϣ�ɹ� 0--�����Ϣʧ��
	 * @throws Exception
	 *             �������쳣���׸��ϲ������
	 */

	public int addMeetinginfo(MeetinginfoBean meetinginfoBean) throws Exception;

	/**
	 * @���ܣ���������ҵ�Ԥ��������Ϣ��ѯ
	 * @���� ����
	 * @����ֵ null--���ݲ�ѯʧ�� ��Ϊnull--���ݲ�ѯ�ɹ�
	 * @throws Exception
	 *             �������쳣���׸��ϲ������
	 */
	public List<MeetinginfoBean> fetchMyBookingList() throws Exception;

	/**
	 * @���ܣ�������������������������ķ���
	 * @���� ����
	 * @���� meetinginfoBean �����¼��Ϣ��ʵ������
	 * @����ֵ 0--����ʧ�� 1--���سɹ�
	 * @throws Exception
	 *             �������쳣���׸��ϲ������
	 */
	public int fetchMeetinginfoRows(MeetinginfoBean meetinginfoBean)
			throws Exception;

	/**
	 * @���ܣ�������ɻ���������Ϣ��ѯ
	 * @���� ����
	 * @���� meetinginfoBean �����¼��Ϣ��ʵ������ pageno ����ҳ���Ĵ�С
	 * @����ֵ null--���ݲ�ѯʧ�� ��Ϊnull--���ݲ�ѯ�ɹ�
	 * @throws Exception
	 *             �������쳣���׸��ϲ������
	 */
	public List<MeetinginfoBean> fetchSearchMeetingList(
			MeetinginfoBean meetinginfoBean, int pageno) throws Exception;
}
