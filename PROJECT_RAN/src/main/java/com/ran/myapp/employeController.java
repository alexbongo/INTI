package com.ran.myapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.swing.text.Document;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ran.myapp.entities.Banque;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Groupes;
import com.ran.myapp.exception.EmployeServiceException;
import com.ran.myapp.service.banque.IBanqueService;
import com.ran.myapp.service.employe.IEmployeService;
import com.ran.myapp.service.groupe.IGroupeService;

//@SessionAttributes("mClients")
@Controller
// @SessionAttributes({"listeEmploye"})
@RequestMapping(value="/admin")
public class employeController {

	@Inject
	private IEmployeService serviceemp;
	@Inject
	private IBanqueService servicebanque;
	@Inject
	private IGroupeService servicegroupe;

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/employe", method = RequestMethod.GET)
	public String home(Model model) {
		List<Banque> banques = new ArrayList<Banque>();
		banques = servicebanque.getAllBanque();
		model.addAttribute("listeBanque", banques);
		List<Employe> employes = serviceemp.getAllEmploye();
		model.addAttribute("listeEmploye", employes);

		return "employe";
	}

	@RequestMapping(value = "/addemploye", method = RequestMethod.POST)
	public String ajouterEmploye(Model model, String nomEmploye,
			Long choixbanque) {
		Employe e = new Employe();
		// Long idBanque=Long.parseLong(choixBanque);
		Banque b = servicebanque.getOneById(choixbanque);
		e.setNomEmploye(nomEmploye);
		e.setBanque(b);
		try {
			serviceemp.addEmploye(e);
		} catch (EmployeServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "employe";
	}

	@RequestMapping(value = "/getemployebyid", method = RequestMethod.POST)
	public String getEmployeById(Model model, Long idEmploye) {
		Employe e = serviceemp.getOneEmploye(idEmploye);
		model.addAttribute("employeById", e);
		List<Compte> comptes=serviceemp.getCompteCree(idEmploye);
		model.addAttribute("compte", comptes);
		List<Groupes> groupesList=e.getListeGroupes();
		Set<Groupes> groupes = new HashSet<Groupes>();
			for (Groupes g:groupesList){
				groupes.add(g);
			}
		model.addAttribute("groupesdelemploye", groupes);
		
		
		return "employe";
	}
	
	@RequestMapping(value = "/getallemploye", method = RequestMethod.POST)
	public String getAllEmploye(Model model, Long choixbanque) {
		List<Employe> employes=serviceemp.getAllEmployeByBanque(choixbanque);
		model.addAttribute("allemploye",employes);
		
		return "employe";
	}

}
