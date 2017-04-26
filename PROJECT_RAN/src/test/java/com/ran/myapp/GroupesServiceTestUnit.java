/**
 * 
 */
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
import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Groupes;
import com.ran.myapp.exception.EmployeServiceException;
import com.ran.myapp.service.banque.IBanqueService;
import com.ran.myapp.service.employe.IEmployeService;
import com.ran.myapp.service.groupe.IGroupeService;

/**
 * @author inti0312
 *
 */
public class GroupesServiceTestUnit {
	
	private static ClassPathXmlApplicationContext context;
	private static IGroupeService service;
	private static IBanqueService servicebanque;
	private static IEmployeService serviceemploye;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IGroupeService) context.getBean("groupesservice");
		servicebanque = (IBanqueService) context.getBean("banqueservice");
		serviceemploye = (IEmployeService) context.getBean("employeservice");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	

	/**
	 * Test method for {@link com.ran.myapp.service.groupe.GroupesServiceImpl#addGroupes(com.ran.myapp.entities.Groupes, java.lang.Long)}.
	 */
	@Test //ok
	@Ignore
	public void testAddGroupes() {
		//fail("Not yet implemented");
		
		Groupes grp = service.addGroupes(new Groupes());
		assertNotNull(grp.getIdGroupes());
	}

	/**
	 * Test method for {@link com.ran.myapp.service.groupe.GroupesServiceImpl#addEmployeInGroupes(java.lang.Long, java.lang.Long)}.
	 * @throws EmployeServiceException 
	 */
	@Test //ok
	@Ignore
	public void testAddEmployeInGroupes() throws EmployeServiceException {
		//fail("Not yet implemented");
		
		Employe emp = serviceemploye.getOneEmploye(3L);
		Groupes grp = service.addGroupes(new Groupes("groupe1", null));
		//System.out.println(emp.getIdEmploye());
		//System.out.println(grp.getIdGroupes());
		Employe emp2= service.addEmployeInGroupes(emp.getIdEmploye(), grp.getIdGroupes());
		//System.out.println(emp2.getListeGroupes());
		assertTrue(emp2.getListeGroupes().size()>0);
	}

	/**
	 * Test method for {@link com.ran.myapp.service.groupe.GroupesServiceImpl#getAllGroupes(java.lang.Long)}.
	 * @throws EmployeServiceException 
	 */
	@Test //ok
	@Ignore
	public void testGetAllGroupes() throws EmployeServiceException {
		//fail("Not yet implemented");
		//Banque banque = servicebanque.addBanque(new Banque());
	//	Employe emp1 = new Employe();
		//emp1.setBanque(banque);
		//Employe emp2 = new Employe();
		//emp2.setBanque(banque);
		//Groupes grp1 = service.addGroupes(new Groupes());
		//service.addEmployeInGroupes(emp1.getIdEmploye(), grp1.getIdGroupes());
		//Groupes grp2 = service.addGroupes(new Groupes());
		//service.addEmployeInGroupes(emp2.getIdEmploye(), grp2.getIdGroupes());
		System.out.println(service.getAllGroupes(1L));
		assertTrue(service.getAllGroupes(1L).size()>0);
	}

	/**
	 * Test method for {@link com.ran.myapp.service.groupe.GroupesServiceImpl#getEmployeByGroupes(java.lang.Long)}.
	 * @throws EmployeServiceException 
	 */
	@Test //ok
	public void testGetEmployeByGroupes() throws EmployeServiceException {
		//fail("Not yet implemented");
		
		
		Employe emp1 = serviceemploye.getOneEmploye(2L);
		Employe emp2 = serviceemploye.getOneEmploye(3L);
		
		Groupes grp = service.addGroupes(new Groupes("mongrptest", new ArrayList<Employe>()));
		
		service.addEmployeInGroupes(emp1.getIdEmploye(), grp.getIdGroupes());
		service.addEmployeInGroupes(emp2.getIdEmploye(), grp.getIdGroupes());
		
		System.out.println(service.getEmployeByGroupes(grp.getIdGroupes()));
		assertTrue(service.getEmployeByGroupes(grp.getIdGroupes()).size()>0);
		
	}

}
