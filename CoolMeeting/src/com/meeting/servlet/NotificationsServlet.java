package com.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.MeetinginfoBean;
import com.meeting.biz.MeetingBiz;
import com.meeting.biz.MeetingBizImpl;
/**
 * 
 * 
 * @功能 分别获取未取消和取消会议信息
 * @author 李岩
 * @since 2015-08-29
 * @version V0.1
 *
 */
@WebServlet("/NotificationsServlet")
public class NotificationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MeetingBiz meetingBiz = new MeetingBizImpl();
		
		List<MeetinginfoBean> meetinginfoBeanList1 = meetingBiz
				.fetchAllMeetingsinfoListByStatus(0);
		if (meetinginfoBeanList1 != null && !meetinginfoBeanList1.isEmpty()) {
			request.setAttribute("meetinginfoBeanList1", meetinginfoBeanList1);
		} 

		List<MeetinginfoBean> meetinginfoBeanList2 = meetingBiz
				.fetchAllMeetingsinfoListByStatus(1);
		if (meetinginfoBeanList2 != null && !meetinginfoBeanList2.isEmpty()) {
			request.setAttribute("meetinginfoBeanList2", meetinginfoBeanList2);
		} 
		
		request.getRequestDispatcher("notifications.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
