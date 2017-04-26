package com.ran.myapp.dao.employe;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ran.myapp.entities.Banque;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Employe;

/**
 * @author BNAS
 *
 */
public class EmployeDaoImpl implements IEmployeDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private final Logger LOGGER = Logger.getLogger("EmployeDaoImpl");

	@Override
	public Employe addEmploye(Employe employe) {
		// TODO Auto-generated method stub
		entityManager.persist(employe);
		Banque banque = employe.getBanque();
		banque.getListeEmploye().add(employe);
		LOGGER.info("L'employé a bien été enregistré" + employe);
		return employe;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getCompteCree(Long idEmploye) {
	
	/*	Employe employe = entityManager.find(Employe.class,	idEmploye);
		List<Compte> listecompte= employe.getListeCompte();
		LOGGER.info("Liste de compte crée par l'employé sélectionné: " 
		+ listecompte.size());
		*/
		//Query query = entityManager.createQuery("select idCompte FROM tb_employe_compte  where idEmploye=idCompte");
		Query query = entityManager.createQuery("from Compte c join fetch c.banque b join fetch b.listeEmploye e where e.idEmploye =:x").setParameter("x", idEmploye);
	
		System.out.println(query.getResultList());

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employe> getAllEmployeByBanque(Long idBanque) {
		// TODO Auto-generated method stub
		/*Banque banque = entityManager.find(Banque.class,idBanque);
		List<Employe> listeemploye = banque.getListeEmploye();
		LOGGER.info("Liste des employés de la banque sélectionnée: " 
		+ listeemploye.size());*/
		
		Query query = entityManager.createQuery("from Employe e join fetch e.banque b where b.idBanque =:x").setParameter("x",idBanque);		
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employe> getAllEmploye() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("from Employe"); 
		LOGGER.info("Liste des employés toutes banques confondues : " 
		+ query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public Employe getOneEmploye(Long idEmploye) {
		// TODO Auto-generated method stub
		System.out.println("---debut dao getOneEmploye----"+ idEmploye);
		Employe employe = entityManager.find(Employe.class,	idEmploye);
		LOGGER.info("L'employé a bien été trouvé" + employe);
		return employe;
	}


}
