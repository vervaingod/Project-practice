package com.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meeting.bean.EmployeeBean;
import com.meeting.bean.PageBean;
import com.meeting.biz.EmployeeBiz;
import com.meeting.biz.EmployeeBizImpl;

@WebServlet("/PagingServlet")
public class PagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean employeeBean = (EmployeeBean)session.getAttribute("employeeBean");
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
		
		request.setAttribute("employeeBeanList", employeeBeanList);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("searchemployees.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
