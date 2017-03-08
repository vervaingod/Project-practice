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
 * @���� �Ի���ȡ������ش���
 * @author ����
 * @since 2015-08-29
 * @version V0.1
 * 
 */
@WebServlet("/CancelMeetingProServlet")
public class CancelMeetingProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("meetingid");
		int meetingid = Integer.parseInt(id);
		String deletereason = request.getParameter("deletereason");
		
		MeetinginfoBean meetinginfoBean = new MeetinginfoBean();
		meetinginfoBean.setMeetingid(meetingid);
		meetinginfoBean.setDeletereason(deletereason);

		MeetingBiz meetingBiz = new MeetingBizImpl();
		int rows = meetingBiz.cancelMeeting(meetinginfoBean);

		if (rows == 1) {
			request.setAttribute("message", "���鳷���ɹ�");
			request.getRequestDispatcher("./MyBookingsServlet").forward(
					request, response);
		} else {
			request.setAttribute("message", "���鳷��ʧ��,���ѯ�����³���");
			request.getRequestDispatcher("./MyBookingsServlet").forward(
					request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
