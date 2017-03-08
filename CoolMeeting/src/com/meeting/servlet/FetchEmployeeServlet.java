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

/**
 * @see 查询员工信息时的Servlet，用于底层的判断及分页
 * @author 刘均前
 * @since 2015-08-29
 * @version V1.0
 */
@WebServlet("/FetchEmployeeServlet")
public class FetchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
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
		int employeeRows = employeeBiz.fetchDepartmentRows();
		int maxpage = employeeRows % PageBean.ROWS_PRO_PAGE == 0 ? (employeeRows / PageBean.ROWS_PRO_PAGE)
				: (employeeRows / PageBean.ROWS_PRO_PAGE + 1);
		if (pageno < 1) {
			pageno = 1;
		}
		if (pageno > maxpage) {
			pageno = maxpage;
		}
		
		List<EmployeeBean> employeeBeanList = employeeBiz
				.fetchAllEmployeeListPagination(pageno);
		if (employeeBeanList != null && !employeeBeanList.isEmpty()) {
			PageBean pageBean=new PageBean();
			pageBean.setMaxpage(maxpage);
			pageBean.setPageno(pageno);
			request.setAttribute("pageBean", pageBean);
			
			request.setAttribute("employeeBeanList", employeeBeanList);
			request.getRequestDispatcher("approveaccount.jsp").forward(request,
					response);
		} else {
			request.setAttribute("message", "无员任何工信息！");
			request.getRequestDispatcher("approveaccount.jsp").forward(request,
					response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
