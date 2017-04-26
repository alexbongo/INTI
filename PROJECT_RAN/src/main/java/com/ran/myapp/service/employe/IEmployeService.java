/**
 * 
 */
package com.ran.myapp.service.employe;

import java.util.List;

import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.exception.EmployeServiceException;

/**
 * @author BNAS
 *
 */
public interface IEmployeService {

	Employe addEmploye(Employe employe) throws EmployeServiceException;
	
	Employe getOneEmploye(Long idEmploye );

	List<Compte> getCompteCree(Long idEmploye );
	
	List<Employe> getAllEmployeByBanque(Long idBanque);

	List<Employe> getAllEmploye();
}
