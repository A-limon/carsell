package com.bmw.sell.dao;

import java.util.List;

import com.bmw.sell.value.ServiceValue;

public interface IServiceDao {
	public void add(ServiceValue ssv )throws Exception;
	//增加预约记录
	public void modify(ServiceValue ssv)throws Exception;
	//修改预约状态
	public ServiceValue get(int serid)throws Exception;
	//获取预约状态
	public List<ServiceValue> getlist()throws Exception;
	//获取所有预约状态

}
