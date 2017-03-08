package com.meeting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meeting.bean.MeetingRoomBean;
import com.meeting.bean.PageBean;
import com.meeting.util.DBUtil;
/**
 * 
 * @author 许嘉阳
 * @功能 关于会议室的数据访问的具体实现类
 */

public class MeetingRoomDaoImpl implements MeetingRoomDao {
	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	public int addMeetingroom(MeetingRoomBean meetingroomBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "insert into meetingroom (roomnumber,capacity,roomcapacity,status,note) values(?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, meetingroomBean.getRoomnumber());
		preparedStatement.setString(2, meetingroomBean.getCapacity());
		preparedStatement.setInt(3, meetingroomBean.getRoomcapacity());
		preparedStatement.setInt(4, meetingroomBean.getStatus());
		preparedStatement.setString(5, meetingroomBean.getNote());
		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	public List<MeetingRoomBean> fetchAllMeetingRoom(int pageno) throws Exception {
		connection = dbUtil.getConnection();
		List<MeetingRoomBean> meetingRoomBeanList = null;
		String sql = "select * from meetingroom limit ?,?";
		int startIndex = (pageno - 1) * PageBean.ROWS_PRO_PAGE;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, startIndex);
		preparedStatement.setInt(2, PageBean.ROWS_PRO_PAGE);
		resultSet = preparedStatement.executeQuery();
		meetingRoomBeanList = new ArrayList<MeetingRoomBean>();
		while (resultSet.next()) {
			MeetingRoomBean meetingRoomBean = new MeetingRoomBean();
			meetingRoomBean.setCapacity(resultSet.getString("capacity"));
			meetingRoomBean.setNote(resultSet.getString("note"));
			meetingRoomBean.setRoomcapacity(resultSet.getInt("roomcapacity"));
			meetingRoomBean.setRoomnumber(resultSet.getInt("roomnumber"));
			meetingRoomBean.setStatus(resultSet.getInt("status"));
			meetingRoomBeanList.add(meetingRoomBean);
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return meetingRoomBeanList;
	}

	public MeetingRoomBean fetchMeetingRoombyRoomnumber(int roomnumber)
			throws Exception {
		MeetingRoomBean meetingRoomBean = null;
		connection = dbUtil.getConnection();
		String sql = "select * from meetingroom  where roomnumber=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, roomnumber);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			meetingRoomBean = new MeetingRoomBean();
			meetingRoomBean.setCapacity(resultSet.getString("capacity"));
			meetingRoomBean.setNote(resultSet.getString("note"));
			meetingRoomBean.setRoomcapacity(resultSet.getInt("roomcapacity"));
			meetingRoomBean.setRoomnumber(resultSet.getInt("roomnumber"));
			meetingRoomBean.setStatus(resultSet.getInt("status"));

		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return meetingRoomBean;
	}

	public int updateMeetingroom(MeetingRoomBean meetingroomBean)
			throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "update meetingroom set capacity=?,roomcapacity=?,status=?,note=? where roomnumber=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, meetingroomBean.getCapacity());
		preparedStatement.setInt(2, meetingroomBean.getRoomcapacity());
		preparedStatement.setInt(3, meetingroomBean.getStatus());
		preparedStatement.setString(4, meetingroomBean.getNote());
		preparedStatement.setInt(5, meetingroomBean.getRoomnumber());
		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	public int dropMeetingroomByroomnumber(int roomnumber) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		connection = dbUtil.getConnection();
		String sql = "delete from meetingroom where roomnumber=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, roomnumber);
		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

	public int fetchMeetingRows() throws Exception {
		int meetingroomrows = 0;
		connection = dbUtil.getConnection();
		String sql = "select count(*) from meetingroom";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			meetingroomrows = resultSet.getInt(1);
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return meetingroomrows;
	}

	

	public int fetchCapacityByroomnumber(String capacity) throws Exception {
		int reasult=0;
		connection = dbUtil.getConnection();
		String sql = "select roomnumber from meetingroom where capacity=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,capacity);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
		reasult=resultSet.getInt(1);}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return reasult;
	}


}
