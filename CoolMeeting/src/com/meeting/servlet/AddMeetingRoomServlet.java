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
 * @author 许嘉阳
 * @功能 增加一个会议室
 * @备注 只有管理员才行进行该操作
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
					request.setAttribute("message", "请输入正确的门牌号");
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
							request.setAttribute("message", "添加成功!!");
							request.getRequestDispatcher(
									"./FetchAllMeetingRoomServlet").forward(
									request, response);
						} else {
							request.setAttribute("message", "添加失败，该房间号已经存在");
							request.getRequestDispatcher("addmeetingroom.jsp")
									.forward(request, response);
						}

					} else {
						request.setAttribute("message", "该会议室名已经存在");
						request.setAttribute("id", id);
						request.getRequestDispatcher("addmeetingroom.jsp")
								.forward(request, response);
					}
				}
			} else {
				request.setAttribute("message", "对不起，非管理员不能添加会议室");
				request.getRequestDispatcher("./FetchAllMeetingRoomServlet")
						.forward(request, response);
				;
			}
		} catch (Exception e) {
			request.setAttribute("message", "注册失败，操作非法，请按提示操作并重试");
			request.getRequestDispatcher("addmeetingroom.jsp").forward(request,
					response);
		}
	}
}
