package com.bmw.sell.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bmw.sell.dao.ICarDao;
import com.bmw.sell.factory.ConnectionFactory;
import com.bmw.sell.value.CarValue;

public class CarDaoImpl implements ICarDao {

	@Override
	public void create(CarValue cv) throws Exception {
		// 增加新车型
		String sql="INSERT INTO `carsell`.`car`(`carid`,`carpic`,`carname`,`price`,`color`,`engine`,`stock`) VALUES ( NULL,?,?,?,?,?,?)"; 
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, cv.getCarpic());
			ps.setString(2, cv.getCarname());
			ps.setFloat(3, cv.getPrice());
			ps.setString(4, cv.getColor());
			ps.setString(5, cv.getEngine());
			ps.setInt(6, cv.getStock());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("车型DAO增加错误:"+e.getMessage());
		}finally{
			cn.close();
		}
	}

	@Override
	public void update(CarValue cv) throws Exception {
		// 更新车型
		String sql="UPDATE `carsell`.`car` SET `carpic`=?,`carname`=?,`price`=?,`color`=?,`engine`=?,`stock`=? WHERE `carid`=? "; 
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, cv.getCarpic());
			ps.setString(2, cv.getCarname());
			ps.setFloat(3, cv.getPrice());
			ps.setString(4, cv.getColor());
			ps.setString(5, cv.getEngine());
			ps.setInt(6, cv.getStock());
			ps.setInt(7, cv.getCarid());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("车型DAO更新错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public void delete(CarValue cv) throws Exception {
		// 删除现有车型
				String sql="DELETE FROM  `carsell`.`car` WHERE carid=?";
				Connection cn=null;
				try{
					cn=ConnectionFactory.getConnection();
					PreparedStatement ps =cn.prepareStatement(sql);
					ps.setInt(1, cv.getCarid());
					ps.executeUpdate();
					ps.close();
				}catch(Exception e){
					throw new Exception("车型DAO删除错误:"+e.getMessage());
				}finally{
					cn.close();
				}
	}

	@Override
	public List<CarValue> getList() throws Exception {
		// TODO Auto-generated method stub
		List<CarValue> carlist=new ArrayList<CarValue>();
		String sql="SELECT * FROM  `carsell`.`car`";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CarValue cv=new CarValue();
				cv.setCarid(rs.getInt("carid"));
				cv.setCarname(rs.getString("carname"));
				cv.setCarpic(rs.getString("carpic"));
				cv.setColor(rs.getString("color"));
				cv.setStock(rs.getInt("stock"));
				cv.setEngine(rs.getString("engine"));
				cv.setPrice(rs.getFloat("price"));
				carlist.add(cv);
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("获取车型信息错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return carlist;
	}

	@Override
	public CarValue get(int id) throws Exception {
		CarValue cv=null;
		String sql="SELECT * FROM  `carsell`.`car` WHERE carid=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cv=new CarValue();
				cv.setCarid(rs.getInt("carid"));
				cv.setCarname(rs.getString("carname"));
				cv.setCarpic(rs.getString("carpic"));
				cv.setColor(rs.getString("color"));
				cv.setStock(rs.getInt("stock"));
				cv.setEngine(rs.getString("engine"));
				cv.setPrice(rs.getFloat("price"));
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("根据id获取汽车信息DAO错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return cv;
	}

	@Override
	public List<CarValue> search(String carname) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
