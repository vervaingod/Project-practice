package com.meeting.bean;

/**
 * @功能：MeetingInfo的javaBean，主要用于会议数据的传递和封装
 * @创建时间 2015-08-25
 * @作者 赵燕
 * @版本号 v1.0
 */
public class MeetinginfoBean {

	private int meetingid;
	private String meetingname;
	private String capacity;
	private String startdate;
	private String enddate;
	private String adddate;
	private int numofattendents;
	private String description;
	private String deletereason;
	private int meetingstatus;
	private String accountname;
	private String selectEmployees;

	public int getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}

	public String getMeetingname() {
		return meetingname;
	}

	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getSelectEmployees() {
		return selectEmployees;
	}

	public void setSelectEmployees(String selectEmployees) {
		this.selectEmployees = selectEmployees;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getAdddate() {
		return adddate;
	}

	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}

	public int getNumofattendents() {
		return numofattendents;
	}

	public void setNumofattendents(int numofattendents) {
		this.numofattendents = numofattendents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeletereason() {
		return deletereason;
	}

	public void setDeletereason(String deletereason) {
		this.deletereason = deletereason;
	}

	public int getMeetingstatus() {
		return meetingstatus;
	}

	public void setMeetingstatus(int meetingstatus) {
		this.meetingstatus = meetingstatus;
	}

}
