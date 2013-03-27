package com.bmw.sell.business.impl;

import java.util.List;

import com.bmw.sell.business.ISell;
import com.bmw.sell.dao.ISellDao;
import com.bmw.sell.factory.DaoFactory;
import com.bmw.sell.value.SellValue;

public class SellImpl implements ISell{

	@Override
	public void add(int engineid, String selldate, int carid, int userid)
			throws Exception {
		// 增加新销售记录
		SellValue sv=new SellValue();
		sv.setEngineid(engineid);
		sv.setSelldate(selldate);
		sv.setCarid(carid);
		sv.setUserid(userid);
		ISellDao sdo=DaoFactory.getSellDao();
		sdo.create(sv);
		
	}

	@Override
	public void delete(int engineid) throws Exception {
		// 删除销售记录
		ISellDao sdo=DaoFactory.getSellDao();
		SellValue sv=sdo.get(engineid);
		if(sv!=null){
			sdo.delete(sv);
		}
		
	}

	@Override
	public List<SellValue> getList() throws Exception {
		// 返回销售列表
		ISellDao sdo=DaoFactory.getSellDao();
		return sdo.getList();
	}

	@Override
	public SellValue get(int engineid) throws Exception {
		// 返回单一销售信息
		ISellDao sdo=DaoFactory.getSellDao();
		return sdo.get(engineid);
	}

	@Override
	public List<SellValue> search(int engineid) throws Exception {
		ISellDao sdo=DaoFactory.getSellDao();
		
		return sdo.search(engineid);
	}

}
