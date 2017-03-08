package com.meeting.biz;

import java.util.List;

import com.meeting.bean.MeetinginfoBean;

/**
 * 
 * @author 李岩
 * @功能：实现会议信息相关功能
 */
public interface MeetingBiz {
	/**
	 * 
	 * @功能 获取所有会议信息
	 * @return 会议信息集合
	 * @throws Exception
	 */
	public List<MeetinginfoBean> fetchAllMeetingsinfoList();

	/**
	 * 
	 * @功能 获取未取消和已取消相关会议集合
	 * @param 当前会议状态
	 * @return 相关会议信息集合
	 * @throws Exception
	 */
	public List<MeetinginfoBean> fetchAllMeetingsinfoListByStatus(int i);

	/**
	 * 
	 * @功能 根据会议编号获取当前会议信息
	 * @param id
	 *            相关会议编号
	 * @return 相关会议信息
	 * @throws Exception
	 */
	public MeetinginfoBean fetchMeetinginfoById(int id);

	/**
	 * 
	 * @功能 取消相关会议
	 * @param meetinginfoBean
	 *            取消会议的信息
	 * @return 0-取消失败，1-取消成功
	 * @throws Exception
	 */
	public int cancelMeeting(MeetinginfoBean meetinginfoBean);

}
