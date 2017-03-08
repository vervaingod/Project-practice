package com.meeting.dao;

import java.util.List;

import com.meeting.bean.MeetinginfoBean;

/**
 * @see 会议信息管理数据库层接口，用于封装会议信息与数据库操作的实现方法
 * @author 赵燕、郭怡君
 * @since 2015-08-29
 * @version V1.0
 */
public interface MeetinginfoDao {
	/**
	 * @功能：用于按会议室名查询会议室的状态
	 * @作者 郭怡君
	 * @返回值 1--使用状态 0--未使用状态
	 * @throws Exception
	 *             若出现异常，抛给上层调用者
	 */

	public int fetchRoomstatusBycapacity(String capacity) throws Exception;

	/**
	 * @功能：用于添加会议预订信息
	 * @作者 郭怡君
	 * @返回值 1--添加信息成功 0--添加信息失败
	 * @throws Exception
	 *             若出现异常，抛给上层调用者
	 */

	public int addMeetinginfo(MeetinginfoBean meetinginfoBean) throws Exception;

	/**
	 * @功能：用于完成我的预订会议信息查询
	 * @作者 赵燕
	 * @返回值 null--数据查询失败 不为null--数据查询成功
	 * @throws Exception
	 *             若出现异常，抛给上层调用者
	 */
	public List<MeetinginfoBean> fetchMyBookingList() throws Exception;

	/**
	 * @功能：用于完成搜索会议数据行数的返回
	 * @作者 赵燕
	 * @参数 meetinginfoBean 会议记录信息的实例对象
	 * @返回值 0--返回失败 1--返回成功
	 * @throws Exception
	 *             若出现异常，抛给上层调用者
	 */
	public int fetchMeetinginfoRows(MeetinginfoBean meetinginfoBean)
			throws Exception;

	/**
	 * @功能：用于完成会议搜索信息查询
	 * @作者 赵燕
	 * @参数 meetinginfoBean 会议记录信息的实例对象 pageno 返回页数的大小
	 * @返回值 null--数据查询失败 不为null--数据查询成功
	 * @throws Exception
	 *             若出现异常，抛给上层调用者
	 */
	public List<MeetinginfoBean> fetchSearchMeetingList(
			MeetinginfoBean meetinginfoBean, int pageno) throws Exception;
}
