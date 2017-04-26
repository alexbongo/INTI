package com.ran.myapp.dao.operation;

import java.util.Date;

import com.ran.myapp.entities.Operation;

public interface IOperationDao {
	
	
		Operation createOperation(Operation operation);
	  
		Operation effectuerVersement(Date date, Double montant, Long idCompte);
	   
		Operation effectuerRetrait(Date date, Double montant, Long idCompte);
	  
		void effectuerVirement(Date date, Double montant, Long compteDepart, Long compteArrivee);
	   
	   void deletOperation(Operation operation);

}
