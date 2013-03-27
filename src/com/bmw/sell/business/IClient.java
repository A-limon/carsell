package com.bmw.sell.business;

import java.util.List;

import com.bmw.sell.value.ClientValue;

public interface IClient {
	public void add(int clientid,String clientname,String clientsex,int clientage,String clientphone,String clientmail,int engineid)
			throws Exception;
	//增加客户资料
	public void modify(int clientid,String clientname,String clientsex,int clientage,String clientphone,String clientmail,int engineid)
			throws Exception;
	//修改客户资料
	public void delete(int clientid)throws Exception;
	//删除客户资料
	public ClientValue get(int clientid)throws Exception;
	//获取单一客户资料
	public List<ClientValue> getlist()throws Exception;
	//获取所有客户列表
	public List<ClientValue> search(String clientname)throws Exception;
	//根据姓名搜索返回客户列表
}
