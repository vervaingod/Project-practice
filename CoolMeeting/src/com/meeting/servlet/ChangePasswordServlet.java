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
 * @see �޸������servlet
 * @author �����
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
				request.setAttribute("message", "ԭ���벻��Ϊ��");
				request.getRequestDispatcher("changepassword.jsp").forward(
						request, response);
			} else if (password == null || password.trim().equals("")
					|| password.length() < 6) {
				request.setAttribute("temp_originpwd", originpwd);
				request.setAttribute("message", "���벻����Ҫ��(��С��6λ)");
				request.getRequestDispatcher("changepassword.jsp").forward(
						request, response);
			} else if (newpwd == null || newpwd.trim().equals("")
					|| !newpwd.trim().equals(request.getParameter("password"))) {
				request.setAttribute("temp_originpwd", originpwd);
				request.setAttribute("message", "����ȷ�ϴ���������ȷ������");
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
						request.setAttribute("message", "�����޸ĳɹ���");
						request.getRequestDispatcher("login.jsp").forward(
								request, response);
					} else {
						request.setAttribute("message", "�޸�ʧ�ܣ��������޸�");
						request.getRequestDispatcher("changepassword.jsp")
								.forward(request, response);
					}

				} else {
					request.setAttribute("message", "ԭʼ���������������������");
					request.getRequestDispatcher("changepassword.jsp")
							.forward(request, response);
				}
			}
		} catch (Exception exception) {
			request.setAttribute("message", "ԭʼ���벻�Ϸ�����ȷ�Ϻ������޸ģ�");
			request.getRequestDispatcher("changepassword.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
