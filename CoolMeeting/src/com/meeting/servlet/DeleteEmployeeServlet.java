package com.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.biz.EmployeeBiz;
import com.meeting.biz.EmployeeBizImpl;

/**
 * @see 审批员工注册时用于不通过审批的Servlet，用于底层的判断
 * @author 刘均前
 * @since 2015-08-29
 * @version V1.0
 */
@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String idString = request.getParameter("id");
		String message = "";

		try {
			int id = Integer.parseInt(idString);
			EmployeeBiz employeeBiz = new EmployeeBizImpl();
			int rows = employeeBiz.deleteEmployee(id);
			if (rows == 1) {
				message = "待审批员工删除成功！";
			} else {
				message = "待审批员工删除失败！";
			}
		} catch (Exception e) {
			message = "该员工ID不合法，请确认后重新删除！";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("./FetchEmployeeServlet").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
