package com.ran.myapp.dao.groupe;


import java.util.List;

import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Groupes;

/**
 * @author BNAS
 *
 */
public interface IGroupesDao {

	
	Groupes addGroupes(Groupes groupes);

	Employe addEmployeInGroupes(Long idEmploye, Long idGroupes);
	
	List<Groupes> getAllGroupes(Long idBanque);
	List<Groupes> getAllGroupes2();
	
	List<Employe> getEmployeByGroupes(Long idGroupes);

}
