package com.meeting.servlet;

import java.io.IOException;

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
 * @功能 获取要取消会议的信息
 * @author 李岩
 * @since 2015-08-29
 * @version V0.1
 *
 */
@WebServlet("/CancelMeetingServlet")
public class CancelMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idString = request.getParameter("meetingid");
		int id = Integer.parseInt(idString);
		MeetingBiz meetingBiz = new MeetingBizImpl();
		MeetinginfoBean meetinginfoBean = meetingBiz.fetchMeetinginfoById(id);
		if (meetinginfoBean != null) {
			request.setAttribute("meetinginfoBean", meetinginfoBean);
			request.getRequestDispatcher("cancelmeeting.jsp").forward(
					request, response);
		} else {
			request.setAttribute("message", "无会议信息，请确认后进行撤销");
			request.getRequestDispatcher("./MyBookingsServlet").forward(request,
					response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
