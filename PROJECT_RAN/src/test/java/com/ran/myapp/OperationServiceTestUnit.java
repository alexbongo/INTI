/**
 * 
 */
package com.ran.myapp;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Operation;
import com.ran.myapp.entities.Retrait;
import com.ran.myapp.entities.Versement;
import com.ran.myapp.exception.OperationException;
import com.ran.myapp.service.compte.ICompteService;
import com.ran.myapp.service.groupe.IGroupeService;
import com.ran.myapp.service.operation.IOperationService;

/**
 * @author inti0408
 *
 */
public class OperationServiceTestUnit {
//nour2
	private static ClassPathXmlApplicationContext context;
	
	private static IOperationService service;
	
	private static ICompteService serviceCompte;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IOperationService) context.getBean("operationservice");
		serviceCompte=(ICompteService) context.getBean("compteservice");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		
		context.close();
	}
	

	/**
	 * Test method for {@link com.ran.myapp.service.operation.OperationServiceImpl#setDaoCompte(com.ran.myapp.service.compte.ICompteService)}.
	 */
	@Test
	@Ignore
	public void testSetDaoCompte() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ran.myapp.service.operation.OperationServiceImpl#setDaoOperation(com.ran.myapp.service.operation.IOperationService)}.
	 */
	@Test
	@Ignore
	public void testSetDaoOperation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ran.myapp.service.operation.OperationServiceImpl#createOperation(com.ran.myapp.entities.Operation)}.
	 */
	@Test
	@Ignore
	public void testCreateOperation() {
		
		Operation operationRetrai=new Retrait(new Date(), 200.0);
		service.createOperation(operationRetrai);
		assertNotNull(operationRetrai.getMontantOperation());
		
	}

	/**
	 * Test method for {@link com.ran.myapp.service.operation.OperationServiceImpl#effectuerVersement(java.lang.Double, java.lang.Long)}.
	 */
	@Test
	@Ignore
	public void testEffectuerVersement() {
		
		Compte compteBefor=serviceCompte.getCompteById(1L);
	
		double montantBefor=compteBefor.getSoldeCompte();
		
		service.effectuerVersement(new Date(),200.0, 1L);
		Compte compteAfter=serviceCompte.getCompteById(1L);
		double montantafter=compteAfter.getSoldeCompte();
		assertTrue(montantafter>montantBefor);
		
	}

	/**
	 * Test method for {@link com.ran.myapp.service.operation.OperationServiceImpl#effectuerRetrait(java.lang.Double, java.lang.Long)}.
	 * @throws OperationException 
	 */
	@Test
	@Ignore
	public void testEffectuerRetrait() throws OperationException {


		Compte compteBefor=serviceCompte.getCompteById(1L);
	
		double montantBefor=compteBefor.getSoldeCompte();
	
		service.effectuerRetrait(new Date(),200.0, 1L);
		Compte compteAfter=serviceCompte.getCompteById(1L);
		double montantafter=compteAfter.getSoldeCompte();
		assertTrue(montantafter<montantBefor);
		
	}

	/**
	 * Test method for {@link com.ran.myapp.service.operation.OperationServiceImpl#effectuerVirement(java.lang.Double, java.lang.Long, java.lang.Long)}.
	 * @throws OperationException 
	 */
	@Test
	
	public void testEffectuerVirement() throws OperationException {
		Compte compteBeforDep=serviceCompte.getCompteById(1L);
		double montantBeforDep=compteBeforDep.getSoldeCompte();
		Compte compteBeforArr=serviceCompte.getCompteById(2L);
		double montantBeforArr=compteBeforArr.getSoldeCompte();
		service.effectuerVirement(new Date(), 200.0, 1L, 2L);
		Compte compteAfter=serviceCompte.getCompteById(1L);
		Compte compteAfterDep=serviceCompte.getCompteById(1L);
		double montantAfterDep=compteAfterDep.getSoldeCompte();
		Compte compteAfterArr=serviceCompte.getCompteById(2L);
		double montantAfterArr=compteAfterArr.getSoldeCompte();
		
		assertTrue(montantBeforDep>montantAfterDep);
		
		assertTrue(montantBeforArr<montantAfterArr);
	}

}
