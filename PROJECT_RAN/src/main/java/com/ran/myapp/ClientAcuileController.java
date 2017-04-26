package com.ran.myapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Employe;
import com.ran.myapp.exception.ClientException;
import com.ran.myapp.service.client.IClientService;
import com.ran.myapp.service.employe.IEmployeService;

@Controller
@SessionAttributes({"listEmploye","listClient","employe"})
public class ClientAcuileController {
	
	@Inject
	private IClientService service;
	
	@Inject
	private IEmployeService serviceEmploye;
	
	private static final Logger logger = LoggerFactory.getLogger(ClientAcuileController.class);
	
	@RequestMapping(value = "/Client", method = RequestMethod.GET)
	public String home( Model model,String validEmploye ) {
		
		List<Employe> listEmploye=new ArrayList<Employe>();
		
		listEmploye.addAll(serviceEmploye.getAllEmploye());
		
		model.addAttribute("listEmploye",listEmploye);
		
		
		//listeClient.addAll(service.getClientByBanque(employe.getBanque().getIdBanque()));
		
		//model.addAttribute("listClient",listeClient);
		
		
	
		return "Client";
	}
	
	@RequestMapping(value = "/employer", method = RequestMethod.POST)
	public String validEmploye(@ModelAttribute("listEmploye") List<Employe> list, Model model,String validEmploye) {
		
		
		Employe employe = null;
		
		for(Employe i:list)
		{
			if(i.getNomEmploye().equals(validEmploye))
			{   employe = new Employe();
				employe = i;
			}
		}
		
		model.addAttribute("employe",employe);
		

		List<Client> listeClient=new ArrayList<Client>();
		
		listeClient.addAll(service.getClientByBanque(employe.getBanque().getIdBanque()));
		System.out.println(listeClient+"-----------------------w");
		
		model.addAttribute("listClient",listeClient);
		
		return "Client";
	
	}
	
	
	
	@RequestMapping(value = "/ajouterClient", method = RequestMethod.POST)
	public String ajouter(@ModelAttribute("employe") Employe emp, Model model,String clientNom,String clientPrenom,String clientDdn,String clientCB) throws ClientException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date clientDd = sdf.parse(clientDdn);
		Integer clientPostal=Integer.parseInt(clientCB);
		Client client=new Client(clientNom, clientPrenom, clientDd, clientPostal);
		
		service.addClient(client,emp.getBanque().getIdBanque());
	
		return "Client";
	}
	
	@RequestMapping(value = "/SupprimerClient", method = RequestMethod.POST)
	public String Supprimer(@ModelAttribute("listClient")List<Client>list, Model model,String Suprumerchoix) {
		
		for(Client i:list)
		{
			if(i.getNomClient().equals(Suprumerchoix))
			{
				service.removeClient(i.getIdClient());
				
			}
		}
		return "Client";
		
		
	}
	
	@RequestMapping(value = "/updateClient", method = RequestMethod.POST)
	public String update(@ModelAttribute("listClient")List<Client>list, Model model,String updatechoixid,String nomUpdate,String PreUpdate,String ddnUpdate,String CpUpdate) throws ParseException {
		
		Long id=Long.parseLong(updatechoixid);
		//Client client=service.getOneClient(id);
		Integer cp=Integer.parseInt(CpUpdate);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date clientDd = sdf.parse(ddnUpdate);
		
		service.updateClient(new Client( id,nomUpdate, PreUpdate, clientDd, cp));
		return "Client";
		
	}
	
	@RequestMapping(value = "/afficher", method = RequestMethod.POST)
	public String afficher(@ModelAttribute("listClient")List<Client>list, Model model,String updatechoixid){
		
		Long id=Long.parseLong(updatechoixid);
		Client client=service.getOneClient(id);
		model.addAttribute("nombefor",client.getNomClient());
		model.addAttribute("prenombefor",client.getPrenomClient());
		
		System.out.println(client.getDateNaissanceClient()+"daaaaaaaaaaaaaaaaaaaaaaaaaaaaate");
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		String date= sdf.format(client.getDateNaissanceClient());
		model.addAttribute("datebefor",date);
		model.addAttribute("cpbefor",client.getCpClient());
		//service.updateClient(new Client(id, nomUpdate, PreUpdate, ddnUpdate, cp));
		
		
		return "Client";
	}

	
	@RequestMapping(value = "/chercher", method = RequestMethod.POST)
	public String chercher( Model model,String keyword)
	{
		List<Client> listeClients=new ArrayList<Client>();
		listeClients.addAll(service.getClientByMC(keyword));
		model.addAttribute("ListeClientByMc",listeClients);
		return "Client";
		
	}
		
		
	
	
	

}
