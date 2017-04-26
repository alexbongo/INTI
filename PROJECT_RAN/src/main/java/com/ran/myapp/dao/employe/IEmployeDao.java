package com.ran.myapp.dao.employe;

import java.util.List;

import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Employe;

/**
 * @author BNAS
 *
 */
public interface IEmployeDao {

	Employe addEmploye(Employe employe);
	
	Employe getOneEmploye(Long idEmploye );

	List<Compte> getCompteCree(Long idEmploye );
	
	List<Employe> getAllEmployeByBanque(Long idBanque);

	List<Employe> getAllEmploye();
}
