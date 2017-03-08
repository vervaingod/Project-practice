package com.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.MeetinginfoBean;
import com.meeting.biz.MeetinginfoBiz;
import com.meeting.biz.MeetinginfoBizImpl;

/**
 * @���ܣ���Ҫ���ڴ����ҵ�Ԥ������
 * @����ʱ�� 2015-08-25
 * @���� ����
 * @�汾�� v1.0
 */
@WebServlet("/MyBookingsServlet")
public class MyBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MeetinginfoBiz meetinginfoBiz = new MeetinginfoBizImpl();
		List<MeetinginfoBean> meetinginfoBeanList = meetinginfoBiz
				.fetchMyBookingList();
		if (meetinginfoBeanList != null && !meetinginfoBeanList.isEmpty()) {
			request.setAttribute("meetinginfoBeanList", meetinginfoBeanList);
			request.getRequestDispatcher("mybookings.jsp").forward(request,
					response);
		} else {
			request.setAttribute("message", "��Ԥ�����飬��Ԥ����");
			
			request.getRequestDispatcher("bookmeeting.jsp").forward(request,
					response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
