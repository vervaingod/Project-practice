package com.meeting.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.EmployeeBean;
import com.meeting.bean.MeetinginfoBean;
import com.meeting.biz.EmployeeBiz;
import com.meeting.biz.EmployeeBizImpl;
import com.meeting.biz.MeetingBiz;
import com.meeting.biz.MeetingBizImpl;
/**
 * 
 * @功能 查看具体某条会议的详细信息
 * @author 李岩
 * @since 2015-08-29
 * @version V0.1
 *
 */
@WebServlet("/MyMeetingDetailsServlet")
public class MyMeetingDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idString = request.getParameter("meetingid");
		int id = Integer.parseInt(idString);
		try {
			MeetingBiz meetingBiz = new MeetingBizImpl();
			MeetinginfoBean meetinginfoBean = meetingBiz
					.fetchMeetinginfoById(id);

			if (meetinginfoBean != null) {

				request.setAttribute("meetinginfoBean", meetinginfoBean);

				String employeeId = meetinginfoBean.getSelectEmployees();
				String s1[] = employeeId.split(",");
				List<EmployeeBean> employeeBeanList = new ArrayList<EmployeeBean>();
				EmployeeBiz employeeBiz = new EmployeeBizImpl();
				for (int i = 0; i < s1.length; i++) {
					EmployeeBean employeeBean = new EmployeeBean();
					employeeBean = employeeBiz.fetchEmployeeinfoById(Integer
							.parseInt(s1[i]));
					employeeBeanList.add(employeeBean);
				}
				request.setAttribute("employeeBeanList", employeeBeanList);

			}
			request.getRequestDispatcher("mymeetingdetails.jsp").forward(
					request, response);

		} catch (Exception e) {
			request.setAttribute("message", "该会议不存在，请确认后重新查看");
			request.getRequestDispatcher("./NotificationsServlet").forward(
					request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
