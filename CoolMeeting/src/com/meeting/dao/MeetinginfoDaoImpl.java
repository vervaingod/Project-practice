package com.meeting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meeting.bean.MeetinginfoBean;
import com.meeting.bean.PageBean;
import com.meeting.util.DBUtil;

/**
 * @see 会议信息管理数据库层接口，用于封装会议信息与数据库操作的实现方法
 * @author 赵燕、郭怡君
 * @since 2015-08-29
 * @version V1.0
 */
public class MeetinginfoDaoImpl implements MeetinginfoDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public int fetchRoomstatusBycapacity(String capacity) throws Exception {
		int roomstatus = 0;
		connection = dbUtil.getConnection();
		String sql = "select status from meetingroom  where capacity=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, capacity);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			roomstatus = resultSet.getInt("status");
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return roomstatus;
	}

	@Override
	public int addMeetinginfo(MeetinginfoBean meetinginfoBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "insert into meetinginfo(meetingname,numofattendents,startdate,enddate,capacity,accountname,description,adddate,selectEmployees) values (?,?,?,?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, meetinginfoBean.getMeetingname());
		preparedStatement.setInt(2, meetinginfoBean.getNumofattendents());
		preparedStatement.setString(3, meetinginfoBean.getStartdate());
		preparedStatement.setString(4, meetinginfoBean.getEnddate());
		preparedStatement.setString(5, meetinginfoBean.getCapacity());
		preparedStatement.setString(6, meetinginfoBean.getAccountname());
		preparedStatement.setString(7, meetinginfoBean.getDescription());
		preparedStatement.setString(8, meetinginfoBean.getAdddate());
		preparedStatement.setString(9, meetinginfoBean.getSelectEmployees());
		System.out.println(rows);
		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	@Override
	public List<MeetinginfoBean> fetchMyBookingList() throws Exception {
		List<MeetinginfoBean> meetinginfoBeanList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from meetinginfo where meetingstatus=1";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		meetinginfoBeanList = new ArrayList<MeetinginfoBean>();
		while (resultSet.next()) {
			MeetinginfoBean meetinginfoBean = new MeetinginfoBean();
			meetinginfoBean.setMeetingid(resultSet.getInt("meetingid"));
			meetinginfoBean.setMeetingname(resultSet.getString("meetingname"));
			meetinginfoBean.setCapacity(resultSet.getString("capacity"));
			meetinginfoBean.setStartdate(resultSet.getString("startdate"));
			meetinginfoBean.setEnddate(resultSet.getString("enddate"));
			meetinginfoBean.setAdddate(resultSet.getString("adddate")); 
			meetinginfoBeanList.add(meetinginfoBean); 
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return meetinginfoBeanList;
	}

	@Override
	public List<MeetinginfoBean> fetchSearchMeetingList(
			MeetinginfoBean meetinginfoBean, int pageno) throws Exception {
		List<MeetinginfoBean> meetinginfoBeanList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from meetinginfo where meetingname like ? and "
				+ "capacity like ? and accountname like ? and adddate like ? and "
				+ "startdate like ? and enddate like ? limit ?,?";
		int startIndex = (pageno - 1) * PageBean.ROWS_PRO_PAGE;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "%" + meetinginfoBean.getMeetingname()
				+ "%");
		preparedStatement.setString(2, "%" + meetinginfoBean.getCapacity()
				+ "%");
		preparedStatement.setString(3, "%" + meetinginfoBean.getAccountname()
				+ "%");
		preparedStatement
				.setString(4, "%" + meetinginfoBean.getAdddate() + "%");
		preparedStatement.setString(5, "%" + meetinginfoBean.getStartdate()
				+ "%");
		preparedStatement
				.setString(6, "%" + meetinginfoBean.getEnddate() + "%");
		preparedStatement.setInt(7, startIndex);
		preparedStatement.setInt(8, PageBean.ROWS_PRO_PAGE);
		resultSet = preparedStatement.executeQuery(); 
		meetinginfoBeanList = new ArrayList<MeetinginfoBean>();
		while (resultSet.next()) {
			MeetinginfoBean meetinginfoBean2 = new MeetinginfoBean();
			meetinginfoBean2.setMeetingid(resultSet.getInt("meetingid"));
			meetinginfoBean2.setMeetingname(resultSet.getString("meetingname"));
			meetinginfoBean2.setCapacity(resultSet.getString("capacity"));
			meetinginfoBean2.setAccountname(resultSet.getString("accountname"));
			meetinginfoBean2.setAdddate(resultSet.getString("adddate"));
			meetinginfoBean2.setStartdate(resultSet.getString("startdate"));
			meetinginfoBean2.setEnddate(resultSet.getString("enddate")); 
			meetinginfoBeanList.add(meetinginfoBean2); 
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet); 
		return meetinginfoBeanList;
	}

	@Override
	public int fetchMeetinginfoRows(MeetinginfoBean meetinginfoBean)
			throws Exception {
		int meetinginfoRows = 0;
		connection = dbUtil.getConnection();
		String sql = "select count(*) from meetinginfo where meetingname like ?"
				+ " and capacity like ? and accountname like ? and adddate like ? "
				+ "and startdate like ? and enddate like ?";
		preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setString(1, "%" + meetinginfoBean.getMeetingname()
				+ "%");
		preparedStatement.setString(2, "%" + meetinginfoBean.getCapacity()
				+ "%");
		preparedStatement.setString(3, "%" + meetinginfoBean.getAccountname()
				+ "%");
		preparedStatement
				.setString(4, "%" + meetinginfoBean.getAdddate() + "%");
		preparedStatement.setString(5, "%" + meetinginfoBean.getStartdate()
				+ "%");
		preparedStatement
				.setString(6, "%" + meetinginfoBean.getEnddate() + "%");
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			meetinginfoRows = resultSet.getInt(1);
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return meetinginfoRows;
	}

}
