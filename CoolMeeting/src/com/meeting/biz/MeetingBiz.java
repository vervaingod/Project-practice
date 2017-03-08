package com.meeting.biz;

import java.util.List;

import com.meeting.bean.MeetinginfoBean;

/**
 * 
 * @author ����
 * @���ܣ�ʵ�ֻ�����Ϣ��ع���
 */
public interface MeetingBiz {
	/**
	 * 
	 * @���� ��ȡ���л�����Ϣ
	 * @return ������Ϣ����
	 * @throws Exception
	 */
	public List<MeetinginfoBean> fetchAllMeetingsinfoList();

	/**
	 * 
	 * @���� ��ȡδȡ������ȡ����ػ��鼯��
	 * @param ��ǰ����״̬
	 * @return ��ػ�����Ϣ����
	 * @throws Exception
	 */
	public List<MeetinginfoBean> fetchAllMeetingsinfoListByStatus(int i);

	/**
	 * 
	 * @���� ���ݻ����Ż�ȡ��ǰ������Ϣ
	 * @param id
	 *            ��ػ�����
	 * @return ��ػ�����Ϣ
	 * @throws Exception
	 */
	public MeetinginfoBean fetchMeetinginfoById(int id);

	/**
	 * 
	 * @���� ȡ����ػ���
	 * @param meetinginfoBean
	 *            ȡ���������Ϣ
	 * @return 0-ȡ��ʧ�ܣ�1-ȡ���ɹ�
	 * @throws Exception
	 */
	public int cancelMeeting(MeetinginfoBean meetinginfoBean);

}
