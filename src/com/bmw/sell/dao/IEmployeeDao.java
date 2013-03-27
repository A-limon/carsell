package com.bmw.sell.dao;
import java.util.List;
import com.bmw.sell.value.*;
public interface IEmployeeDao {
	public void create(EmployeeValue ev) throws Exception;
	
	public void update(EmployeeValue ev) throws Exception;
	
	public void delete(EmployeeValue ev) throws Exception;
	
	public List<EmployeeValue> getList() throws Exception;
	
	public EmployeeValue get(int id) throws Exception;
	
	public EmployeeValue get(String loginname) throws Exception;
	
	public List<EmployeeValue> search(String username) throws Exception;

}
