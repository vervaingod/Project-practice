package com.meeting.bean;
/**
 * 
 * @author �����
 *	@���� �����ҵ�ģ�Ͳ� ��Ҫ��get set����
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
