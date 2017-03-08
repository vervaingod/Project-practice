package com.meeting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.meeting.bean.MeetinginfoBean;
import com.meeting.util.DBUtil;
/**
 * 
 * @author 李岩
 * @功能 实现会议信息相关功能
 * @since 2015-08-29
 * @version V0.1
 */
public class MeetingDaoImpl implements MeetingDao {

	DBUtil dbUtil = new DBUtil();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public List<MeetinginfoBean> fetchAllMeetingsinfoList() throws Exception {
		List<MeetinginfoBean> meetinginfoBeanList = null;
		connection = dbUtil.getConnection();
		String sql = "select * from meetinginfo where meetingstatus = 1";
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
			meetinginfoBean.setAccountname(resultSet.getString("accountname"));
			meetinginfoBeanList.add(meetinginfoBean);
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return meetinginfoBeanList;
	}

	public List<MeetinginfoBean> fetchAllMeetingsinfoList(int i)
			throws Exception {
		List<MeetinginfoBean> meetinginfoBeanList = null;
		connection = dbUtil.getConnection();
		String sql;
		if (i == 1) {
			sql = "select * from meetinginfo where meetingstatus = 1";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			meetinginfoBeanList = new ArrayList<MeetinginfoBean>();
			while (resultSet.next()) {
				MeetinginfoBean meetinginfoBean = new MeetinginfoBean();
				meetinginfoBean.setMeetingid(resultSet.getInt("meetingid"));
				meetinginfoBean.setMeetingname(resultSet
						.getString("meetingname"));
				meetinginfoBean.setCapacity(resultSet.getString("capacity"));
				meetinginfoBean.setStartdate(resultSet.getString("startdate"));
				meetinginfoBean.setEnddate(resultSet.getString("enddate"));
				meetinginfoBeanList.add(meetinginfoBean);
			}
		}
		if (i == 0) {
			sql = "select * from meetinginfo where meetingstatus = 0";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			meetinginfoBeanList = new ArrayList<MeetinginfoBean>();
			while (resultSet.next()) {
				MeetinginfoBean meetinginfoBean = new MeetinginfoBean();
				meetinginfoBean.setMeetingid(resultSet.getInt("meetingid"));
				meetinginfoBean.setMeetingname(resultSet
						.getString("meetingname"));
				meetinginfoBean.setCapacity(resultSet.getString("capacity"));
				meetinginfoBean.setStartdate(resultSet.getString("startdate"));
				meetinginfoBean.setEnddate(resultSet.getString("enddate"));
				meetinginfoBean.setDeletereason(resultSet
						.getString("deletereason"));
				meetinginfoBeanList.add(meetinginfoBean);
			}

		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return meetinginfoBeanList;
	}

	public MeetinginfoBean fetchMeetinginfoById(int id) throws Exception {
		MeetinginfoBean meetinginfoBean = null;
		connection = dbUtil.getConnection();
		String sql = "select * from meetinginfo where meetingid = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			meetinginfoBean = new MeetinginfoBean();
			meetinginfoBean.setMeetingid(id);
			meetinginfoBean.setMeetingname(resultSet.getString("meetingname"));
			meetinginfoBean.setNumofattendents(resultSet
					.getInt("numofattendents"));
			meetinginfoBean.setStartdate(resultSet.getString("startdate"));
			meetinginfoBean.setEnddate(resultSet.getString("enddate"));
			meetinginfoBean.setDescription(resultSet.getString("description"));
			meetinginfoBean.setDeletereason(resultSet.getString("deletereason"));
			meetinginfoBean.setSelectEmployees(resultSet.getString("selectEmployees"));
		}
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return meetinginfoBean;
	}

	public int cancelMeeting(MeetinginfoBean meetinginfoBean) throws Exception {
		int rows = 0;
		connection = dbUtil.getConnection();
		String sql = "update meetinginfo set meetingstatus = 0, deletereason = ? where meetingid = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, meetinginfoBean.getDeletereason());
		preparedStatement.setInt(2, meetinginfoBean.getMeetingid());
		rows = preparedStatement.executeUpdate();
		dbUtil.closeDBResource(connection, preparedStatement, resultSet);
		return rows;
	}

}
