package com.bmw.sell.factory;
import com.bmw.sell.dao.*;
import com.bmw.sell.dao.impl.*;

public class DaoFactory {
	public static IEmployeeDao getEmployeeDao(){
		return new EmployeeDaoImpl();
	}
	//员工Dao实现类对象
	public static ICarDao getCarDao(){
		return new CarDaoImpl();
	}
	//车型Dao实现类对象
	public static ISellDao getSellDao(){
		return new SellDaoImpl();
	}
	//销售Dao实现类对象
	public static IClientDao getClientDao(){
		return new ClientDaoImpl();
	}
	//客户Dao实现类对象
	public static IServiceDao getServiceDao(){
		return new ServiceDaoImpl();
	}
	//服务Dao实现类对象
}
