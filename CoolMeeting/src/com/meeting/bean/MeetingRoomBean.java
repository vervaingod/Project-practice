package com.meeting.bean;
/**
 * 
 * @author 许嘉阳
 *	@功能 会议室的模型层 主要放get set方法
 */
public class MeetingRoomBean {
	public int roomnumber;
	public String capacity;
	public int roomcapacity;
	public int status;
	public String note;

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public int getRoomcapacity() {
		return roomcapacity;
	}

	public void setRoomcapacity(int roomcapacity) {
		this.roomcapacity = roomcapacity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
