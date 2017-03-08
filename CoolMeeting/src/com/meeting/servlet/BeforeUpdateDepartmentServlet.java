package com.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.DepartmentBean;
import com.meeting.biz.DepartmentBiz;
import com.meeting.biz.DepartmentBizImpl;

/**
 * @see 修改部门前所需的跳转Servlet
 * @author 刘均前
 * @since 2015-08-29
 * @version V1.0
 */
@WebServlet("/BeforeUpdateDepartmentServlet")
public class BeforeUpdateDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String idString = request.getParameter("id");
		try {
			int id = Integer.parseInt(idString);
			DepartmentBiz departmentBiz = new DepartmentBizImpl();
			DepartmentBean departmentBean = departmentBiz
					.fetchDepartmentById(id);
			if (departmentBean != null) {
				request.setAttribute("departmentBean", departmentBean);
				request.getSession().setAttribute("departmentBean", departmentBean);
				request.getRequestDispatcher("departments_update.jsp").forward(request, response);
			}else{
				request.setAttribute("messagedelete", "该部门不存在，请确认后重新编辑！");
				request.getRequestDispatcher("./FetchDepartmentServlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
