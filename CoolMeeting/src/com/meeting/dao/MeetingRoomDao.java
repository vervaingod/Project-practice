package com.meeting.dao;

import java.util.List;

import com.meeting.bean.MeetingRoomBean;

/**
 * 
 * @author 许嘉阳
 * @功能 关于会议室的数据访问借口
 * 
 *
 */
public interface MeetingRoomDao {
	/**
	 * @author 许嘉阳
	 * @param meetingroomBean
	 * @return 1--成功 0--失败
	 * @throws Exception
	 */
	public int addMeetingroom(MeetingRoomBean meetingroomBean) throws Exception;

	/**
	 * @author 许嘉阳
	 * @param pageno
	 * @return 所有会议室信息
	 * @throws Exception
	 */
	public List<MeetingRoomBean> fetchAllMeetingRoom(int pageno)
			throws Exception;

	/**
	 * @author 许嘉阳
	 * @param roomnumber
	 * @return 具体某一个会议室的详细信息
	 * @throws Exception
	 */
	public MeetingRoomBean fetchMeetingRoombyRoomnumber(int roomnumber)
			throws Exception;

	/**
	 * @author 许嘉阳
	 * @param meetingroomBean
	 * @return 1--成功修改一个会议室 0--失败
	 * @throws Exception
	 */
	public int updateMeetingroom(MeetingRoomBean meetingroomBean)
			throws Exception;

	/**
	 * @author 许嘉阳
	 * @param roomnumber
	 * @return 1--成功删除一个会议室 0--失败
	 * @throws Exception
	 */
	public int dropMeetingroomByroomnumber(int roomnumber) throws Exception;

	/**
	 * @author 许嘉阳
	 * @return 会议室的数量
	 * @throws Exception
	 */
	public int fetchMeetingRows() throws Exception;

	/**
	 * @author 许嘉阳
	 * @param capacity
	 * @return 某一个会议室的具体信息
	 * @throws Exception
	 */
	public int fetchCapacityByroomnumber(String capacity) throws Exception;

}
