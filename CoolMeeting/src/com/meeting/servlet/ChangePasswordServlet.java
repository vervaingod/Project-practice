package com.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.EmployeeBean;
import com.meeting.biz.EmployeeBiz;
import com.meeting.biz.EmployeeBizImpl;

/**
 * @see 修改密码的servlet
 * @author 李浩榕
 * @since 2015-08-29
 * @version v1.0
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String current_accountname = ((EmployeeBean) request.getSession().getAttribute("employeeBean")).getAccountname();
			String originpwd = request.getParameter("originpwd");
			String password = request.getParameter("password");
			String newpwd = request.getParameter("newpwd");

			if (originpwd == null || originpwd.trim().equals("")) {
				request.setAttribute("message", "原密码不能为空");
				request.getRequestDispatcher("changepassword.jsp").forward(
						request, response);
			} else if (password == null || password.trim().equals("")
					|| password.length() < 6) {
				request.setAttribute("temp_originpwd", originpwd);
				request.setAttribute("message", "密码不符合要求(不小于6位)");
				request.getRequestDispatcher("changepassword.jsp").forward(
						request, response);
			} else if (newpwd == null || newpwd.trim().equals("")
					|| !newpwd.trim().equals(request.getParameter("password"))) {
				request.setAttribute("temp_originpwd", originpwd);
				request.setAttribute("message", "密码确认错误，请重新确认密码");
				request.getRequestDispatcher("changepassword.jsp").forward(
						request, response);
			} else {
				EmployeeBean employeeBean = new EmployeeBean();
				employeeBean.setPassword(password);
				employeeBean.setAccountname(current_accountname);

				EmployeeBiz employeeBiz = new EmployeeBizImpl();

				String temp_pwd = employeeBiz
					.fetchPwdByAccountname(current_accountname);
	
				if (temp_pwd.trim().equals(originpwd)) {
					int result = employeeBiz.update(employeeBean);
					if (result == 1) {
						request.getSession().removeAttribute("employeeBean");
						request.setAttribute("message", "密码修改成功！");
						request.getRequestDispatcher("login.jsp").forward(
								request, response);
					} else {
						request.setAttribute("message", "修改失败，请重新修改");
						request.getRequestDispatcher("changepassword.jsp")
								.forward(request, response);
					}

				} else {
					request.setAttribute("message", "原始密码输入错误，请重新输入");
					request.getRequestDispatcher("changepassword.jsp")
							.forward(request, response);
				}
			}
		} catch (Exception exception) {
			request.setAttribute("message", "原始密码不合法，请确认后重新修改！");
			request.getRequestDispatcher("changepassword.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
