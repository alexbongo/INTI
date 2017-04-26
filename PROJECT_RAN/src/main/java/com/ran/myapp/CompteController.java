package com.ran.myapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.entities.Courant;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.entities.Epargne;
import com.ran.myapp.entities.Operation;
import com.ran.myapp.exception.ForbiddenBanqueSwitchException;
import com.ran.myapp.service.client.IClientService;
import com.ran.myapp.service.compte.ICompteService;
import com.ran.myapp.service.employe.IEmployeService;
import com.ran.myapp.service.operation.IOperationService;

@Controller
@SessionAttributes({"listEmployeCompte","employeCompte","listClientCompte","listCompte","listCompteCourant","listCompteEpargne"})
public class CompteController {
	
	@Inject
	private ICompteService service;
	
	@Inject
	private IEmployeService serviceEmploye;
	
	@Inject
	private IClientService serviceClient;
	
	@Inject
	private IOperationService serviceOperation;
	
private static final Logger logger = LoggerFactory.getLogger(CompteController.class);
	
	@RequestMapping(value = "/Compte", method = RequestMethod.GET)
		public String home( Model model ) {
		
		List<Employe> listEmploye=new ArrayList<Employe>();
		
		listEmploye.addAll(serviceEmploye.getAllEmploye());
		
		model.addAttribute("listEmployeCompte",listEmploye);
		

		return "Compte";
		
	}
	@RequestMapping(value = "/employerCompte", method = RequestMethod.POST)
	public String validEmploye(@ModelAttribute("listEmployeCompte") List<Employe> list, Model model,String validEmploye) {
		
		
		Employe employe = null;
		
		for(Employe i:list)
		{
			if(i.getNomEmploye().equals(validEmploye))
			{   employe = new Employe();
				employe = i;
			}
		}
		
		model.addAttribute("employeCompte",employe);
		
		List<Client> listeClient=new ArrayList<Client>();
		
		listeClient.addAll(serviceClient.getClientByBanque(employe.getBanque().getIdBanque()));
		
		model.addAttribute("listClientCompte",listeClient);
		
		List<Compte> listCompte=new ArrayList<Compte>();
		
		listCompte.addAll(service.getAllByBank(employe.getBanque().getIdBanque()));
		
		Set<Compte> listCompte2= new HashSet<Compte>(listCompte);
		
		List<Compte> listCompte3=new ArrayList<Compte>(listCompte2);
		
		model.addAttribute("listCompte",listCompte3);
		
		List<Compte> listCompteCourant =new ArrayList<Compte>();
		
		List<Compte> listCompteEpargne =new ArrayList<Compte>();
		
		Epargne e=new Epargne();
		
		Courant c=new Courant();
		
		for(Compte i:listCompte)
		{
			if(i.getClass().getName().equals(e.getClass().getName()))
			{
				listCompteEpargne.add(i);
			}
			else
			{
				listCompteCourant.add(i);
			}
		}
		
		model.addAttribute("listCompteCourant",listCompteCourant);
		model.addAttribute("listCompteEpargne",listCompteEpargne);
		
		return "Compte";
	}
	
	
	@RequestMapping(value = "/ajouterCompteCourant", method = RequestMethod.POST)
	public String ajouterCompte(@ModelAttribute("listClientCompte") List<Client> listClients,@ModelAttribute("employeCompte") Employe employe, Model model,String soldeCompte,String decouvert,String nomClient )
	{
		Long id= null;
		// id= Long.parseLong(IDClient);
		
		for(Client i:listClients)
		{
			if(i.getNomClient().equals(nomClient))
			{
				id=i.getIdClient();
			}
		}
		
		Client c= serviceClient.getOneClient(id);
		Compte compteCourant =new Courant(Double.parseDouble(soldeCompte), new Date(), c,Double.parseDouble(decouvert));
		System.out.println("befor");
		
		
		
		
		//Compte CompteEpargne=new Epargne(Double.parseDouble(soldeCompte), new Date(), c, Double.parseDouble(tauxInteret));
		
		//service.addCompte(CompteEpargne, employe.getBanque().getIdBanque());
		
		compteCourant=service.addCompte(compteCourant, employe.getBanque().getIdBanque(), employe.getIdEmploye());
		//System.out.println(employe.getListeCompte()+ " " + compteCourant);
		//employe.getListeCompte().add(compteCourant);
		//System.out.println(employe.getListeCompte()+ "ok " );
		
		
		employe.getListeCompte().add(compteCourant);
		return "Compte";
	}
	
	@RequestMapping(value = "/ajouterCompteEpargne", method = RequestMethod.POST)
	public String ajouterCompteEpargne(@ModelAttribute("listClientCompte") List<Client> listClients,@ModelAttribute("employeCompte") Employe employe, Model model,String soldeCompteEpargne,String tauxInteret,String nomClientEpargne )
	{
		//Long id= Long.parseLong(IDClient);
		Long id=null;
		for(Client i:listClients)
		{
			if(i.getNomClient().equals(nomClientEpargne))
			{
				id=i.getIdClient();
			}
		}
		
		Client c= serviceClient.getOneClient(id);
		//Compte compteCourant =new Courant(Double.parseDouble(soldeCompte), new Date(), c,Double.parseDouble(decouvert));

		Compte CompteEpargne=new Epargne(Double.parseDouble(soldeCompteEpargne), new Date(), c, Double.parseDouble(tauxInteret));
		
		service.addCompte(CompteEpargne, employe.getBanque().getIdBanque(),employe.getIdEmploye());
		employe.getListeCompte().add(CompteEpargne);
		//employe.getListeCompte().add(CompteEpargne);
		service.addCompte(CompteEpargne, employe.getBanque().getIdBanque(), employe.getIdEmploye());
		
		return "Compte";
	}
	
	@RequestMapping(value = "/SupprimerCompte", method = RequestMethod.POST)
	public String SupprimerCompte(@ModelAttribute("listCompte") List<Compte> listCompts,@ModelAttribute("employeCompte") Employe employe, Model model,String SuprumerCompte )
	{
		Long id= Long.parseLong(SuprumerCompte);
		
		
		Compte c=service.getCompteById(id);
		
		
		service.deleteCompte(id);
		
		return "Compte";
	}
	
	@RequestMapping(value = "/updateCompteCourant", method = RequestMethod.POST)
	public String updateCompte(Model mode,String soldUpdate,String decouvertUpdate,String updatecompteid) throws ForbiddenBanqueSwitchException
	{
		Long id=Long.parseLong(updatecompteid);
		
		Courant compte= (Courant) service.getCompteById(id);
		
		compte.setSoldeCompte(Double.parseDouble(soldUpdate));
		
		compte.setDecouvert(Double.parseDouble(decouvertUpdate));
		
		service.updateCompte(compte);
		
		return "Compte";
	}
	

	@RequestMapping(value = "/afficherCompteCourant", method = RequestMethod.POST)
	public String afficherCompte(@ModelAttribute("listCompte") List<Compte> listCompts,@ModelAttribute("employeCompte") Employe employe, Model model,String AfficherdCourant )
	{
		Long id=Long.parseLong(AfficherdCourant);
		//Compte compte=service.getCompteById(id);
		
		Courant compte=(Courant) service.getCompteById(id);
		
		model.addAttribute("sold",compte.getSoldeCompte());
		
		model.addAttribute("decouvert",compte.getDecouvert());
		
		//model.addAttribute("decouvert",100.0);
		
		
		return "Compte";
	}
	
	@RequestMapping(value = "/afficherCompteEpargne", method = RequestMethod.POST)
	public String afficherCompteEpargne(@ModelAttribute("listCompte") List<Compte> listCompts,@ModelAttribute("employeCompte") Employe employe, Model model,String AfficherEpargneid )
	{
		Long id=Long.parseLong(AfficherEpargneid);
		Epargne compte= (Epargne) service.getCompteById(id);
		
		model.addAttribute("soldEpargne",compte.getSoldeCompte());
		model.addAttribute("TauxInteret",compte.getTauxInteret());
		//model.addAttribute("TauxInteret",100.0);
		
		
		return "Compte";
	}
	
	@RequestMapping(value = "/updateCompteEpargne", method = RequestMethod.POST)
	public String updateCompteEpargne( Model model, String soldEpargneUpdate ,String TauxInteretUpdate,String updateEpargnexid) throws ForbiddenBanqueSwitchException
	{

		Long id=Long.parseLong(updateEpargnexid);
		
		Epargne compte= (Epargne) service.getCompteById(id);
		
		compte.setSoldeCompte(Double.parseDouble(soldEpargneUpdate));
		
		compte.setTauxInteret(Double.parseDouble(TauxInteretUpdate));
		
		service.updateCompte(compte);
		
		
		return "Compte";
	}
	
		

	@RequestMapping(value = "/chercherCompte", method = RequestMethod.POST)
	public String chercherCompte(@ModelAttribute("listCompteCourant") List<Compte> listCompts,@ModelAttribute("employeCompte") Employe employe, Model model) 
	{
			List<Compte> listCompteByBanque=new ArrayList<Compte>();
			//listCompteByBanque.addAll(service.getAllByBank(employe.getBanque().getIdBanque()));
			listCompteByBanque.addAll(listCompts);
			model.addAttribute("ListCompteByBanque",listCompteByBanque);
			
		return "Compte";
	}
	
	@RequestMapping(value = "/chercherCompteEpargne", method = RequestMethod.POST)
	public String chercherCompteEpargne(@ModelAttribute("listCompteEpargne") List<Compte> listCompts,@ModelAttribute("employeCompte") Employe employe, Model model) 
	{
			List<Compte> listCompteByBanque=new ArrayList<Compte>();
			//listCompteByBanque.addAll(service.getAllByBank(employe.getBanque().getIdBanque()));
			listCompteByBanque.addAll(listCompts);
			model.addAttribute("ListCompteByBanqueEpargne",listCompteByBanque);
			
		return "Compte";
	}

}
