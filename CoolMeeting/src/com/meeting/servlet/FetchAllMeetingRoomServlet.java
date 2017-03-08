package com.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.MeetingRoomBean;
import com.meeting.bean.PageBean;
import com.meeting.biz.MeetingRoomBiz;
import com.meeting.biz.MeetingRoomBizImpl;

@WebServlet("/FetchAllMeetingRoomServlet")
/**
 * 
 * @author 许嘉阳
 * @功能	查询所有会议室的信息
 *
 */
public class FetchAllMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pagenoString = request.getParameter("pageno");
		int pageno = 1;
		if (pagenoString != null) {
			pageno = Integer.parseInt(pagenoString);
		}
		MeetingRoomBiz meetingRoomBiz = new MeetingRoomBizImpl();
		int meetingroomrows = meetingRoomBiz.fetchMeetingRows();
		int maxpage = meetingroomrows % PageBean.ROWS_PRO_PAGE == 0 ? meetingroomrows
				/ PageBean.ROWS_PRO_PAGE
				: (meetingroomrows / PageBean.ROWS_PRO_PAGE + 1);
		if (pageno < 1) {
			pageno = 1;
		}
		if (pageno > maxpage) {
			pageno = maxpage;
		}

		MeetingRoomBiz meetingroomBiz = new MeetingRoomBizImpl();
		List<MeetingRoomBean> meetingroomBeanList = meetingroomBiz
				.fetchAllMeetingRoom(pageno);
		PageBean pageBean = new PageBean();
		pageBean.setMaxpage(maxpage);
		pageBean.setPageno(pageno);
		request.setAttribute("meetingroomBeanList", meetingroomBeanList);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("meetingrooms.jsp").forward(request,
				response);

	}

}
