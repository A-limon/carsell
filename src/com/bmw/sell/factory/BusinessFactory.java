package com.bmw.sell.factory;

import com.bmw.sell.business.ICar;
import com.bmw.sell.business.IClient;
import com.bmw.sell.business.IEmployee;
import com.bmw.sell.business.ISell;
import com.bmw.sell.business.IService;
import com.bmw.sell.business.impl.CarImpl;
import com.bmw.sell.business.impl.ClientImpl;
import com.bmw.sell.business.impl.EmployeeImpl;
import com.bmw.sell.business.impl.SellImpl;
import com.bmw.sell.business.impl.ServiceImpl;

public class BusinessFactory {
	
	public static IEmployee getEmployee(){
		//取得员工业务对象
		return new EmployeeImpl();
	}
	public static ICar getCar(){
		//取得车型业务对象
		return new CarImpl();
	}
	public static ISell getSell(){
		//取得销售业务对象
		return new SellImpl();
	}
	public static IClient getClient(){
		//取得客户业务对象
		return new ClientImpl();
	}
	public static IService getService(){
		//取得服务业务对象
		return new ServiceImpl();
	}

}
