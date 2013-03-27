package com.bmw.sell.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bmw.sell.dao.ISellDao;
import com.bmw.sell.factory.ConnectionFactory;
import com.bmw.sell.value.SellValue;

public class SellDaoImpl implements ISellDao {

	@Override
	public void create(SellValue sv) throws Exception {
		// 增加新的销售记录
		String sql="INSERT INTO `carsell`.`sell`(`engineid`,`selldate`,`carid`,`userid`) VALUES ( ?,?,?,?)";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1, sv.getEngineid());
			ps.setString(2, sv.getSelldate());
			ps.setInt(3,sv.getCarid());
			ps.setInt(4, sv.getUserid());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("销售记录DAO增加错误:"+e.getMessage());
		}finally{
			cn.close();
		}
	}

	@Override
	public void delete(SellValue sv) throws Exception {
		// 删除销售记录
		String sql="DELETE FROM  `carsell`.`sell` WHERE engineid=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1, sv.getEngineid());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("销售记录DAO删除错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public List<SellValue> getList() throws Exception {
		// 返回所有销售记录
		 List<SellValue> selist=new ArrayList<SellValue>();
		 String sql="SELECT `sell`.*, `car`.`carname`, `employee`.`username` FROM `carsell`.`sell`"+
    "INNER JOIN `carsell`.`car` ON (`sell`.`carid` = `car`.`carid`)"+
    "INNER JOIN `carsell`.`employee` ON (`sell`.`userid` = `employee`.`userid`)";
		 Connection cn=null;
		 try{
				cn=ConnectionFactory.getConnection();
				PreparedStatement ps =cn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					SellValue sv=new SellValue();
					sv.setEngineid(rs.getInt("engineid"));
					sv.setSelldate(rs.getString("selldate"));
					sv.setCarid(rs.getInt("carid"));
					sv.setUserid(rs.getInt("userid"));
					sv.setCarname(rs.getString("carname"));
					sv.setUsername(rs.getString("username"));
					selist.add(sv);
				}
				rs.close();
				ps.close();
			}catch(Exception e){
				throw new Exception("获取销售记录错误:"+e.getMessage());
			}finally{
				cn.close();
			}
		 	return selist;
	}

	@Override
	public SellValue get(int engineid) throws Exception {
		// 返回单条销售记录
		SellValue sv=null;
		String sql="SELECT * FROM  `carsell`.`sell` WHERE engineid=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1, engineid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				sv=new SellValue();
				sv.setEngineid(rs.getInt("engineid"));
				sv.setSelldate(rs.getString("selldate"));
				sv.setCarid(rs.getInt("carid"));
				sv.setUserid(rs.getInt("userid"));
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("根据id获取销售记录DAO错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return sv;
		
		
	}

	@Override
	public List<SellValue> search(int engineid) throws Exception {
		 List<SellValue> selist=new ArrayList<SellValue>();
		 String sql="SELECT `sell`.*, `car`.`carname`, `employee`.`username` FROM `carsell`.`sell`"+
    "INNER JOIN `carsell`.`car` ON (`sell`.`carid` = `car`.`carid`)"+
    "INNER JOIN `carsell`.`employee` ON (`sell`.`userid` = `employee`.`userid`) WHERE `engineid`=?";
		 Connection cn=null;
		 try{
				cn=ConnectionFactory.getConnection();
				PreparedStatement ps =cn.prepareStatement(sql);
				ps.setInt(1, engineid);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					SellValue sv=new SellValue();
					sv.setEngineid(rs.getInt("engineid"));
					sv.setSelldate(rs.getString("selldate"));
					sv.setCarid(rs.getInt("carid"));
					sv.setUserid(rs.getInt("userid"));
					sv.setCarname(rs.getString("carname"));
					sv.setUsername(rs.getString("username"));
					selist.add(sv);
				}
				rs.close();
				ps.close();
			}catch(Exception e){
				throw new Exception("搜索销售记录错误:"+e.getMessage());
			}finally{
				cn.close();
			}
		 	return selist;
	}

}
