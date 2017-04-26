/**
 * 
 */
package com.ran.myapp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.exception.ClientException;
import com.ran.myapp.service.client.IClientService;



/**
 * @author inti0408
 * 
 */

public class ClientServiceTestUnit {

	private static ClassPathXmlApplicationContext context;

	private static IClientService service;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IClientService) context.getBean("clientservice");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		context.close();
	}

	/**
	 * Test method for
	 * {@link com.ran.myapp.service.client.ClientServiceImpl#addClient(com.ran.myapp.entities.Client, java.lang.Long)}
	 * .
	 * @throws ClientException 
	 */
	@Test
	@Ignore
	public void testAddClient() throws ClientException {

		Client c = new Client("alsafadi", "nour", new Date(), 94140);
		Client c1 = new Client("alsafadi", "joui", new Date(), 45698);
		service.addClient(c, 1L);
		service.addClient(c1, 1L);
		assertNotNull(c.getIdClient());

	}

	/**
	 * Test method for
	 * {@link com.ran.myapp.service.client.ClientServiceImpl#removeClient(java.lang.Long)}
	 * .
	 */
	@Test
	@Ignore
	public void testRemoveClient() {
		
		List<Client> etudients=service.getClientByBanque(1L);
		service.removeClient(2L);
		List<Client> etudients2=service.getClientByBanque(1L);
		assertTrue(etudients.size()-1==etudients2.size());
	}

	/**
	 * Test method for
	 * {@link com.ran.myapp.service.client.ClientServiceImpl#updateClient(com.ran.myapp.entities.Client)}
	 * .
	 */
	@Test
	@Ignore
	public void testUpdateClient() {
		
		Client beforUpdate=service.getOneClient(3L);
		
		Client AfterUpdate=service.getOneClient(3L);
		AfterUpdate.setPrenomClient("nour");
		Client verify =service.updateClient(AfterUpdate);
		//Assert.assertThat(verify.getPrenomClient(), IsEqual.equalTo(beforUpdate.getPrenomClient()));
		//assertTrue(verify.getPrenomClient().equals(beforUpdate.getPrenomClient()));
		
		Assert.assertThat(beforUpdate.getPrenomClient(),IsNot.not(IsEqual.equalTo(verify.getPrenomClient())));
	}

	/**
	 * Test method for
	 * {@link com.ran.myapp.service.client.ClientServiceImpl#getComptes(java.lang.Long)}
	 * .
	 */
	@Test
	public void testGetComptes() {
		
		List<Compte> listeCompte=new ArrayList<Compte>();
		listeCompte.addAll(service.getComptes(3L));
		assertTrue(listeCompte.size()>0);
	}

	/**
	 * Test method for
	 * {@link com.ran.myapp.service.client.ClientServiceImpl#getClientByMC(java.lang.String)}
	 * .
	 */
	@Test
	@Ignore
	public void testGetClientByMC() {
		
		String mc="al";
		List<Client> clients=service.getClientByMC(mc);	
		List<Client> clients1=service.getClientByBanque(1L);
		List<Client> clients2=new ArrayList<Client>();
		for(Client i:clients1)
		{
			if(i.getNomClient().contains(mc))
			{
				clients2.add(i);
			}
		}

		assertTrue(clients.size()==clients2.size());
	}

	/**
	 * Test method for
	 * {@link com.ran.myapp.service.client.ClientServiceImpl#getClientByBanque(java.lang.Long)}
	 * .
	 */
	@Test
	@Ignore
	public void testGetClientByBanque() {
		
		List<Client> listeClient= service.getClientByBanque(1L);
		
		assertTrue(listeClient.size()>0);
		
	}

	/**
	 * Test method for
	 * {@link com.ran.myapp.service.client.ClientServiceImpl#getOneClient(java.lang.Long)}
	 * .
	 */
	@Test
	@Ignore
	public void testGetOneClient() {
		List<Client> listeClient=new ArrayList<Client>();
		listeClient.add(service.getOneClient(4L));
		assertTrue(listeClient.size()>0);
	}

}
