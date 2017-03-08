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
 * @see 登录页面的servlet
 * @author 李浩榕
 * @since 2015-08-29
 * @version v1.0
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String accountname = request.getParameter("accountname");
		String password = request.getParameter("password");

		if (accountname == null || accountname.trim().equals("")) {
			request.setAttribute("message", "请输入帐户名");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else if (password == null || password.trim().equals("")) {
			request.setAttribute("temp_accountname", accountname);
			request.setAttribute("message", "请输入账户密码");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setAccountname(accountname);
			employeeBean.setPassword(password);

			EmployeeBiz employeeBiz = new EmployeeBizImpl();

			EmployeeBean employeeBean2 = new EmployeeBean();
			employeeBean2 = employeeBiz.login(employeeBean);
			if (employeeBean2 != null && employeeBean2.getStatus() == 1) {
				request.getSession()
						.setAttribute("employeeBean", employeeBean2);
				request.getRequestDispatcher("./NotificationsServlet").forward(
						request, response);
			} else {
				request.setAttribute("message", "帐户名或密码不存在，请重新登录！");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}
		}
	}

}
