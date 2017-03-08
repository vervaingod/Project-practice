package com.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.EmployeeBean;
import com.meeting.bean.MeetingRoomBean;
import com.meeting.biz.MeetingRoomBiz;
import com.meeting.biz.MeetingRoomBizImpl;

/**
 * 
 * @author �����
 * @���� ����һ��������
 * @��ע ֻ�й���Ա���н��иò���
 */
@WebServlet("/UpdateMeetingRoomServlet")
public class UpdateMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("roomnumber");
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean = (EmployeeBean) request.getSession().getAttribute(
				"employeeBean");
		try {
			int role = employeeBean.getRole();
			if (role == 1) {
				int roomnumber = Integer.parseInt(request
						.getParameter("roomnumber"));
				String capacity = request.getParameter("capacity");
				int roomcapacity = Integer.parseInt(request
						.getParameter("roomcapacity"));
				int status = Integer.parseInt(request.getParameter("status"));
				String note = request.getParameter("note");
				MeetingRoomBean meetingroomBean = new MeetingRoomBean();
				MeetingRoomBiz meetingroomBiz = new MeetingRoomBizImpl();
				meetingroomBean.setRoomnumber(roomnumber);
				meetingroomBean.setCapacity(capacity);
				meetingroomBean.setRoomcapacity(roomcapacity);
				meetingroomBean.setStatus(status);
				meetingroomBean.setNote(note);
				if (status!=-1) {
					int resault = meetingroomBiz
							.fetchCapacityByroomnumber(capacity);
					if (resault == 0 || resault == roomnumber) {
						int rows = meetingroomBiz
								.updateMeetingroom(meetingroomBean);
						if (rows >= 1) {
							request.setAttribute("message", "�޸ĳɹ�!!");
							request.getRequestDispatcher(
									"./FetchAllMeetingRoomServlet").forward(
									request, response);
						} else {
							request.setAttribute("message", "�޸�ʧ��������!!");
							request.getRequestDispatcher("roomdetails.jsp")
									.forward(request, response);
						}
					} else {
						request.setAttribute("message", "�÷������Ѿ�����!!");

						request.getRequestDispatcher(
								"./FetchMeetingRoomByRoomnumberServlet?id="
										+ id).forward(request, response);
					}
				}

				else {
					int rows = meetingroomBiz
							.dropMeetingroomByroomnumber(roomnumber);
					if (rows >= 1) {
						request.setAttribute("message", "ɾ���ɹ�!!");
						request.getRequestDispatcher(
								"./FetchAllMeetingRoomServlet").forward(
								request, response);
					} else {
						request.setAttribute("message", "ɾ��ʧ��!!");
						request.getRequestDispatcher("roomdetails.jsp")
								.forward(request, response);
					}
				}
			} else {
				request.setAttribute("message", "�ǹ���Ա���ܽ��жԻ����ҽ����޸ģ�");
				request.getRequestDispatcher("./FetchAllMeetingRoomServlet")
						.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("message", "�ǹ���Ա���ܽ��жԻ����ҽ����޸ģ�");
			request.getRequestDispatcher("roomdetails.jsp").forward(request,
					response);
		}

	}
}
