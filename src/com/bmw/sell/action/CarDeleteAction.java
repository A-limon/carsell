package com.bmw.sell.action;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmw.sell.business.ICar;
import com.bmw.sell.factory.BusinessFactory;
import com.bmw.sell.value.CarValue;

/**
 * Servlet implementation class CarDeleteAction
 */
@WebServlet("/car/delete.do")
public class CarDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static boolean deleteFile(String fileName){     
        File file = new File(fileName);     
        if(file.isFile() && file.exists()){     
            file.delete();     
            System.out.println("删除文件"+fileName+"成功！");     
            return true;     
        }else{     
            System.out.println("删除文件"+fileName+"失败！");     
            return false;     
        }     
    }    



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			ICar ic=BusinessFactory.getCar();
			CarValue cv=ic.get(Integer.parseInt(request.getParameter("carid")));
			
			String filename=cv.getCarpic().substring(2);//从数据库读出路径去掉"../"
			String newurl = this.getServletContext().getRealPath(filename);//获取真实物理地址
			deleteFile(newurl);//删除物理文件
			
			ic.delete(Integer.parseInt(request.getParameter("carid")));
			response.setCharacterEncoding("utf-8");
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("main.do");
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
