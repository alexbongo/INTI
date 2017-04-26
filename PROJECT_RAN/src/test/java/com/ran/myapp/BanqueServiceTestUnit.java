/**
 * 
 */
package com.ran.myapp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ran.myapp.entities.Banque;
import com.ran.myapp.exception.BanqueException;
import com.ran.myapp.service.banque.IBanqueService;

/**
 * @author inti0408
 *
 */
public class BanqueServiceTestUnit {

	
	private static ClassPathXmlApplicationContext context;
	
	private static IBanqueService service;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service=(IBanqueService) context.getBean("banqueservice");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	/**
	 * Test method for {@link com.ran.myapp.service.banque.BanqueServiceImpl#addBanque(com.ran.myapp.entities.Banque)}.
	 * @throws BanqueException 
	 */
	@Test
	public void testAddBanque() throws BanqueException {
		
		Banque banque =new Banque("cic", 94140, "34 quai alfortvile");
		service.addBanque(banque);
		assertNotNull(banque.getIdBanque());
		
	}

	/**
	 * Test method for {@link com.ran.myapp.service.banque.BanqueServiceImpl#getOneById(java.lang.Long)}.
	 */
	@Test
	public void testGetOneById() {
		
		List<Banque> listeBanque=new ArrayList<Banque>();
		listeBanque.addAll(service.getAllBanque());
		assertNotNull(listeBanque.size());
	}

	/**
	 * Test method for {@link com.ran.myapp.service.banque.BanqueServiceImpl#updateBanque(com.ran.myapp.entities.Banque)}.
	 *//*
	@Test
	public void testUpdateBanque() {
		fail("Not yet implemented");
	}
*/
	/**
	 * Test method for {@link com.ran.myapp.service.banque.BanqueServiceImpl#getAllBanque()}.
	 */
	@Test
	public void testGetAllBanque() {
		
		List<Banque> listeBanque=new ArrayList<Banque>();
		listeBanque.addAll(service.getAllBanque());
		assertTrue(listeBanque.size()>0);
		
	}

}
