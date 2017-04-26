package com.ran.myapp;

import java.text.DateFormat; 
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.jpa.criteria.expression.ConcatExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Operation;
import com.ran.myapp.exception.OperationException;
import com.ran.myapp.service.compte.ICompteService;
import com.ran.myapp.service.employe.IEmployeService;
import com.ran.myapp.service.operation.IOperationService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"listeEmploye","choixidemploye1","montant1","listecompteemploye1","nomemploye1","listecompte","resultat_op"})
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private IEmployeService serviceEmploye;
	@Inject
	private ICompteService serviceCompte;
	@Inject
	private IOperationService serviceOperation;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("comment...!");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "acceuil_ran";
	}
	
	
	/**
	 * Simply selects the home employe view to render by returning its name.
	 */
	@RequestMapping(value = "/ac_employe", method = RequestMethod.GET)
	public String home_employe(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "acceuil_employe";
	}
	
	
	
	/**
	 * Simply selects the home employe view to render by returning its name.
	 */
	@RequestMapping(value = "/op_ran", method = RequestMethod.GET)
	public String home_operation(Locale locale, Model model) {
		
		List<Employe> listeEmploye = serviceEmploye.getAllEmploye();
		model.addAttribute("listeEmploye", listeEmploye);
		
		model.addAttribute("resultat_op", "Bonjour, Veuillez vous identifier puis choisir l'action à exécuter. Bon travail!");
		
		return "operation_ran";
	}
	
	@RequestMapping(value = "/nour", method = RequestMethod.GET)
	public String home_nour(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "nour";
	}
	
	/**
	 * Simply selects the home employe view to render by returning its name.
	 */
	@RequestMapping(value = "/choixoperation", method = RequestMethod.POST)
	public String choix_operation(Model model, String choixidemploye1, 
			 String montant1) {
		
		model.addAttribute("choixidemploye1", choixidemploye1);
		model.addAttribute("nomemploye1", serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye1)).getNomEmploye());
		model.addAttribute("montant1", montant1);
		
		List<Compte> lescomptesemp = serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye1)).getListeCompte();
		Set<Compte> listecompteemp=new HashSet<Compte>();
		for (Compte c:lescomptesemp){
			listecompteemp.add(c);
		}

		model.addAttribute("listecompteemploye1", listecompteemp);
		
		List<Compte> lescomptes = serviceCompte.getAllByBank(serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye1)).getBanque().getIdBanque());
		Set<Compte> listecompte=new HashSet<Compte>();
		for (Compte c:lescomptes){
			listecompte.add(c);
		}

		model.addAttribute("listecompte", listecompte);
		
		
		//model.addAttribute("listecompte", serviceCompte.getAllByBank(serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye1)).getBanque().getIdBanque()));
		
		List<Employe> listeEmploye = serviceEmploye.getAllEmploye();
		model.addAttribute("listeEmploye", listeEmploye);
		
		
		return "operation_ran";
	}
	
	/**
	 * Simply selects the home employe view to render by returning its name.
	 */
	@RequestMapping(value = "/choixversement", method = RequestMethod.POST)
	public String versement_operation(Model model, String choixidemploye2, String choixidcompte1,
			 String montant2) {
		
		model.addAttribute("choixidemploye1", choixidemploye2);
		model.addAttribute("nomemploye1", serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye2)).getNomEmploye());
		model.addAttribute("montant1", montant2);
		
		
		List<Compte> lescomptes = serviceCompte.getAllByBank(serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye2)).getBanque().getIdBanque());
		Set<Compte> listecompte=new HashSet<Compte>();
		for (Compte c:lescomptes){
			listecompte.add(c);
		}
		System.out.println(listecompte);
		model.addAttribute("listecompteemploye1", listecompte);
		Operation operation = serviceOperation.effectuerVersement(new Date(), Double.parseDouble(montant2), Long.parseLong(choixidcompte1));
		Compte compte = serviceCompte.getCompteById(Long.parseLong(choixidcompte1));
		
		
		String resultstring = "Le compte n° "+ choixidcompte1+" a été crédité de "+ montant2 +" euros et le nouveau solde du compte est : "+ compte.getSoldeCompte()+ " euros.";
		model.addAttribute("resultat_op", resultstring);
				
		List<Employe> listeEmploye = serviceEmploye.getAllEmploye();
		model.addAttribute("listeEmploye", listeEmploye);
		
		
		return "operation_ran";
	}
	
	/**
	 * Simply selects the home employe view to render by returning its name.
	 */
	@RequestMapping(value = "/choixretrait", method = RequestMethod.POST)
	public String retrait_operation(Model model, String choixidemploye3, String choixidcompte2,
			 String montant3) {
		
		model.addAttribute("choixidemploye1", choixidemploye3);
		model.addAttribute("nomemploye1", serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye3)).getNomEmploye());
		model.addAttribute("montant1", montant3);
		//model.addAttribute("listecompte", serviceCompte.getAllByBank(serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye3)).getBanque().getIdBanque()));
		List<Compte> lescomptes = serviceCompte.getAllByBank(serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye3)).getBanque().getIdBanque());
		Set<Compte> listecompte=new HashSet<Compte>();
		for (Compte c:lescomptes){
			listecompte.add(c);
		}
		System.out.println(listecompte);
		model.addAttribute("listecompte", listecompte);
		
		
		List<Employe> listeEmploye = serviceEmploye.getAllEmploye();
		model.addAttribute("listeEmploye", listeEmploye);
		
		String resultstring="";
		try {
			Operation operation = serviceOperation.effectuerRetrait(new Date(), Double.parseDouble(montant3), Long.parseLong(choixidcompte2));
			Compte compte = serviceCompte.getCompteById(Long.parseLong(choixidcompte2));
			resultstring = "Le compte n° "+ choixidcompte2+" a été débité de "+ montant3 +" euros et le nouveau solde du compte est : "+ compte.getSoldeCompte()+ " euros.";
			model.addAttribute("resultat_op", resultstring);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationException e) {
			// TODO Auto-generated catch block
			model.addAttribute("resultat_op", e.getMessage());
		}
		
		// Message envoyé
		//if (compte.getSoldeCompte()<Double.parseDouble(montant3)){
		//	resultstring = "Le compte n° "+ choixidcompte2+" n'a pas été débité de "+ montant3 +" euros car son solde de : "+ compte.getSoldeCompte()+ " euros est insuffisant";
			
		//}else{
			//resultstring = "Le compte n° "+ choixidcompte2+" a été débité de "+ montant3 +" euros et le nouveau solde du compte est : "+ compte.getSoldeCompte()+ " euros.";
			
		//}
		//model.addAttribute("resultat_op", resultstring);
		
		return "operation_ran";
	}
	
	/**
	 * Simply selects the home employe view to render by returning its name.
	 */
	@RequestMapping(value = "/choixvirement", method = RequestMethod.POST)
	public String virement_operation(Model model, String choixidemploye4, String choixidcompte3,
			 String choixidcompte4, String montant4) {
		
		model.addAttribute("choixidemploye1", choixidemploye4);
		model.addAttribute("nomemploye1", serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye4)).getNomEmploye());
		model.addAttribute("montant1", montant4);
		model.addAttribute("listecompte", serviceCompte.getAllByBank(serviceEmploye.getOneEmploye(Long.parseLong(choixidemploye4)).getBanque().getIdBanque()));
		try {
			serviceOperation.effectuerVirement(new Date(),Double.parseDouble(montant4), Long.parseLong(choixidcompte3), Long.parseLong(choixidcompte4));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Compte compte = serviceCompte.getCompteById(Long.parseLong(choixidcompte3));
		
		String resultstring="";
		// Message envoyé
				if (compte.getSoldeCompte()<Double.parseDouble(montant4)){
					resultstring = "Le compte n° "+ choixidcompte3+" n'a pas été débité de "+ montant4 +" euros car son solde de : "+ compte.getSoldeCompte()+ " euros est insuffisant";
					
				}else{
					resultstring = "Le compte n° "+ choixidcompte3+" a été débité de "+ montant4 +" euros suite à un virement vers le compte n° "+ choixidcompte4+" et le nouveau solde du compte est : "+ compte.getSoldeCompte()+ " euros.";
					
				}
				model.addAttribute("resultat_op", resultstring);
		
		

		
		List<Employe> listeEmploye = serviceEmploye.getAllEmploye();
		model.addAttribute("listeEmploye", listeEmploye);
		
		return "operation_ran";
	}
	
	
}
