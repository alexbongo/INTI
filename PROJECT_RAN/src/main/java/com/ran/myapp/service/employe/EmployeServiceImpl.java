/**
 * 
 */
package com.ran.myapp.service.employe;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.ran.myapp.dao.employe.IEmployeDao;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.exception.EmployeServiceException;

/**
 * @author BNAS
 *
 */
@Transactional(readOnly=true)
public class EmployeServiceImpl implements IEmployeService{
	
	private IEmployeDao daoemploye;
	
	private final Logger LOGGER = Logger.getLogger("EmployeServiceImpl");
	

	/**
	 * @param daoemploye the daoemploye to set
	 */
	public void setDaoemploye(IEmployeDao daoemploye) {
		this.daoemploye = daoemploye;
		LOGGER.info("--------------Injection----------------");
	}

	@Override
	@Transactional(readOnly=false)
	public Employe addEmploye(Employe employe) throws EmployeServiceException {
		// TODO Auto-generated method stub
		Employe emp = null;
		Boolean bool= true;
		for (Employe e: employe.getBanque().getListeEmploye()){
			if (employe.getNomEmploye().equalsIgnoreCase(e.getNomEmploye())){
				LOGGER.info("L'employé existe déja et ne sera pas ajouté à nouveau dans la banque selectionné");
				bool = false;
				throw new EmployeServiceException("Cet employé existe déjà");
			
			}
		}
		if (bool){
			emp = daoemploye.addEmploye(employe);
			
		}
		return emp;
	}

	@Override
	public List<Compte> getCompteCree(Long idEmploye) {
		// TODO Auto-generated method stub
		return daoemploye.getCompteCree(idEmploye);
	}

	@Override
	public List<Employe> getAllEmployeByBanque(Long idBanque) {
		// TODO Auto-generated method stub
		return daoemploye.getAllEmployeByBanque(idBanque);
	}

	@Override
	public List<Employe> getAllEmploye() {
		// TODO Auto-generated method stub
		return daoemploye.getAllEmploye();
	}

	@Override
	public Employe getOneEmploye(Long idEmploye) {
		// TODO Auto-generated method stub
		return daoemploye.getOneEmploye(idEmploye);
	}

}
