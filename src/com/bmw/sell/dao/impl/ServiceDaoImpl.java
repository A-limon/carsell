package com.bmw.sell.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bmw.sell.dao.IServiceDao;
import com.bmw.sell.factory.ConnectionFactory;
import com.bmw.sell.value.ServiceValue;

public class ServiceDaoImpl implements IServiceDao {

	@Override
	public void add(ServiceValue ssv) throws Exception {
		String sql="INSERT INTO `carsell`.`service`(`serid`,`serdate`,`serstate`,`clientid`) VALUES ( NULL,?,'预约',?)";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, ssv.getSerdate());
			ps.setInt(2, ssv.getClientid());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("服务DAO增加错误:"+e.getMessage());
		}finally{
			cn.close();
		}
	}

	@Override
	public void modify(ServiceValue ssv) throws Exception {
		String sql="UPDATE `carsell`.`service` SET `serdate`=?,`serstate`=?  WHERE `serid`=? ";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1,ssv.getSerdate());
			ps.setString(2,ssv.getSerstate());
			ps.setInt(3, ssv.getSerid());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			throw new Exception("服务DAO修改错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public ServiceValue get(int serid) throws Exception {
		ServiceValue ssv=null;
		String sql="SELECT `service`.*, `client`.`clientname` FROM `carsell`.`service`"+
    "INNER JOIN `carsell`.`client` ON (`service`.`clientid` = `client`.`clientid`) WHERE `serid`=?";
		Connection cn=null;
		try{
			cn=ConnectionFactory.getConnection();
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setInt(1, serid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ssv=new ServiceValue();
				ssv.setSerid(rs.getInt("serid"));
				ssv.setSerdate(rs.getString("serdate"));
				ssv.setSerstate(rs.getString("serstate"));
				ssv.setClientid(rs.getInt("clientid"));
				ssv.setClientname(rs.getString("clientname"));
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			throw new Exception("根据id获取服务信息DAO错误:"+e.getMessage());
		}finally{
			cn.close();
		}
		return ssv;
	}

	@Override
	public List<ServiceValue> getlist() throws Exception {
		List<ServiceValue> serlist=new ArrayList<ServiceValue>();
		String sql="SELECT `service`.*, `client`.`clientname` FROM `carsell`.`service`"+
			    "INNER JOIN `carsell`.`client` ON (`service`.`clientid` = `client`.`clientid`)";
					Connection cn=null;
					try{
						cn=ConnectionFactory.getConnection();
						PreparedStatement ps =cn.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						while(rs.next()){
							ServiceValue ssv=new ServiceValue();
							ssv.setSerid(rs.getInt("serid"));
							ssv.setSerdate(rs.getString("serdate"));
							ssv.setSerstate(rs.getString("serstate"));
							ssv.setClientid(rs.getInt("clientid"));
							ssv.setClientname(rs.getString("clientname"));
							serlist.add(ssv);
						}
						rs.close();
						ps.close();
					}catch(Exception e){
						throw new Exception("获取服务列表DAO错误:"+e.getMessage());
					}finally{
						cn.close();
					}
		return serlist;
	}

}
