package com.ran.myapp.dao.groupe;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Groupes;

/**
 * @author BNAS
 *
 */
public class GroupesDaoImpl implements IGroupesDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private final Logger LOGGER = Logger.getLogger("EmployeDaoImpl");

	@Override
	public Groupes addGroupes(Groupes groupes) {
		// TODO Auto-generated method stub
		entityManager.persist(groupes);
		LOGGER.info("Le groupe a bien été enregistré" + groupes);
		return groupes;
	}

	@Override
	public Employe addEmployeInGroupes(Long idEmploye, Long idGroupes) {
		// TODO Auto-generated method stub
		Employe employe = entityManager.find(Employe.class,	idEmploye);
		Groupes groupes = entityManager.find(Groupes.class, idGroupes);
		employe.getListeGroupes().add(groupes);
		//entityManager.persist(employe);
		groupes.getListeEmploye().add(employe);
		//entityManager.persist(groupes);
		LOGGER.info(employe+ " a bien été enregistré au " + groupes);
		return employe;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groupes> getAllGroupes(Long idBanque) {
		// TODO Auto-generated method stub
		//Query query = entityManager.createNativeQuery("select * from Groupes gpe join TB_EMPLOYE_GROUPES teg on gpe.idGroupes = teg.idGroupes join Employe emp on teg.idEmploye = emp.idEmploye where emp.fk_Banque=?1"); 
		//query.setParameter(1, idBanque);
		Query query = entityManager.createQuery("from Groupes");
		List<Groupes> listegrp = query.getResultList();
		System.out.println(listegrp);
		Iterator<Groupes> i = listegrp.iterator();
		while (i.hasNext()) {
			Groupes grp = i.next(); // must be called before you can call i.remove()
			if (grp.getListeEmploye()== null || grp.getListeEmploye().size()==0){
				i.remove();
			}
			else if (grp.getListeEmploye().get(0).getBanque().getIdBanque().equals(idBanque)){
			}else {
				i.remove();
			}
		}
		
		LOGGER.info("Liste des groupes de la banque sélectionnée: " 
		+ listegrp.size());
		return listegrp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employe> getEmployeByGroupes(Long idGroupes) {
		// TODO Auto-generated method stub
		Groupes groupes = entityManager.find(Groupes.class, idGroupes);
		List<Employe> listeemploye = groupes.getListeEmploye();
		LOGGER.info("Liste des employés du groupe sélectionné: " 
		+ listeemploye.size());
		return listeemploye;
	}

	@Override
	public List<Groupes> getAllGroupes2() {
		Query query=entityManager.createQuery("from Groupes");
		List<Groupes> groupes=query.getResultList();
		return groupes;
	}

}
