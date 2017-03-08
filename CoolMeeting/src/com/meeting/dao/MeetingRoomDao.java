package com.meeting.dao;

import java.util.List;

import com.meeting.bean.MeetingRoomBean;

/**
 * 
 * @author �����
 * @���� ���ڻ����ҵ����ݷ��ʽ��
 * 
 *
 */
public interface MeetingRoomDao {
	/**
	 * @author �����
	 * @param meetingroomBean
	 * @return 1--�ɹ� 0--ʧ��
	 * @throws Exception
	 */
	public int addMeetingroom(MeetingRoomBean meetingroomBean) throws Exception;

	/**
	 * @author �����
	 * @param pageno
	 * @return ���л�������Ϣ
	 * @throws Exception
	 */
	public List<MeetingRoomBean> fetchAllMeetingRoom(int pageno)
			throws Exception;

	/**
	 * @author �����
	 * @param roomnumber
	 * @return ����ĳһ�������ҵ���ϸ��Ϣ
	 * @throws Exception
	 */
	public MeetingRoomBean fetchMeetingRoombyRoomnumber(int roomnumber)
			throws Exception;

	/**
	 * @author �����
	 * @param meetingroomBean
	 * @return 1--�ɹ��޸�һ�������� 0--ʧ��
	 * @throws Exception
	 */
	public int updateMeetingroom(MeetingRoomBean meetingroomBean)
			throws Exception;

	/**
	 * @author �����
	 * @param roomnumber
	 * @return 1--�ɹ�ɾ��һ�������� 0--ʧ��
	 * @throws Exception
	 */
	public int dropMeetingroomByroomnumber(int roomnumber) throws Exception;

	/**
	 * @author �����
	 * @return �����ҵ�����
	 * @throws Exception
	 */
	public int fetchMeetingRows() throws Exception;

	/**
	 * @author �����
	 * @param capacity
	 * @return ĳһ�������ҵľ�����Ϣ
	 * @throws Exception
	 */
	public int fetchCapacityByroomnumber(String capacity) throws Exception;

}
