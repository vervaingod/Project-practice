package com.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.bean.MeetinginfoBean;
import com.meeting.biz.MeetinginfoBiz;
import com.meeting.biz.MeetinginfoBizImpl;
import com.meeting.bean.PageBean;

/**
 * @功能：主要用于处理会议搜索界面
 * @创建时间 2015-08-27
 * @作者 赵燕
 * @版本号 v1.0
 */
@WebServlet("/SearchMeetingsServlet")
public class SearchMeetingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String meetingname = request.getParameter("meetingname");
		String capacity = request.getParameter("capacity");
		String accountname = request.getParameter("accountname");
		String adddate = request.getParameter("adddate");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");

		MeetinginfoBean meetinginfoBean = new MeetinginfoBean();
		meetinginfoBean.setMeetingname(meetingname);
		meetinginfoBean.setCapacity(capacity);
		meetinginfoBean.setAccountname(accountname);
		meetinginfoBean.setAdddate(adddate);
		meetinginfoBean.setStartdate(startdate);
		meetinginfoBean.setEnddate(enddate);
		String pagenoString = request.getParameter("pageno");
		int pageno = 1;
		if (pagenoString != null) {
			try {
				pageno = Integer.parseInt(pagenoString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		MeetinginfoBiz meetinginfoBiz = new MeetinginfoBizImpl();
		int meetinginfoRows = meetinginfoBiz
				.fetchMeetinginfoRows(meetinginfoBean);
		int maxpage = meetinginfoRows % PageBean.ROWS_PRO_PAGE == 0 ? meetinginfoRows
				/ PageBean.ROWS_PRO_PAGE
				: (meetinginfoRows / PageBean.ROWS_PRO_PAGE + 1);
		if (pageno < 1) {
			pageno = 1;
		}
		if (pageno > maxpage) {
			pageno = maxpage;
		} 
		List<MeetinginfoBean> meetinginfoBeanList = meetinginfoBiz
				.fetchSearchMeetingList(meetinginfoBean, pageno);
		PageBean pageBean = new PageBean();
		pageBean.setPageno(pageno);
		pageBean.setMaxpage(maxpage); 
		session.setAttribute("meetinginfoBeanList", meetinginfoBeanList);
		session.setAttribute("meetinginfoBean", meetinginfoBean);
		session.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("searchmeetings.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
