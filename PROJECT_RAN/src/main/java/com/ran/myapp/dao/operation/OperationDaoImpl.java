package com.ran.myapp.dao.operation;

import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Operation;
import com.ran.myapp.entities.Retrait;
import com.ran.myapp.entities.Versement;
import com.ran.myapp.service.operation.IOperationService;

public class OperationDaoImpl implements IOperationDao {

	////
	@PersistenceContext
	private EntityManager entitymanger;
	private final Logger LOGGER=Logger.getLogger("OperationDaoImpl");
	@Override
	public Operation createOperation(Operation operation) {
		
		entitymanger.persist(operation);
		if (operation.getCompte()!=null){
			operation.getCompte().getListeOperations().add(operation);
		}
		LOGGER.info("L'operation: " +operation+ " a été créee");
		return operation;
	}

	@Override
	public Operation effectuerVersement(Date date, Double montant, Long idCompte) {
		
		Operation operation = new Versement(date, montant);
		
		Compte compte=entitymanger.find(Compte.class,idCompte);
		compte.setSoldeCompte(compte.getSoldeCompte()+montant);
		operation.setCompte(compte);
		createOperation(operation);
		
		LOGGER.info("Le versement suivant a été effectué : " + montant);
		return operation;
	}

	@Override
	public Operation effectuerRetrait(Date date, Double montant, Long idCompte) {
		
		
		Compte compte=entitymanger.find(Compte.class,idCompte);
		compte.setSoldeCompte(compte.getSoldeCompte()-montant);
		Operation operation = new Retrait(date, montant);
		operation.setCompte(compte);
		createOperation(operation);
		
		LOGGER.info("Le retrait suivant a été effectué : " + montant);
		return operation;
	}

	@Override
	public void effectuerVirement(Date date, Double montant, Long compteDepart,
			Long compteArrivee) {
		
		
		effectuerRetrait(date, montant, compteDepart);
		effectuerVersement(date, montant, compteArrivee);
		
		
		LOGGER.info("Le virement suivant a été effectué : " + montant);
	}

	@Override
	public void deletOperation(Operation operation) {
		
		
		entitymanger.remove(operation);
		
		LOGGER.info("L'operation   " +operation+" a été supprimer " );
	}

}
