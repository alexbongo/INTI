/**
 * 
 */
package com.ran.myapp.service.groupe;

import java.util.List;

import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Groupes;
import com.ran.myapp.exception.EmployeServiceException;

/**
 * @author BNAS
 *
 */
public interface IGroupeService {

	Groupes addGroupes(Groupes groupes );

	Employe addEmployeInGroupes(Long idEmploye, Long idGroupes) throws EmployeServiceException;
	
	List<Groupes> getAllGroupes(Long idBanque); 
	List<Groupes> getAllGroupes2();
	
	List<Employe> getEmployeByGroupes(Long idGroupes);

}
