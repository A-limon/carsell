package com.bmw.sell.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bmw.sell.business.IEmployee;
import com.bmw.sell.factory.*;
import com.bmw.sell.value.EmployeeValue;

/**
 * Servlet implementation class UserMainAction
 */
@WebServlet("/employee/main.do")
public class EmployeeMainAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeMainAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
			request.setCharacterEncoding("utf-8");
			IEmployee emp=BusinessFactory.getEmployee();
			//取得员工业务对象
			List<EmployeeValue> emplist=emp.getlist();
			//取得所有员工列表
			request.setAttribute("emplist", emplist);
			//保存给JSP显示员工列表
			response.setCharacterEncoding("utf-8");
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("employee.jsp");
			rd.forward(request, response);
			//转发到员工主页
		} catch (Exception e) {
			String mess=e.getMessage();
			response.sendRedirect("../index/error.jsp?mess="+mess);
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
