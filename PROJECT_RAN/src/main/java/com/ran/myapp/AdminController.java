/**
 * 
 */
package com.ran.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ran.myapp.service.compte.ICompteService;
import com.ran.myapp.service.employe.IEmployeService;
import com.ran.myapp.service.operation.IOperationService;

/**
 * @author inti0312
 *
 */
@Controller
@SessionAttributes({"listeEmploye","choixidemploye1","montant1","listecompteemploye1","nomemploye1","listecompte","resultat_op"})
//@RequestMapping(value="/admin")
public class AdminController {

private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private IEmployeService serviceEmploye;
	@Inject
	private ICompteService serviceCompte;
	@Inject
	private IOperationService serviceOperation;
	
	
	/**
	 * Simply selects the home employe view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/ac_admin", method = RequestMethod.GET)
	public String home_admin(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "acceuil_admin";
	}
	
	
	
	
	
	
}
