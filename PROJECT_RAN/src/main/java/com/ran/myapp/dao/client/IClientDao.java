package com.ran.myapp.dao.client;

import java.util.List;

import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Compte;

public interface IClientDao {
	
	Client addClient(Client client,Long idBanque);
	  
	void removeClient(Long idClient);
  
	Client updateClient(Client client);
  
	List<Compte> getComptes(Long idClient);
  
   List<Client> getClientByMC(String motCle);
  
   List<Client> getClientByBanque(Long idBanque);
   
   Client getOneClient(Long idClient);

}
