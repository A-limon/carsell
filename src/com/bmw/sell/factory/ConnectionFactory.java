package com.bmw.sell.factory;

import javax.naming.*;
import java.sql.*;
import javax.sql.*;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		Connection cn=null;
		try{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/carsell");
			cn=ds.getConnection();
			ctx.close();
		}catch(Exception e){
		System.out.print("连接数据库错误:");
		}
		return cn;	
	}

}
