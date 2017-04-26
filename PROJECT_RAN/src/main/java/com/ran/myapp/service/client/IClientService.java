package com.ran.myapp.service.client;

import java.util.List;

import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.exception.ClientException;

public interface IClientService {
	
	
	Client addClient(Client client,Long idBanque) throws ClientException;
	  
	void removeClient(Long idClient);
  
	Client updateClient(Client client);
  
	List<Compte> getComptes(Long idClient);
  
   List<Client> getClientByMC(String motCle);
  
   List<Client> getClientByBanque(Long idBanque);
   
   Client getOneClient(Long idClient);

}
