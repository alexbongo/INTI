package com.ran.myapp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ran.myapp.entities.Banque;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Courant;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Epargne;
import com.ran.myapp.entities.Groupes;
import com.ran.myapp.entities.Operation;
import com.ran.myapp.exception.EmployeServiceException;
import com.ran.myapp.service.banque.IBanqueService;
import com.ran.myapp.service.compte.ICompteService;
import com.ran.myapp.service.employe.IEmployeService;

public class EmployeServiceTestUnit {
	
	private static ClassPathXmlApplicationContext context;
	private static IEmployeService service;
	private static IBanqueService servicebanque;
	private static ICompteService servicecompte;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IEmployeService) context.getBean("employeservice");
		servicebanque = (IBanqueService) context.getBean("banqueservice");
		servicecompte = (ICompteService) context.getBean("compteservice");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}  


	@Test

	public void testAddEmploye() {
		//fail("Not yet implemented");
		System.out.println(service);
		Banque banque = servicebanque.getOneById(1L);
		Employe emp = null;
		try {
			emp = service.addEmploye(new Employe("Alex",banque,new ArrayList<Compte>(), new ArrayList<Operation>(), new ArrayList<Groupes>()));
		} catch (EmployeServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(emp.getIdEmploye());
	}

	@Test

	@Ignore
	public void testGetCompteCree() {
		//fail("Not yet implemented");
		
		Employe emp = service.getOneEmploye(2L);
		
		Compte c1= servicecompte.addCompte(new Epargne(), 1L,1L) ;
		Compte c2= servicecompte.addCompte(new Courant(), 1L,1L) ;
		
		emp.getListeCompte().add(c1);
		emp.getListeCompte().add(c2);
		System.out.println(emp.getListeCompte());
		assertTrue(emp.getListeCompte().size()>0);
		
	}

	@Test
	@Ignore
	public void testGetAllEmployeByBanque() {
		//fail("Not yet implemented");
		List<Employe> listeemploye = service.getAllEmployeByBanque(1L);
		System.out.println(listeemploye.size());
		assertTrue(listeemploye.size()>0);
	}

	@Test
	@Ignore
	public void testGetAllEmploye() {
		//fail("Not yet implemented");
		List<Employe> listeemploye = service.getAllEmploye();
				
		assertTrue(listeemploye.size()>0);
	}
	
	@Test
	@Ignore
	public void getOneEmploye() {
		//fail("Not yet implemented");
		Employe emp = service.getOneEmploye(2L);
				
		assertTrue(emp !=null);
	}
	
}
