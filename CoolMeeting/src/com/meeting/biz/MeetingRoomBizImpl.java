package com.meeting.biz;

import java.util.List;

import com.meeting.bean.MeetingRoomBean;
import com.meeting.dao.MeetingRoomDao;
import com.meeting.dao.MeetingRoomDaoImpl;

public class MeetingRoomBizImpl implements MeetingRoomBiz {

	MeetingRoomDao meetingroomDao = new MeetingRoomDaoImpl();

	public int addMeetingroom(MeetingRoomBean meetingroomBean) {
		int result = 0;
		try {
			result = meetingroomDao.addMeetingroom(meetingroomBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<MeetingRoomBean> fetchAllMeetingRoom(int pageno) {
		List<MeetingRoomBean> meetingRoomBeanList = null;
		try {
			meetingRoomBeanList = meetingroomDao.fetchAllMeetingRoom(pageno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return meetingRoomBeanList;
	}

	public MeetingRoomBean fetchMeetingRoombyRoomnumber(int roomnumber) {
		MeetingRoomBean meetingRoomBean = null;

		try {
			meetingRoomBean = meetingroomDao
					.fetchMeetingRoombyRoomnumber(roomnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetingRoomBean;
	}

	public int updateMeetingroom(MeetingRoomBean meetingroomBean) {
		int result = 0;
		try {
			result = meetingroomDao.updateMeetingroom(meetingroomBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int dropMeetingroomByroomnumber(int roomnumber) {
		int result = 0;
		try {
			result = meetingroomDao.dropMeetingroomByroomnumber(roomnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int fetchMeetingRows() {
		int meetingroomrows = 0;
		try {
			meetingroomrows = meetingroomDao.fetchMeetingRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetingroomrows;
	}

	
	public int fetchCapacityByroomnumber(String capacity) {
		int reasult = 0;
		try {
			reasult = meetingroomDao.fetchCapacityByroomnumber(capacity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reasult;
	}

}
