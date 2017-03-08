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
 * @功能 对会议信息进行查询相关处理
 * @author 李岩
 * @since 2015-08-29
 * @version V0.1
 * 
 */
@WebServlet("/MyMeetingsServlet")
public class MyMeetingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingBiz meetingBiz = new MeetingBizImpl();
		List<MeetinginfoBean> meetinginfoBeanList = meetingBiz
				.fetchAllMeetingsinfoList();
		if (meetinginfoBeanList != null && !meetinginfoBeanList.isEmpty()) {
			request.setAttribute("meetinginfoBeanList", meetinginfoBeanList);
			request.getRequestDispatcher("mymeetings.jsp").forward(
					request, response);
		} else {
			request.getRequestDispatcher("mymeetings.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
