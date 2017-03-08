package com.meeting.biz;

import java.util.List;

import com.meeting.bean.MeetingRoomBean;

/**
 * 
 * @author 许嘉阳
 * @功能 关于会议室的逻辑业务层借口
 * 
 *
 */
public interface MeetingRoomBiz {
	/**
	 * @功能 添加会议室
	 * @author 许嘉阳
	 * @param meetingroomBean
	 * @return 1--成功 2--失败
	 */
	public int addMeetingroom(MeetingRoomBean meetingroomBean);

	/**
	 * @功能 搜索所有会议室信息
	 * @author 许嘉阳
	 * @param pageno
	 * @return 所有会议室信息
	 */
	public List<MeetingRoomBean> fetchAllMeetingRoom(int pageno);

	/**
	 * @功能 查询单个会议室具体信息
	 * @author 许嘉阳
	 * @param roomnumber
	 * @return 单个会议室的具体信息
	 */
	public MeetingRoomBean fetchMeetingRoombyRoomnumber(int roomnumber);

	/**
	 * @功能 修改会议室信息
	 * @author 许嘉阳
	 * @param meetingroomBean
	 * @return 1--成功 0--失败
	 */
	public int updateMeetingroom(MeetingRoomBean meetingroomBean);

	/**
	 * @功能 删除一个会议室的所有信息
	 * @author 许嘉阳
	 * @param roomnumber
	 * @return 1--成功 0--失败
	 */
	public int dropMeetingroomByroomnumber(int roomnumber);

	/**
	 * @功能 查询有多少个会议室 用来实现分页
	 * @author 许嘉阳
	 * @return
	 */
	public int fetchMeetingRows();

	/**
	 * @功能 通过会议室名查询会议室编号 用来实现查重
	 * @author 许嘉阳
	 * @param capacity
	 * @return 0--没有查到 x--会议室编号
	 */
	public int fetchCapacityByroomnumber(String capacity);

}
