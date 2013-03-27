package com.bmw.sell.business;
import java.util.List;
import com.bmw.sell.value.EmployeeValue;

public interface IEmployee {
	public void add(int id,String name,String password,String sex,int age,String loginname,String department) throws Exception;
	//增加员工
	public void modify(int id,String name,String password,String sex,int age,String loginname,String department) throws Exception;
	//修改员工
	public void delete(int id) throws Exception;
	//删除员工
	public List<EmployeeValue> getlist() throws Exception;
	//获得员工列表
	public EmployeeValue getEmployee(int id) throws Exception;
	//根据ID获得单一员工信息
	public EmployeeValue getEmployee(String loginname) throws Exception;
	//根据登录名获得单一员工信息
	public List<EmployeeValue> search(String username) throws Exception;
	//根据姓名获搜索员工信息
}
