package com.bmw.sell.business.impl;

import java.util.List;

import com.bmw.sell.business.IClient;
import com.bmw.sell.dao.IClientDao;
import com.bmw.sell.factory.DaoFactory;
import com.bmw.sell.value.ClientValue;

public class ClientImpl implements IClient{

	@Override
	public void add(int clientid, String clientname, String clientsex,
			int clientage, String clientphone, String clientmail, int engineid)
			throws Exception {
		ClientValue civ=new ClientValue();
		civ.setClientid(clientid);
		civ.setClientname(clientname);
		civ.setClientsex(clientsex);
		civ.setClientage(clientage);
		civ.setClientphone(clientphone);
		civ.setClientmail(clientmail);
		civ.setEngineid(engineid);
		IClientDao cdao=DaoFactory.getClientDao();
		cdao.create(civ);
		
	}

	@Override
	public void modify(int clientid, String clientname, String clientsex,
			int clientage, String clientphone, String clientmail, int engineid)
			throws Exception {
		IClientDao cdao=DaoFactory.getClientDao();
		ClientValue civ=cdao.get(clientid);
		if(civ!=null){
			civ.setClientname(clientname);
			civ.setClientsex(clientsex);
			civ.setClientage(clientage);
			civ.setClientphone(clientphone);
			civ.setClientmail(clientmail);
			civ.setEngineid(engineid);
			cdao.edit(civ);
			
		}
		
		
	}

	@Override
	public void delete(int clientid) throws Exception {
		IClientDao cdao=DaoFactory.getClientDao();
		ClientValue civ=cdao.get(clientid);
		if(civ!=null){
			cdao.delete(civ);
		}
		
		
	}

	@Override
	public ClientValue get(int clientid) throws Exception {
		IClientDao cdao=DaoFactory.getClientDao();
		return cdao.get(clientid);
	}

	@Override
	public List<ClientValue> getlist() throws Exception {
		IClientDao cdao=DaoFactory.getClientDao();
		return cdao.getlist();
	}

	@Override
	public List<ClientValue> search(String clientname) throws Exception {
		IClientDao cdao=DaoFactory.getClientDao();
		return cdao.search(clientname);
	}

}
