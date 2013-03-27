package com.bmw.sell.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bmw.sell.dao.IClientDao;
import com.bmw.sell.factory.ConnectionFactory;
import com.bmw.sell.value.ClientValue;


public class ClientDaoImpl implements IClientDao{

	@Override
	public void create(ClientValue civ) throws Exception {
		String sql="INSERT INTO `carsell`.`client`(`clientid`,`clientname`,`clientsex`,`clientage`,`clientphone`,`clientmail`,`engineid`) VALUES ( NULL,?,?,?,?,?,?)";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1,civ.getClientname());
			ps.setString(2,civ.getClientsex());
			ps.setInt(3, civ.getClientage());
			ps.setString(4, civ.getClientphone());
			ps.setString(5, civ.getClientmail());
			ps.setInt(6, civ.getEngineid());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("客户DAO增加错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public void edit(ClientValue civ) throws Exception {
		String sql="UPDATE `carsell`.`client` SET `clientname`=?,`clientsex`=?,`clientage`=?,`clientphone`=?,`clientmail`=?,`engineid`=?  WHERE `clientid`=? ";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1,civ.getClientname());
			ps.setString(2,civ.getClientsex());
			ps.setInt(3, civ.getClientage());
			ps.setString(4, civ.getClientphone());
			ps.setString(5, civ.getClientmail());
			ps.setInt(6, civ.getEngineid());
			ps.setInt(7,civ.getClientid());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("客户DAO修改错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public void delete(ClientValue civ) throws Exception {
		String sql="DELETE FROM  `carsell`.`client` WHERE `clientid`=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1,civ.getClientid());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("客户DAO删除错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public ClientValue get(int clientid) throws Exception {
		ClientValue civ=null;
		String sql="SELECT * FROM  `carsell`.`client` WHERE clientid=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1, clientid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				civ=new ClientValue();
				civ.setClientid(rs.getInt("clientid"));
				civ.setClientname(rs.getString("clientname"));
				civ.setClientsex(rs.getString("clientsex"));
				civ.setClientage(rs.getInt("clientage"));
				civ.setClientphone(rs.getString("clientphone"));
				civ.setClientmail(rs.getString("clientmail"));
				civ.setEngineid(rs.getInt("engineid"));
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("根据id获取客户信息DAO错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		
		return civ;
	}

	@Override
	public List<ClientValue> getlist() throws Exception {
		List<ClientValue> cilist=new ArrayList<ClientValue>();
		String sql="SELECT `client`.* , `sell`.`selldate`, `car`.`carname`"+
				"FROM `carsell`.`client` INNER JOIN `carsell`.`sell` ON (`client`.`engineid` = `sell`.`engineid`)"+
				"INNER JOIN `carsell`.`car` ON (`sell`.`carid` = `car`.`carid`);";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ClientValue civ=new ClientValue();
				civ.setClientid(rs.getInt("clientid"));
				civ.setClientname(rs.getString("clientname"));
				civ.setClientsex(rs.getString("clientsex"));
				civ.setClientage(rs.getInt("clientage"));
				civ.setClientphone(rs.getString("clientphone"));
				civ.setClientmail(rs.getString("clientmail"));
				civ.setEngineid(rs.getInt("engineid"));
				civ.setSelldate(rs.getString("selldate"));
				civ.setCarname(rs.getString("carname"));
				cilist.add(civ);
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("获取客户列表信息错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return cilist;
	}

	@Override
	public List<ClientValue> search(String clientname) throws Exception {
		List<ClientValue> cilist=new ArrayList<ClientValue>();
		ClientValue civ=new ClientValue();
		
		String sql="SELECT `client`.* , `sell`.`selldate`, `car`.`carname`"+
				"FROM `carsell`.`client` INNER JOIN `carsell`.`sell` ON (`client`.`engineid` = `sell`.`engineid`)"+
				"INNER JOIN `carsell`.`car` ON (`sell`.`carid` = `car`.`carid`) WHERE clientname=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, clientname);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				civ.setClientid(rs.getInt("clientid"));
				civ.setClientname(rs.getString("clientname"));
				civ.setClientsex(rs.getString("clientsex"));
				civ.setClientage(rs.getInt("clientage"));
				civ.setClientphone(rs.getString("clientphone"));
				civ.setClientmail(rs.getString("clientmail"));
				civ.setEngineid(rs.getInt("engineid"));
				civ.setSelldate(rs.getString("selldate"));
				civ.setCarname(rs.getString("carname"));
				cilist.add(civ);
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("根据姓名搜索客户信息错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return cilist;
	}

}
