package com.meeting.biz;

import java.util.List;

import com.meeting.bean.MeetingRoomBean;

/**
 * 
 * @author �����
 * @���� ���ڻ����ҵ��߼�ҵ�����
 * 
 *
 */
public interface MeetingRoomBiz {
	/**
	 * @���� ��ӻ�����
	 * @author �����
	 * @param meetingroomBean
	 * @return 1--�ɹ� 2--ʧ��
	 */
	public int addMeetingroom(MeetingRoomBean meetingroomBean);

	/**
	 * @���� �������л�������Ϣ
	 * @author �����
	 * @param pageno
	 * @return ���л�������Ϣ
	 */
	public List<MeetingRoomBean> fetchAllMeetingRoom(int pageno);

	/**
	 * @���� ��ѯ���������Ҿ�����Ϣ
	 * @author �����
	 * @param roomnumber
	 * @return ���������ҵľ�����Ϣ
	 */
	public MeetingRoomBean fetchMeetingRoombyRoomnumber(int roomnumber);

	/**
	 * @���� �޸Ļ�������Ϣ
	 * @author �����
	 * @param meetingroomBean
	 * @return 1--�ɹ� 0--ʧ��
	 */
	public int updateMeetingroom(MeetingRoomBean meetingroomBean);

	/**
	 * @���� ɾ��һ�������ҵ�������Ϣ
	 * @author �����
	 * @param roomnumber
	 * @return 1--�ɹ� 0--ʧ��
	 */
	public int dropMeetingroomByroomnumber(int roomnumber);

	/**
	 * @���� ��ѯ�ж��ٸ������� ����ʵ�ַ�ҳ
	 * @author �����
	 * @return
	 */
	public int fetchMeetingRows();

	/**
	 * @���� ͨ������������ѯ�����ұ�� ����ʵ�ֲ���
	 * @author �����
	 * @param capacity
	 * @return 0--û�в鵽 x--�����ұ��
	 */
	public int fetchCapacityByroomnumber(String capacity);

}
