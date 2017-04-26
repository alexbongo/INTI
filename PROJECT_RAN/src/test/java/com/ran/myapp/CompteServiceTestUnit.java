package com.ran.myapp;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ran.myapp.entities.Banque;
import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Courant;
import com.ran.myapp.entities.Epargne;
import com.ran.myapp.entities.Operation;
import com.ran.myapp.entities.Retrait;
import com.ran.myapp.exception.ForbiddenBanqueSwitchException;
import com.ran.myapp.service.banque.IBanqueService;
import com.ran.myapp.service.client.IClientService;
import com.ran.myapp.service.compte.ICompteService;

public class CompteServiceTestUnit {

	private static ClassPathXmlApplicationContext context;
	@Inject
	private static ICompteService service;
	@Inject
	private static IBanqueService serviceb;
	@Inject
	private static IClientService servicec;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (ICompteService) context.getBean("compteservice");
		serviceb = (IBanqueService) context.getBean("banqueservice");
		servicec=(IClientService) context.getBean("clientservice");
		Banque banque=serviceb.addBanque(new Banque());
	
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	


	@Test
	@Ignore
	public void testAddCompte() {
		Client jean=null;
		Compte c=new Epargne(500.0, new Date(), jean, 0.25);
		
		try {
			service.addCompte(c, 1L,1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(c.getIdCompte()!=null);
	}

	@Test
	@Ignore
	public void testDeleteCompte() {
		Compte a= new Epargne();
		service.addCompte(a, 1L,1L);
		List<Compte> liste1=service.getAllByBank(1L);
		service.deleteCompte(a.getIdCompte());
		List<Compte> liste2=service.getAllByBank(1L);
		assertTrue(liste1.size()!=liste2.size());
		
	}

	@Test
	@Ignore
	public void testGetCompteById() {
		service.addCompte(new Epargne(), 1L,1L);
		Compte compte=service.getCompteById(1L);
		assertTrue(compte.getIdCompte()==1L);

	}

	@Test
	@Ignore
	public void testUpdateCompte() {
		service.addCompte(new Epargne(), 1L,1L);
		Compte compte= service.getCompteById(1L);
		compte.setSoldeCompte(800.0);
		try {
			service.updateCompte(compte);
		} catch (ForbiddenBanqueSwitchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(compte.getSoldeCompte()==800.0);
	}

	@Test
	@Ignore
	public void testGetCompteByClient() {
		Client jean = new Client();
		//servicec.addClient(jean, 1L);
		Compte c1 = new Courant();
		Compte c2 =new Epargne();
		service.addCompte(c1, 1L,1L);
		service.addCompte(c2, 1L,1L);
		c1.setClient(jean);
		c2.setClient(jean);
		
		assertTrue(service.getCompteByClient(1L).size()==2);
		
	}

	@Test
	@Ignore
	public void testGetAllByBank() {
		Compte c1=new Epargne();
		Compte c2=new Epargne();
		Compte c3=new Courant();
		service.addCompte(c1, 1L,1L);
		service.addCompte(c2, 1L,1L);
		service.addCompte(c3, 1L,1L);
		/*b.getListeCompte().add(c1);
		b.getListeCompte().add(c2);
		b.getListeCompte().add(c3);*/
		
		System.out.println("La taille du tableau de compte dans la banque est : " +service.getAllByBank(1L).size());
		assertTrue(service.getAllByBank(1L).size()==3);
	}

}
