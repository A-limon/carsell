package com.bmw.sell.business;

import java.util.List;

import com.bmw.sell.value.CarValue;


public interface ICar {
	public void add(int id,String carname,Float price,String color,String engine,String carpic,int stock)
			throws Exception;
	//增加车型
	public void modify(int id,String carname,Float price,String color,String engine,String carpic,int stock)
			throws Exception;
	//修改车型
	public void delete(int id) throws Exception;
	//删除车型
	public List<CarValue> getList() throws Exception;
	//返回所有车型
	public CarValue get(int id) throws Exception;
	//根据ID返回单一车型
	public List<CarValue> search(String carname) throws Exception;
	//根据名称搜索返回单一车型
}
