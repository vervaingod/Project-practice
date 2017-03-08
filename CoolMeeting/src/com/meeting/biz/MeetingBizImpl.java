package com.meeting.biz;

import java.util.List;

import com.meeting.bean.MeetinginfoBean;
import com.meeting.dao.MeetingDao;
import com.meeting.dao.MeetingDaoImpl;

public class MeetingBizImpl implements MeetingBiz {

	MeetingDao meetingDao = new MeetingDaoImpl();

	public List<MeetinginfoBean> fetchAllMeetingsinfoList() {
		List<MeetinginfoBean> meetinginfoBeanList = null;
		try {
			meetinginfoBeanList = meetingDao.fetchAllMeetingsinfoList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetinginfoBeanList;
	}

	public List<MeetinginfoBean> fetchAllMeetingsinfoListByStatus(int i) {
		List<MeetinginfoBean> meetinginfoBeanList = null;
		try {
			meetinginfoBeanList = meetingDao.fetchAllMeetingsinfoList(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetinginfoBeanList;
	}

	public MeetinginfoBean fetchMeetinginfoById(int id) {
		MeetinginfoBean meetinginfoBean = null;
		try {
			meetinginfoBean = meetingDao.fetchMeetinginfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetinginfoBean;
	}

	public int cancelMeeting(MeetinginfoBean meetinginfoBean) {
		int rows = 0;
		try {
			rows = meetingDao.cancelMeeting(meetinginfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

}
