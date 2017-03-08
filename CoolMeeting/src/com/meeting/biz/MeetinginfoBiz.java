package com.meeting.biz;

import java.util.List;

import com.meeting.bean.MeetinginfoBean;

/**
 * @see ������Ϣ����ҵ���ӿڣ����ڷ�װ������Ϣ��ز���
 * @author ���ࡢ������
 * @since 2015-08-29
 * @version V1.0
 */
public interface MeetinginfoBiz {
	/**
	 * @���ܣ����ڰ�����������ѯ�����ҵ�״̬
	 * @���� ������
	 * @����ֵ 1--ʹ��״̬ 0--δʹ��״̬
	 */

	public int fetchRoomstatusBycapacity(String capacity);

	/**
	 * @���ܣ�������ӻ���Ԥ����Ϣ
	 * @���� ������
	 * @����ֵ 1--�����Ϣ�ɹ� 0--�����Ϣʧ��
	 */

	public int addMeetinginfo(MeetinginfoBean meetinginfoBean);

	/**
	 * @���ܣ�����ҵ�Ԥ��������Ϣ��ѯ
	 * @���� ����
	 * @����ֵ null--���ݲ�ѯʧ�� ��Ϊnull--���ݲ�ѯ�ɹ�
	 */
	public List<MeetinginfoBean> fetchMyBookingList();

	/**
	 * @���ܣ���������������������ķ���
	 * @���� ����
	 * @���� meetinginfoBean �����¼��Ϣ��ʵ������
	 * @����ֵ 0--����ʧ�� 1--���سɹ�
	 */
	public int fetchMeetinginfoRows(MeetinginfoBean meetinginfoBean);

	/**
	 * @���ܣ���ɻ���������Ϣ��ѯ
	 * @���� ����
	 * @���� meetinginfoBean �����¼��Ϣ��ʵ������ pageno ����ҳ���Ĵ�С
	 * @����ֵ null--���ݲ�ѯʧ�� ��Ϊnull--���ݲ�ѯ�ɹ�
	 */
	public List<MeetinginfoBean> fetchSearchMeetingList(
			MeetinginfoBean meetinginfoBean, int pageno);
}
