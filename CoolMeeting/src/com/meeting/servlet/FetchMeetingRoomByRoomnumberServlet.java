package com.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.MeetingRoomBean;
import com.meeting.biz.MeetingRoomBiz;
import com.meeting.biz.MeetingRoomBizImpl;

@WebServlet("/FetchMeetingRoomByRoomnumberServlet")
/**
 * 
 * @author 许嘉阳
 * @功能 通过房间号查询一个详细的会议室信息
 *
 */
public class FetchMeetingRoomByRoomnumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");

		try {

			int roomnumber = Integer.parseInt(id);
			MeetingRoomBiz meetingBiz = new MeetingRoomBizImpl();
			MeetingRoomBean meetingRoomBean = meetingBiz
					.fetchMeetingRoombyRoomnumber(roomnumber);
			request.setAttribute("meetingRoomBean", meetingRoomBean);
			request.getRequestDispatcher("roomdetails.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
