package com.meeting.biz;

import java.util.List;

import com.meeting.bean.MeetinginfoBean;
import com.meeting.dao.MeetinginfoDao;
import com.meeting.dao.MeetinginfoDaoImpl;

/**
 * @see 会议信息管理业务层接口的具体实现类，用于封装会议信息添加、搜索、查看等操作实现方法
 * @author 赵燕、郭怡君
 * @since 2015-08-29
 * @version V1.0
 */
public class MeetinginfoBizImpl implements MeetinginfoBiz {
	MeetinginfoDao meetinginfoDao = new MeetinginfoDaoImpl();

	@Override
	public int fetchRoomstatusBycapacity(String capacity) {
		int roomstatus = 0;
		try {
			roomstatus = meetinginfoDao.fetchRoomstatusBycapacity(capacity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomstatus;
	}

	@Override
	public int addMeetinginfo(MeetinginfoBean meetinginfoBean) {
		int rows = 0;
		try {
			rows = meetinginfoDao.addMeetinginfo(meetinginfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public List<MeetinginfoBean> fetchMyBookingList() {
		List<MeetinginfoBean> meetinginfoBeanList = null;
		try {
			meetinginfoBeanList = meetinginfoDao.fetchMyBookingList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetinginfoBeanList;
	}

	@Override
	public List<MeetinginfoBean> fetchSearchMeetingList(
			MeetinginfoBean meetinginfoBean, int pageno) {
		List<MeetinginfoBean> meetinginfoBeanList = null;
		try {
			meetinginfoBeanList = meetinginfoDao.fetchSearchMeetingList(
					meetinginfoBean, pageno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetinginfoBeanList;
	}

	@Override
	public int fetchMeetinginfoRows(MeetinginfoBean meetinginfoBean) {
		int meetinginfoRows = 0;
		try {
			meetinginfoRows = meetinginfoDao
					.fetchMeetinginfoRows(meetinginfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetinginfoRows;
	}

}
