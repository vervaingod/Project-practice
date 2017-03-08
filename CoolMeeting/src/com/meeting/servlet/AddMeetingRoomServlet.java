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
@WebServlet("/AddMeetingRoomServlet")
public class AddMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean = (EmployeeBean) request.getSession().getAttribute(
				"employeeBean");
		try {
			int role = employeeBean.getRole();
			if (role == 1) {
				int id = Integer.parseInt(request.getParameter("roomnumber"));
				int roomnumber = Integer.parseInt(request
						.getParameter("roomnumber"));
				String capacity = request.getParameter("capacity");
				int roomcapacity = Integer.parseInt(request
						.getParameter("roomcapacity"));
				int status = Integer.parseInt(request.getParameter("status"));
				String note = request.getParameter("note");

				if (roomnumber <= 0 || roomnumber >= 999) {
					request.setAttribute("message", "��������ȷ�����ƺ�");
					request.getRequestDispatcher("addmeetingroom.jsp").forward(
							request, response);
				}

				else {
					MeetingRoomBean meetingroomBean = new MeetingRoomBean();
					MeetingRoomBiz meetingroomBiz = new MeetingRoomBizImpl();

					meetingroomBean.setRoomnumber(roomnumber);
					meetingroomBean.setCapacity(capacity);
					meetingroomBean.setRoomcapacity(roomcapacity);
					meetingroomBean.setStatus(status);
					meetingroomBean.setNote(note);
					int result = meetingroomBiz
							.fetchCapacityByroomnumber(capacity);
					if (result == 0) {
						int rows = meetingroomBiz
								.addMeetingroom(meetingroomBean);
						if (rows >= 1) {
							request.setAttribute("message", "��ӳɹ�!!");
							request.getRequestDispatcher(
									"./FetchAllMeetingRoomServlet").forward(
									request, response);
						} else {
							request.setAttribute("message", "���ʧ�ܣ��÷�����Ѿ�����");
							request.getRequestDispatcher("addmeetingroom.jsp")
									.forward(request, response);
						}

					} else {
						request.setAttribute("message", "�û��������Ѿ�����");
						request.setAttribute("id", id);
						request.getRequestDispatcher("addmeetingroom.jsp")
								.forward(request, response);
					}
				}
			} else {
				request.setAttribute("message", "�Բ��𣬷ǹ���Ա������ӻ�����");
				request.getRequestDispatcher("./FetchAllMeetingRoomServlet")
						.forward(request, response);
				;
			}
		} catch (Exception e) {
			request.setAttribute("message", "ע��ʧ�ܣ������Ƿ����밴��ʾ����������");
			request.getRequestDispatcher("addmeetingroom.jsp").forward(request,
					response);
		}
	}
}
