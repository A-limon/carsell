package com.bmw.sell.business.impl;

import java.util.List;

import com.bmw.sell.business.ICar;
import com.bmw.sell.dao.ICarDao;
import com.bmw.sell.factory.DaoFactory;
import com.bmw.sell.value.CarValue;

public class CarImpl implements ICar{

	@Override
	public void add(int id, String carname, Float price, String color,
			String engine, String carpic,int stock) throws Exception {
		CarValue cv=new CarValue();
		cv.setCarid(id);
		cv.setCarname(carname);
		cv.setPrice(price);
		cv.setColor(color);
		cv.setStock(stock);
		cv.setCarpic(carpic);
		cv.setEngine(engine);
		ICarDao cdo=DaoFactory.getCarDao();
		cdo.create(cv);
		
	}

	@Override
	public void modify(int id, String carname, Float price, String color,
			String engine, String carpic,int stock) throws Exception {
		ICarDao cdo=DaoFactory.getCarDao();
		CarValue cv=cdo.get(id);
		if(cv!=null){
			cv.setCarid(id);
			cv.setCarname(carname);
			cv.setPrice(price);
			cv.setColor(color);
			cv.setStock(stock);
			cv.setCarpic(carpic);
			cv.setEngine(engine);
			cdo.update(cv);
		}
	}

	@Override
	public void delete(int id) throws Exception {
		ICarDao cdo=DaoFactory.getCarDao();
		CarValue cv=cdo.get(id);
		if(cv!=null){
			cdo.delete(cv);
		}
		
	}

	@Override
	public List<CarValue> getList() throws Exception {
		ICarDao cdo=DaoFactory.getCarDao();
		return cdo.getList();
	}

	@Override
	public CarValue get(int id) throws Exception {
		ICarDao cdo=DaoFactory.getCarDao();
		return cdo.get(id);
	}

	@Override
	public List<CarValue> search(String carname) throws Exception {
		ICarDao cdo=DaoFactory.getCarDao();
		return cdo.search(carname);
	}

}
