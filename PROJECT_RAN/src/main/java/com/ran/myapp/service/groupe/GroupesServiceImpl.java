package com.ran.myapp.service.groupe;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ran.myapp.dao.employe.IEmployeDao;
import com.ran.myapp.dao.groupe.IGroupesDao;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Groupes;
import com.ran.myapp.exception.EmployeServiceException;
import com.ran.myapp.service.employe.IEmployeService;

/**
 * @author BNAS
 *
 */
@Transactional(readOnly=true) 
public class GroupesServiceImpl implements IGroupeService{
    @Inject
	private IGroupesDao daogroupes;
    @Inject
	private IEmployeDao daoemploye;
	//private IEmployeService serviceEmploye = new IEmployeService() {
		
	
	private final Logger LOGGER = Logger.getLogger("GroupesServiceImpl");
	
	/**
	  @param daoemploye the daoemploye to set
	 */
	public void setDaoemploye(IEmployeDao daoemploye) {
		this.daoemploye = daoemploye;
		LOGGER.info("--------------Injection--daoemploye--------------");
	}

	
	/**
	 * @param daogroupes the daogroupes to set
	 */
	public void setDaogroupes(IGroupesDao daogroupes) {
		this.daogroupes = daogroupes;
		LOGGER.info("--------------Injection--daogroupe--------------");
	}

	@Override
	@Transactional(readOnly=false)
	public Groupes addGroupes(Groupes groupes ) {
		// TODO Auto-generated method stub
		return daogroupes.addGroupes(groupes );
	}

	@Override
	@Transactional(readOnly=false)
	public Employe addEmployeInGroupes(Long idEmploye, Long idGroupes) throws EmployeServiceException {
		// TODO Auto-generated method stub
		
		Employe e4 = daoemploye.getOneEmploye(idEmploye);
		System.out.println(e4);
		Employe e3 = null;
		Boolean bool = true;
		System.out.println(daogroupes.getEmployeByGroupes(idGroupes));
		if (daogroupes.getEmployeByGroupes(idGroupes).size()==0 || 
				daogroupes.getEmployeByGroupes(idGroupes)== null){
			bool = true;
			LOGGER.info("Le groupe ne contient aucun employé");
		}else if (daogroupes.getEmployeByGroupes(idGroupes).size()>0){
			for (Employe e:daogroupes.getEmployeByGroupes(idGroupes)){
				System.out.println(e.getNomEmploye());
				System.out.println(e4.getNomEmploye());
				if (e.getNomEmploye().equals(e4.getNomEmploye())){
					LOGGER.info("L'employé existe déja dans le groupe");
					bool= false;
					throw new EmployeServiceException("L'employé appartient déjà au groupe selectionné");
				}
			}	
		}
		
		if (bool){
			System.out.println("---ajout d'employé----");
			e3 = daogroupes.addEmployeInGroupes(idEmploye, idGroupes);
			LOGGER.info("L'employé a été ajouté au groupe");
		}
		return e3;
	}

	@Override
	public List<Groupes> getAllGroupes(Long idBanque) {
		// TODO Auto-generated method stub
		return daogroupes.getAllGroupes(idBanque);
	}

	@Override
	public List<Employe> getEmployeByGroupes(Long idGroupes) {
		// TODO Auto-generated method stub
		return daogroupes.getEmployeByGroupes(idGroupes);
	}


	@Override
	public List<Groupes> getAllGroupes2() {
		// TODO Auto-generated method stub
		return daogroupes.getAllGroupes2();
	}

}
