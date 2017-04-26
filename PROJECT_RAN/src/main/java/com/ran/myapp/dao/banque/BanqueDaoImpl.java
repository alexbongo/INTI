package com.ran.myapp.dao.banque;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ran.myapp.entities.Banque;
import com.ran.myapp.entities.Client;

public class BanqueDaoImpl implements IBanqueDao {

	private final Logger LOGGER = Logger.getLogger("BanqueDaoImpl");
	@PersistenceContext
	private EntityManager entitymanger;
	@Override
	public Banque addBanque(Banque banque) {
		
		entitymanger.persist(banque);
		LOGGER.info("the banque "+banque+ " has been added " );
		
		return banque;
	}
	@Override
	public Banque getOneById(Long idBanque) {
		Banque b=entitymanger.find(Banque.class, idBanque);
		LOGGER.info("the banque corresponde of this id is  "+b);
		return b;
	}
	@Override
	public Banque updateBanque(Banque banque) {
		entitymanger.merge(banque);
		
		LOGGER.info("the banque has been update with the new banque information: "+banque);
		return banque;
	}
	@Override
	public List<Banque> getAllBanque() {
		
		Query query =entitymanger.createQuery("from Banque");
		return query.getResultList();
	}
}
