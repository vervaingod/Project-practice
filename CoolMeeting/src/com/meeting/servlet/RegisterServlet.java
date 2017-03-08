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
 * @see ע��ҳ���servlet
 * @author �����
 * @since 2015-08-29
 * @version v1.0
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String employeename = request.getParameter("employeename");
		String accountname = request.getParameter("accountname");
		String password = request.getParameter("password");
		String pwdconfirm = request.getParameter("pwdconfirm");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String departmentidStr = request.getParameter("departmentid");

		int departmentid = 0;
		if (departmentidStr != null) {
			try {
				departmentid = Integer.parseInt(departmentidStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (employeename == null || employeename.trim().equals("")) {
			request.setAttribute("message", "��������Ϊ��");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (accountname == null || accountname.trim().equals("")) {
			request.setAttribute("temp_employeename", employeename);
			request.setAttribute("message", "�˺�������Ϊ��");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (password == null || password.trim().equals("")
				|| password.length() < 6) {
			request.setAttribute("temp_employeename", employeename);
			request.setAttribute("temp_accountname", accountname);
			request.setAttribute("message", "���벻����Ҫ��(��С��6λ)");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (pwdconfirm == null || pwdconfirm.trim().equals("")
				|| !pwdconfirm.trim().equals(request.getParameter("password"))) {
			request.setAttribute("temp_employeename", employeename);
			request.setAttribute("temp_accountname", accountname);
			request.setAttribute("message", "����ȷ�ϴ���������ȷ������");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (phone == null || phone.trim().equals("")) {
			request.setAttribute("temp_employeename", employeename);
			request.setAttribute("temp_accountname", accountname);
			request.setAttribute("message", "��ϵ�绰����Ϊ��");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (email == null || email.trim().equals("")) {
			request.setAttribute("temp_employeename", employeename);
			request.setAttribute("temp_accountname", accountname);
			request.setAttribute("temp_phone", phone);
			request.setAttribute("message", "�����ʼ�����Ϊ��");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else if (departmentidStr == null || departmentidStr.trim().equals("")) {
			request.setAttribute("temp_employeename", employeename);
			request.setAttribute("temp_accountname", accountname);
			request.setAttribute("temp_phone", phone);
			request.setAttribute("temp_departmentid", departmentidStr);
			request.setAttribute("message", "�������źŲ���Ϊ��");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else {
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployeename(employeename);
			employeeBean.setAccountname(accountname);
			employeeBean.setPassword(password);
			employeeBean.setPhone(phone);
			employeeBean.setEmail(email);
			employeeBean.setDepartmentid(departmentid);

			EmployeeBiz employeeBiz = new EmployeeBizImpl();

			int employeeid = employeeBiz.fetchIdByAccountname(accountname);
			boolean departmentexist = employeeBiz
					.fetchIdByDepartmentId(departmentid);

			if (employeeid == 0) {
				if (departmentexist) {
					int rows = employeeBiz.register(employeeBean);
					if (rows == 1) {
						request.getSession().setAttribute(
								"current_accountname", accountname);
						request.setAttribute("message", "ע��ɹ���������...");
						request.getRequestDispatcher("login.jsp").forward(
								request, response);
					} else {
						request.setAttribute("message", "ע��ʧ�ܣ�������ע��");
						request.getRequestDispatcher("register.jsp").forward(
								request, response);
					}
				} else {
					request.setAttribute("message", "�ò��źŲ����ڣ�������ע��");
					request.getRequestDispatcher("register.jsp").forward(
							request, response);
				}
			} else {
				request.setAttribute("message", "���˻����Ѵ���");
				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
