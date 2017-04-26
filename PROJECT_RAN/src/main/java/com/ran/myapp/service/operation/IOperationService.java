package com.ran.myapp.service.operation;

import java.util.Date;

import com.ran.myapp.entities.Operation;
import com.ran.myapp.exception.OperationException;

public interface IOperationService {
	
	Operation createOperation(Operation operation);
	  
	Operation effectuerVersement(Date date, Double montant, Long idCompte);
	   
	Operation effectuerRetrait(Date date,Double montant, Long idCompte)throws OperationException;
	  
	   void effectuerVirement(Date date, Double montant, Long compteDepart, Long compteArrivee) throws OperationException;
	   
	   void deletOperation(Operation operation);

}
