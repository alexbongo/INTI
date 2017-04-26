package com.ran.myapp.dao.compte;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.ran.myapp.dao.banque.IBanqueDao;
import com.ran.myapp.dao.client.IClientDao;
import com.ran.myapp.dao.operation.IOperationDao;
import com.ran.myapp.entities.*;



public class CompteDaoImpl implements ICompteDao{
	@PersistenceContext
	private EntityManager entityManager;
	private final Logger LOGGER=Logger.getLogger("CompteDaoImpl");
	
	
	@Override
	public Compte addCompte(Compte compte, Long idBanque, Long idEmploye) {;
	
	Banque banque = entityManager.find(Banque.class, idBanque);
	compte.setBanque(banque);
	
	Employe employe = entityManager.find(Employe.class, idEmploye);
	
	entityManager.persist(compte);
	
	banque.getListeCompte().add(compte);
	employe.getListeCompte().add(compte);
	
	LOGGER.info("----------Compte crée avec succès---------");
		return compte;
	}

	@Override
	public void deleteCompte(Long idCompte) {
		Compte compte =getCompteById(idCompte);
		
		
		//Compte compte =getCompteById(idCompte);		
		//Banque banque =compte.getBanque();
		//banque.getListeCompte().remove(compte);
		//Query query = entityManager.createNativeQuery("select * from client cl join  compte ct on cl.idClient=ct.fk_client where ct.idCompte=:x");
		//query.setParameter("x", idCompte);
		/*System.out.println(query.getResultList());
		List<Object[]> clients=query.getResultList();
		Client c = null;
		for(Object [] x: clients){
			c = new Client();
			LOGGER.info("start");
			LOGGER.info("x0"+x[0]);
			LOGGER.info(x[1]);
			LOGGER.info(x[2]);
			LOGGER.info(x[3]);
			LOGGER.info(x[4]);
			 Long id = (Long)x[0];
			 String nom = (String)x[1];
			 String prenom = (String)x[1];
			 Date ddn = (Date)x[3];
			 Integer cp = (Integer)x[4];
			 c.setIdClient(id);
			 c.setNomClient(nom);
			 c.setPrenomClient(prenom);
			 c.setDateNaissanceClient(ddn);
			 c.setCpClient(cp);
		}
		LOGGER.info("end");
		c.getListeCompte().remove(compte);*/
		entityManager.remove(compte);	
		;
		LOGGER.info("----------Compte supprimé avec succès---------");
	}

	@Override
	public Compte getCompteById(Long idCompte) {
		Compte compte = entityManager.find(Compte.class, idCompte);
		return compte;
	}

	@Override
	public Compte updateCompte(Compte compte) {
		entityManager.merge(compte);
		LOGGER.info("----------Compte mis à jour---------");
		return compte;
	}

	@Override
	public List<Compte> getCompteByClient(Long idClient) {
		Client c= entityManager.find(Client.class, idClient);
		List<Compte> comptes=c.getListeCompte();
	
		return comptes;
	}

	@Override
	public List<Compte> getAllByBank(Long idBanque) {
		Banque b=entityManager.find(Banque.class, idBanque);
		
		return b.getListeCompte();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Compte> getComptesByEmpl(Long idEmploye) {
		final String SQL = "from Compte c join c.banque b join b.listeEmploye emp where emp.idEmploye =:idEmploye ";
		Query query = entityManager.createQuery(SQL).setParameter("idEmploye", idEmploye);
		return query.getResultList();
	}

}
