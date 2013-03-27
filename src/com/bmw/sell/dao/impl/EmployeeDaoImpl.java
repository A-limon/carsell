package com.bmw.sell.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bmw.sell.dao.IEmployeeDao;
import com.bmw.sell.value.EmployeeValue;
import com.bmw.sell.factory.*;

public class EmployeeDaoImpl implements IEmployeeDao {

	
	public void create(EmployeeValue ev) throws Exception {
		// 增加新的员工
		String sql="INSERT INTO `carsell`.`employee`(`userid`,`username`,`password`,`sex`,`age`,`loginname`,`department`) VALUES ( NULL,?,?,?,?,?,?) ";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, ev.getName());
			ps.setString(2, ev.getPassword());
			ps.setString(3, ev.getSex());
			ps.setInt(4, ev.getAge());
			ps.setString(5, ev.getLoginname());
			ps.setString(6, ev.getDepartment());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("员工DAO增加错误:"+e.getMessage());
		}finally{
			cn.close();
		}
	}

	
	public void update(EmployeeValue ev) throws Exception {
		// 更新现有员工
		String sql="UPDATE `carsell`.`employee` SET `username`=?,password=?,sex=?,age=?,loginname=?,department=? WHERE  userid=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, ev.getName());
			ps.setString(2, ev.getPassword());
			ps.setString(3, ev.getSex());
			ps.setInt(4, ev.getAge());
			ps.setString(5, ev.getLoginname());
			ps.setString(6, ev.getDepartment());
			ps.setInt(7, ev.getId());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("员工DAO更新错误:"+e.getMessage());
		}finally{
			cn.close();
		}
	}

	
	public void delete(EmployeeValue ev) throws Exception {
		// 删除现有员工
		String sql="DELETE FROM  `carsell`.`employee` WHERE userid=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1, ev.getId());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("员工DAO删除错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	
	public List<EmployeeValue> getList() throws Exception {
		//取得员工列表
		List<EmployeeValue> emplist=new ArrayList<EmployeeValue>();
		String sql="SELECT * FROM  `carsell`.`employee`";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				EmployeeValue ev=new EmployeeValue();
				ev.setId(rs.getInt("userid"));
				ev.setName(rs.getString("username"));
				ev.setPassword(rs.getString("password"));
				ev.setSex(rs.getString("sex"));
				ev.setAge(rs.getInt("age"));
				ev.setLoginname(rs.getString("loginname"));
				ev.setDepartment(rs.getString("department"));
				emplist.add(ev);
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("获取员工信息错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return emplist;
	}

	
	public EmployeeValue get(int id) throws Exception {
		// 根据ID取得指定员工信息
		EmployeeValue ev=null;
		String sql="SELECT * FROM  `carsell`.`employee` WHERE userid=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ev=new EmployeeValue();
				ev.setId(rs.getInt("userid"));
				ev.setName(rs.getString("username"));
				ev.setPassword(rs.getString("password"));
				ev.setSex(rs.getString("sex"));
				ev.setAge(rs.getInt("age"));
				ev.setLoginname(rs.getString("loginname"));
				ev.setDepartment(rs.getString("department"));
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("根据id获取员工信息DAO错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return ev;
	}
	
	public EmployeeValue get(String loginname) throws Exception {
		// 根据登录名取得指定员工信息
		EmployeeValue ev=null;
		String sql="SELECT * FROM  `carsell`.`employee` WHERE loginname=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, loginname);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ev=new EmployeeValue();
				ev.setId(rs.getInt("userid"));
				ev.setName(rs.getString("username"));
				ev.setPassword(rs.getString("password"));
				ev.setSex(rs.getString("sex"));
				ev.setAge(rs.getInt("age"));
				ev.setLoginname(rs.getString("loginname"));
				ev.setDepartment(rs.getString("department"));
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("根据登录名获取员工信息DAO错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return ev;
	}
	
	public List<EmployeeValue> search(String username) throws Exception {
		// 根据用户名搜索员工信息
		List<EmployeeValue> emplists=new ArrayList<EmployeeValue>();
		String sql="SELECT * FROM  `carsell`.`employee` WHERE username=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				EmployeeValue ev=new EmployeeValue();
				ev.setId(rs.getInt("userid"));
				ev.setName(rs.getString("username"));
				ev.setPassword(rs.getString("password"));
				ev.setSex(rs.getString("sex"));
				ev.setAge(rs.getInt("age"));
				ev.setLoginname(rs.getString("loginname"));
				ev.setDepartment(rs.getString("department"));
				emplists.add(ev);
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("根据用户名搜索员工信息DAO错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return emplists;
	}

}
