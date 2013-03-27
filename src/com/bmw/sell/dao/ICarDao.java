package com.bmw.sell.dao;

import java.util.List;

import com.bmw.sell.value.CarValue;

public interface ICarDao {
	public void create(CarValue cv)throws Exception;
	//增加车型
	public void update(CarValue cv)throws Exception;
	//修改车型
	public void delete(CarValue cv)throws Exception;
	//删除车型
	public List<CarValue> getList() throws Exception;
	//返回所有车型
	public CarValue get(int id) throws Exception;
	//根据ID返回单一车型
	public List<CarValue> search(String carname) throws Exception;
	//根据名称搜索返回单一车型
}
