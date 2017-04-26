package com.ran.myapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ran.myapp.entities.Banque;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Groupes;
import com.ran.myapp.exception.EmployeServiceException;
import com.ran.myapp.service.employe.IEmployeService;
import com.ran.myapp.service.groupe.IGroupeService;

@Controller
@SessionAttributes("allGroupes")
//@RequestMapping(value="/admin")
public class groupeController {
	@Inject
	private IGroupeService serviceGroupe;
	@Inject
	private IEmployeService serviceEmploye;

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/groupe", method = RequestMethod.GET)
	public String home(Model model) {
		List<Groupes> groupesList = new ArrayList<Groupes>();
		groupesList=serviceGroupe.getAllGroupes2();
		/*for (Long i = 1L; i < 4L; ++i) {
			groupesList.addAll(serviceGroupe.getAllGroupes(i));     //Récupère tous les groupes de toutes les banques
		}
		Set<Groupes> groupes=new HashSet<Groupes>();
		for (Groupes g:groupesList){
			groupes.add(g);
			
		}*/
		model.addAttribute("allGroupes", groupesList);

		return "groupe";
	}

	/*
	 * @RequestMapping(value = "/groupeTest", method = RequestMethod.GET) public
	 * String test(Model model, @ModelAttribute("allGroupes")List<Groupes> list)
	 * { System.out.println("ok"); return null; }
	 */

	@RequestMapping(value = "/addgroupe", method = RequestMethod.POST)
	public String ajouterGroupe(Model model, String nomGroupe) {
		serviceGroupe.addGroupes(new Groupes(nomGroupe, null));
		return "groupe";
	}
	
	@RequestMapping(value = "/addemployetogroup", method = RequestMethod.POST)
	public String affectergroupe(Model model, Long idEmploye, Long idGroupe) {
		try {
			serviceGroupe.addEmployeInGroupes(idEmploye, idGroupe);
		} catch (EmployeServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "groupe";
	}
	
	

	@RequestMapping(value = "/getemployeingroup", method = RequestMethod.POST)
	public String getEmployeByGroup(Model model, Long choixgroupe) {
		List<Employe> groupi=serviceGroupe.getEmployeByGroupes(choixgroupe);
		model.addAttribute("EmployeeByGroup",groupi);
		
		
		return "groupe";
	}
}


