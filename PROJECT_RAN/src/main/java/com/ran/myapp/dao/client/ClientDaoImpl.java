package com.ran.myapp.dao.client;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ran.myapp.dao.banque.IBanqueDao;
import com.ran.myapp.entities.Banque;
import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Compte;

public class ClientDaoImpl implements IClientDao {

	@PersistenceContext
	private EntityManager entitymanger;
	
	private static final Logger LOGGER=Logger.getLogger("ClientDaoImpl");
	
	@Override
	public Client addClient(Client client,Long idBanque) {
		Banque banque= entitymanger.find(Banque.class, idBanque);
		client.setBanque(banque);
		entitymanger.persist(client);
		banque.getListeClient().add(client);
		LOGGER.info("the client  "+client+" has been added");
		return client;
	}

	@Override
	public void removeClient(Long idClient) {
		
		Client c= getOneClient(idClient);
		Banque b=c.getBanque();
		b.getListeClient().remove(c);
		List<Compte> comptes=c.getListeCompte();
		for (Compte cpte:comptes){
			entitymanger.remove(cpte);
		}
		Client client=getOneClient(idClient);
		entitymanger.remove(client);
		
		LOGGER.info("the client  "+client+" has been removed");
		
	}

	@Override
	public Client updateClient(Client client) {
		
		entitymanger.merge(client);
		
		LOGGER.info("the client  "+client+" has been updated");
		return client;
	}

	@Override
	public List<Compte> getComptes(Long idClient) {
		Client client =entitymanger.find(Client.class, idClient);
		LOGGER.info("the list of comptet by this id is:  "+client.getListeCompte());
		return client.getListeCompte();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClientByMC(String motCle) {
		Query query =entitymanger.createQuery("from Client c where c.nomClient like:x");
		query.setParameter("x", "%"+motCle+"%");
		
		LOGGER.info("the list of client found with this keyword is  "+query.getResultList());
		return query.getResultList();
	}

	@Override
	public List<Client> getClientByBanque(Long idBanque) {
		

		Query query =entitymanger.createQuery("select listeClient from Banque b where b.idBanque like:x");
		query.setParameter("x", idBanque);
		return query.getResultList();
	}

	@Override
	public Client getOneClient(Long idClient) {
		Client c=entitymanger.find(Client.class, idClient);
		LOGGER.info("the client found with is id is  :"+c);
		return c;
	}

}
