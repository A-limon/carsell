package com.bmw.sell.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmw.sell.business.ISell;
import com.bmw.sell.factory.BusinessFactory;

/**
 * Servlet implementation class SellAddAction
 */
@WebServlet("/sell/add.do")
public class SellAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			ISell sell=BusinessFactory.getSell();
			int engineid=Integer.parseInt(request.getParameter("inputengineid"));
			int carid=Integer.parseInt(request.getParameter("inputcarid"));
			int userid=Integer.parseInt(request.getParameter("inputuserid"));
			String selldate=request.getParameter("inputdate");
			sell.add(engineid, selldate, carid, userid);
			
			response.setCharacterEncoding("utf-8");
			response.sendRedirect("main.do");
			//转发到销售主页		
		}catch (Exception e) {
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
