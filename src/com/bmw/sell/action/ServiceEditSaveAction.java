package com.bmw.sell.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmw.sell.business.IService;
import com.bmw.sell.factory.BusinessFactory;

/**
 * Servlet implementation class ServiceEditSaveAction
 */
@WebServlet("/service/editsave.do")
public class ServiceEditSaveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceEditSaveAction() {
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
			String serdate=request.getParameter("inputdate");
			String serstate=request.getParameter("inputstc");
			
			service.modify(serid, serdate, serstate);
			
			response.setCharacterEncoding("utf-8");
			response.sendRedirect("main.do");
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
