package com.bmw.sell.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.bmw.sell.business.IEmployee;
import com.bmw.sell.factory.BusinessFactory;
import com.bmw.sell.value.EmployeeValue;


/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/index/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginAction() {
        super();   
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Map<String, String> jsonMap = new HashMap<String, String>();
		String flag = null;
		String code = null;
		
		// 登陆判断
		String employeename = request.getParameter("loginname");
		String employeepass = request.getParameter("password");
		EmployeeValue ev=new EmployeeValue();
		try {
			IEmployee emp=BusinessFactory.getEmployee();
			ev = emp.getEmployee(employeename);
			if(employeename != null && employeepass != null && employeename.trim().length()>0
					&& employeepass.trim().length()>0 && ev != null){
				if(ev.getPassword().equals(employeepass)){
					request.setAttribute("ev", ev);
					HttpSession session = request.getSession(true);
					session.setMaxInactiveInterval(5*60);//设置session有效期5分钟
					session.setAttribute("loginname", ev.getLoginname());
					session.setAttribute("password", ev.getPassword());
					session.setAttribute("userid", ev.getId());
					session.setAttribute("user", ev.getName());
					session.setAttribute("depat", ev.getDepartment());
					flag = "登录成功，马上为您转向主页";
					code = "0";
					jsonMap.put("flag", flag);
					jsonMap.put("code", code);
					
					String json = JSON.toJSONString(jsonMap);//将map对象序列化为json格式
			           
			        PrintWriter pw = response.getWriter();    
			        pw.print(json);//传到前台
			        
			        pw.flush();
			        pw.close();
				}
				else
				{
					flag = "用户名或密码错误";
					code = "1";
					jsonMap.put("flag", flag);
					jsonMap.put("code", code);
					
					String json = JSON.toJSONString(jsonMap);//将map对象序列化为json格式
			           
			        PrintWriter pw = response.getWriter();    
			        pw.print(json);//传到前台
			        
			        pw.flush();
			        pw.close();
				}
			}else
			{
				flag = "用户名或密码错误";
				code = "1";
				jsonMap.put("flag", flag);
				jsonMap.put("code", code);
				
				String json = JSON.toJSONString(jsonMap);//将map对象序列化为json格式
		           
		        PrintWriter pw = response.getWriter();    
		        pw.print(json);//传到前台
		        
		        pw.flush();
		        pw.close();
			}
			
		} catch (Exception e) {
			String mess=e.getMessage();
			response.sendRedirect("index/error.jsp?mess="+mess);
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
