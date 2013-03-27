package com.bmw.sell.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmw.sell.business.IService;
import com.bmw.sell.factory.BusinessFactory;
import com.bmw.sell.value.ServiceValue;

/**
 * Servlet implementation class ServiceEditAction
 */
@WebServlet("/service/edit.do")
public class ServiceEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceEditAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			IService service =BusinessFactory.getService();
			int serid=Integer.parseInt(request.getParameter("serid"));
			ServiceValue ssv=service.get(serid);
			request.setAttribute("ssv", ssv);
			response.setCharacterEncoding("utf-8");
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			String mess=e.getMessage();
			response.sendRedirect("../index/error.jsp?mess="+mess);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
