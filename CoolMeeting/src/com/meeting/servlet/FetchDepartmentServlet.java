package com.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.DepartmentBean;
import com.meeting.bean.PageBean;
import com.meeting.biz.DepartmentBiz;
import com.meeting.biz.DepartmentBizImpl;

/**
 * @see 查询部门信息的Servlet，用于底层的判断及分页
 * @author 刘均前
 * @since 2015-08-29
 * @version V1.0
 */
@WebServlet("/FetchDepartmentServlet")
public class FetchDepartmentServlet extends HttpServlet {
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

		DepartmentBiz departmentBiz = new DepartmentBizImpl();

		int departmentRows = departmentBiz.fetchDepartmentRows();
		int maxpage = departmentRows % PageBean.ROWS_PRO_PAGE == 0 ? (departmentRows / PageBean.ROWS_PRO_PAGE)
				: (departmentRows / PageBean.ROWS_PRO_PAGE + 1);
		if (pageno < 1) {
			pageno = 1;
		}
		if (pageno > maxpage) {
			pageno = maxpage;
		}
		
		List<DepartmentBean> departmentBeanList = departmentBiz
				.fetchAllDepartments(pageno);
		if (departmentBeanList != null && !departmentBeanList.isEmpty()) {
			PageBean pageBean=new PageBean();
			pageBean.setMaxpage(maxpage);
			pageBean.setPageno(pageno);
			request.setAttribute("pageBean", pageBean);
			
			request.setAttribute("departmentBeanList", departmentBeanList);
			request.getRequestDispatcher("departments.jsp").forward(request,
					response);
		} else {
			request.setAttribute("messagelist", "没有任何部门，请添加部门！");
			request.getRequestDispatcher("departments.jsp").forward(request,
					response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
