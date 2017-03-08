package com.meeting.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.MeetinginfoBean;
import com.meeting.biz.MeetinginfoBiz;
import com.meeting.biz.MeetinginfoBizImpl;

/**
 * Servlet implementation class BookMeetingServlet
 */
@WebServlet("/BookMeetingServlet")
public class BookMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html,charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"); // 可以方便地修改日期格式
		String date = dateFormat.format(now);
		String adddate = date;
		String meetingname = request.getParameter("meetingname");
		String numofattendentsString=request.getParameter("numofattendents");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String capacity = request.getParameter("capacity");
		String accountname=request.getParameter("accountname");
		String description = request.getParameter("description");
		String[] selectEmployeeArray= request.getParameterValues("selectEmployee");
		String selectEmployee="";
		for(String empno:selectEmployeeArray){
			selectEmployee=selectEmployee+empno+",";
		}

		try {
			int numofattendents = Integer.parseInt(numofattendentsString);

			if (meetingname == null || meetingname.trim().equals("")) {
				request.setAttribute("message", "会议名称不能为空");
				request.getRequestDispatcher("PreAddMeetingServlet")
						.forward(request, response);
			} else {
				MeetinginfoBean meetinginfoBean = new MeetinginfoBean();
				meetinginfoBean.setAdddate(adddate);
				meetinginfoBean.setMeetingname(meetingname);
				meetinginfoBean.setNumofattendents(numofattendents);
				meetinginfoBean.setStartdate(startdate);
				meetinginfoBean.setEnddate(enddate);
				meetinginfoBean.setCapacity(capacity);
				meetinginfoBean.setAccountname(accountname);
				meetinginfoBean.setDescription(description);
				meetinginfoBean.setSelectEmployees(selectEmployee);

				MeetinginfoBiz meetinginfoBiz = new MeetinginfoBizImpl();
				int roomstatus=meetinginfoBiz.fetchRoomstatusBycapacity(capacity);	
				if (roomstatus==0) {
					int rows = meetinginfoBiz.addMeetinginfo(meetinginfoBean);
					if (rows == 1) {
						request.setAttribute("message","预订会议成功！！");
						request.getRequestDispatcher(
								"MyBookingsServlet").forward(request,
								response);
					} else {
						System.out.println("预订失败，请重新预订！！");
						request.setAttribute("message", "预订失败，请重新预订！！！");
						request.getRequestDispatcher("PreAddMeetingServlet")
								.forward(request, response);
					}
				} else {
					System.out.println("该会议室已在用！！");
					request.setAttribute("message", "该会议室已在用，请换一个");
					request.getRequestDispatcher("PreAddMeetingServlet")
					.forward(request, response);
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			request.setAttribute("message", "预订信息不正确，请确认后重新预订！！");
			request.getRequestDispatcher("PreAddMeetingServlet")
			.forward(request, response);			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}

}
