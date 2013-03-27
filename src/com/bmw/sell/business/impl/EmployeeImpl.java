package com.bmw.sell.business.impl;

import java.util.List;
import com.bmw.sell.business.IEmployee;
import com.bmw.sell.dao.IEmployeeDao;
import com.bmw.sell.factory.DaoFactory;
import com.bmw.sell.value.EmployeeValue;

public class EmployeeImpl implements  IEmployee{
	public void add(int id,String name,String password,String sex,int age,String loginname,String department) 
			throws Exception{
		//增加员工
		EmployeeValue ev=new EmployeeValue();
		ev.setAge(id);
		ev.setPassword(password);
		ev.setName(name);
		ev.setSex(sex);
		ev.setAge(age);
		ev.setLoginname(loginname);
		ev.setDepartment(department);
		IEmployeeDao edo=DaoFactory.getEmployeeDao();
		edo.create(ev);
	}

	
	public void modify(int id, String name, String password, String sex, int age,String loginname,String department)
			throws Exception {
		//修改员工信息
		IEmployeeDao edo=DaoFactory.getEmployeeDao();
		EmployeeValue ev=edo.get(id);
		if(ev!=null){
			ev.setAge(age);
			ev.setName(name);
			ev.setPassword(password);
			ev.setSex(sex);
			ev.setLoginname(loginname);
			ev.setDepartment(department);
			edo.update(ev);
		}
	}

	
	public void delete(int id) throws Exception {
		// 删除员工
		IEmployeeDao edo=DaoFactory.getEmployeeDao();
		EmployeeValue ev=edo.get(id);
		if(ev!=null){
			edo.delete(ev);
		}
		
	}

	
	public List<EmployeeValue> getlist() throws Exception {
		// 返回员工列表
		IEmployeeDao edo=DaoFactory.getEmployeeDao();
		return edo.getList();
		
	}

	
	public EmployeeValue getEmployee(int id) throws Exception {
		// 根据id取得指定员工信息
		IEmployeeDao edo=DaoFactory.getEmployeeDao();
		return edo.get(id);
	}


	
	public EmployeeValue getEmployee(String loginname) throws Exception {
		// 根据登录名取得指定员工信息
		IEmployeeDao edo=DaoFactory.getEmployeeDao();
		return edo.get(loginname);
	}
	
	public List<EmployeeValue> search(String username) throws Exception {
		//根据姓名获搜索员工信息
		IEmployeeDao edo=DaoFactory.getEmployeeDao();
		return edo.search(username);
	}

}
