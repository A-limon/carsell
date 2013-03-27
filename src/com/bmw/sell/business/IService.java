package com.bmw.sell.business;

import java.util.List;

import com.bmw.sell.value.ServiceValue;

public interface IService {
	public void add(int serid,String serdate,String serstate,int clientid )throws Exception;
	//增加预约记录
	public void modify(int serid,String serdate,String serstate)throws Exception;
	//修改预约状态
	public ServiceValue get(int serid)throws Exception;
	//获取预约状态
	public List<ServiceValue> getlist()throws Exception;
	//获取所有预约状态

}
