package com.bmw.sell.business.impl;

import java.util.List;

import com.bmw.sell.business.IService;
import com.bmw.sell.dao.IServiceDao;
import com.bmw.sell.factory.DaoFactory;
import com.bmw.sell.value.ServiceValue;

public class ServiceImpl implements IService {

	@Override
	public void add(int serid, String serdate, String serstate, int clientid)
			throws Exception {
		ServiceValue ssv=new ServiceValue();
		ssv.setSerid(serid);
		ssv.setSerdate(serdate);
		ssv.setSerstate(serstate);
		ssv.setClientid(clientid);
		IServiceDao isd=DaoFactory.getServiceDao();
		isd.add(ssv);
	}

	@Override
	public void modify(int serid, String serdate, String serstate)
			throws Exception {
		IServiceDao isd=DaoFactory.getServiceDao();
		ServiceValue ssv=isd.get(serid);
		if(ssv!=null){
			ssv.setSerdate(serdate);
			ssv.setSerstate(serstate);
			isd.modify(ssv);		
		}
		
	}

	@Override
	public ServiceValue get(int serid) throws Exception {
		IServiceDao isd=DaoFactory.getServiceDao();
		return isd.get(serid);
	}

	@Override
	public List<ServiceValue> getlist() throws Exception {
		IServiceDao isd=DaoFactory.getServiceDao();
		return isd.getlist();
	}

}
