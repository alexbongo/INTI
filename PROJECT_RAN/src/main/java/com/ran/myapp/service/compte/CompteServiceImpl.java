package com.ran.myapp.service.compte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.ran.myapp.dao.banque.IBanqueDao;
import com.ran.myapp.dao.client.IClientDao;
import com.ran.myapp.dao.compte.ICompteDao;
import com.ran.myapp.dao.employe.IEmployeDao;
import com.ran.myapp.dao.operation.IOperationDao;
import com.ran.myapp.entities.Banque;
import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Operation;
import com.ran.myapp.exception.ForbiddenBanqueSwitchException;

@Transactional(readOnly=true)
public class CompteServiceImpl implements ICompteService{

	@Inject
	private ICompteDao daoCompte;
	@Inject
	private IOperationDao daoOperation;
	@Inject
	private IClientDao daoClient;

	@Inject
	private IEmployeDao daoEmploye;
	
	private final Logger LOGGER=Logger.getLogger("CompteServiceImpl");
	
	
	
	
	/**
	 * @param daoCompte the daoCompte to set
	 */
	public void setDaoCompte(ICompteDao daoCompte) {
		this.daoCompte = daoCompte;
		LOGGER.info("----------Connexion Compte établie---------");
	}

	@Override
	@Transactional(readOnly=false)
	public Compte addCompte(Compte compte, Long idBanque, Long idEmploye) {
		daoCompte.addCompte(compte, idBanque, idEmploye);
		
		return compte;
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteCompte(Long idCompte) {
		Compte c =daoCompte.getCompteById(idCompte);
		
		List<Employe> listEmploye=daoEmploye.getAllEmployeByBanque(c.getBanque().getIdBanque());
		
		//Suppression de la jointure entre compte et operation.
		for(Employe i:listEmploye)
		{
			List<Compte> listCompte=i.getListeCompte();
			for(Compte j:listCompte )
			{
				
				if(j.equals(c))
				{
					i.getListeOperation().clear();
					
				}
			}
		}
		
		
		for (Operation o:c.getListeOperations()){
			daoOperation.deletOperation(o);
		}
		
		//Suppression de la jointure entre compte et employe.
		for(Employe i:listEmploye)
		{
			List<Compte> listCompte=i.getListeCompte();
			List<Compte> compteConcerne=new ArrayList<Compte>();
			for(Compte j:listCompte )
			{
				
				if(j.equals(c))
				{
					compteConcerne.add(j);
					
				}
			}
			listCompte.removeAll(compteConcerne);
		}
		//Suppression de la jointure entre compte et client.
		//List<Client> clients=daoClient.getClientByBanque(c.getBanque().getIdBanque());
		
		daoCompte.deleteCompte(idCompte);
		
	}

	@Override
	public Compte getCompteById(Long idCompte) {
		// TODO Auto-generated method stub
		return daoCompte.getCompteById(idCompte);
	}

	@Override
	@Transactional(readOnly=false)
	public Compte updateCompte(Compte compte) throws ForbiddenBanqueSwitchException {
		Compte compteAvantModif=daoCompte.getCompteById(compte.getIdCompte());
		Banque banqueDepart=compteAvantModif.getBanque();
		Banque banqueArrivee= compte.getBanque();
		if (banqueDepart.getIdBanque()!=banqueArrivee.getIdBanque()){
			throw new ForbiddenBanqueSwitchException("Impossible de changer de banque !");
		}
		else {
			daoCompte.updateCompte(compte);
		}	
		
		return compte;
	}

	@Override
	public List<Compte> getCompteByClient(Long idClient) {

		return daoCompte.getCompteByClient(idClient);
	}

	@Override
	public List<Compte> getAllByBank(Long idBanque) {
		
		return daoCompte.getAllByBank(idBanque);
	}

	@Override
	public List<Compte> getComptesByEmpl(Long idEmploye) {
		// TODO Auto-generated method stub
		return daoCompte.getComptesByEmpl(idEmploye);
	}

}
