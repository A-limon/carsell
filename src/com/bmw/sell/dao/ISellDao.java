package com.bmw.sell.dao;

import java.util.List;

import com.bmw.sell.value.SellValue;

public interface ISellDao {
	
	public void create(SellValue sv)throws Exception;
	//增加销售记录
	public void delete(SellValue sv)throws Exception;
	//删除销售记录
	public SellValue get(int engineid)throws Exception;
	//返回单条销售记录
	public List<SellValue> getList() throws Exception;
	//返回所有销售记录
	public List<SellValue> search(int engineid) throws Exception;
	//根基id返回搜索销售记录
}
