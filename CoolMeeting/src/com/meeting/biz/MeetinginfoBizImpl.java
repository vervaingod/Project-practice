package com.meeting.biz;

import java.util.List;

import com.meeting.bean.MeetinginfoBean;
import com.meeting.dao.MeetinginfoDao;
import com.meeting.dao.MeetinginfoDaoImpl;

/**
 * @see ������Ϣ����ҵ���ӿڵľ���ʵ���࣬���ڷ�װ������Ϣ��ӡ��������鿴�Ȳ���ʵ�ַ���
 * @author ���ࡢ������
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
