package com.ran.myapp.service.operation;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.ran.myapp.dao.compte.ICompteDao;
import com.ran.myapp.dao.operation.IOperationDao;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Operation;
import com.ran.myapp.exception.OperationException;
import com.ran.myapp.service.compte.ICompteService;

@Transactional(readOnly=true)
public class OperationServiceImpl implements IOperationService {

	@Inject
	private IOperationDao daoOperation;
	@Inject
	private ICompteDao daoCompte;
	
	//nour
	

	/**
	 * @param daoCompte the daoCompte to set
	 */
	public void setDaoCompte(ICompteDao daoCompte) {
		this.daoCompte = daoCompte;
	}

	/**
	 * @param daoOperation the daoOperation to set
	 */
	public void setDaoOperation(IOperationDao daoOperation) {
		this.daoOperation = daoOperation;
	}

	@Override
	@Transactional(readOnly=false)
	public Operation createOperation(Operation operation) {
		
		
		return daoOperation.createOperation(operation);
	}

	@Override
	@Transactional(readOnly=false)
	public Operation effectuerVersement(Date date,Double montant, Long idCompte)  {
		
		
			return daoOperation.effectuerVersement(date, montant, idCompte);
		
		
	}

	@Override
	@Transactional(readOnly=false)
	public Operation effectuerRetrait(Date date ,Double montant, Long idCompte)throws OperationException {
		
		Compte compte=daoCompte.getCompteById(idCompte);
		Operation operation = null;
		if(compte.getSoldeCompte()>=montant)
		{
		operation = daoOperation.effectuerRetrait(date, montant, idCompte);
		}
		else
		{
			throw new OperationException("Le solde insuffisant pour cette opération.");
		}
		
		return operation;
	}

	@Override
	@Transactional(readOnly=false)
	public void effectuerVirement(Date date, Double montant, Long compteDepart,
			Long compteArrivee) throws OperationException {
		
		Compte compte=daoCompte.getCompteById(compteDepart);
		
		if(compte.getSoldeCompte()>=montant)
		{
			daoOperation.effectuerVirement(date ,montant, compteDepart, compteArrivee);
		}
		
		else
		{
			throw new OperationException("Le solde insuffisant pour cette opération.");
		}
		
		
	}

	@Override
	public void deletOperation(Operation operation) {
		
		daoOperation.deletOperation(operation);
		
	}

}
