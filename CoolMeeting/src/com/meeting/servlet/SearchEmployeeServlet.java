package com.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.EmployeeBean;
import com.meeting.bean.PageBean;
import com.meeting.biz.EmployeeBiz;
import com.meeting.biz.EmployeeBizImpl;


@WebServlet("/SearchEmployeeServlet")
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		EmployeeBean employeeBean2 = new EmployeeBean();
		employeeBean2 = (EmployeeBean) request.getSession().getAttribute(
				"employeeBean");
		String employeename = request.getParameter("employeename");
		String accountname = request.getParameter("accountname");
		String statusString = request.getParameter("status");
		int status=0;
		if (statusString != null) {
			try {
				status = Integer.parseInt(statusString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployeename(employeename);
		employeeBean.setAccountname(accountname);
		employeeBean.setStatus(status);
		String pagenoString = request.getParameter("pageno");
		int pageno = 1;
		if (pagenoString != null) {
			try {
				pageno = Integer.parseInt(pagenoString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		EmployeeBiz employeeBiz = new EmployeeBizImpl();

		int employeeRows = employeeBiz.fetchEmployeeRows(employeeBean);
		int maxpage = employeeRows % PageBean.ROWS_PRO_PAGE == 0 ? employeeRows
				/ PageBean.ROWS_PRO_PAGE
				: (employeeRows / PageBean.ROWS_PRO_PAGE + 1);
		if (pageno < 1) {
			pageno = 1;
		}
		if (pageno > maxpage) {
			pageno = maxpage;
		}
		List<EmployeeBean> employeeBeanList = employeeBiz
				.fetchSearchEmployeeList(employeeBean,pageno);
		PageBean pageBean = new PageBean();
		pageBean.setPageno(pageno);
		pageBean.setMaxpage(maxpage);
		
		request.getSession().setAttribute("employeeBean", employeeBean2);
		request.setAttribute("employeeBeanList", employeeBeanList);
		request.setAttribute("pageBean", pageBean);
		//request.getSession().setAttribute("employeeBean",employeeBean);
		request.getRequestDispatcher("searchemployees.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 
	}

}
