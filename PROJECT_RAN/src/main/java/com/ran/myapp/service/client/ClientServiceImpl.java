package com.ran.myapp.service.client;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.ran.myapp.dao.client.IClientDao;
import com.ran.myapp.entities.Banque;
import com.ran.myapp.entities.Client;
import com.ran.myapp.entities.Compte;
import com.ran.myapp.exception.ClientException;

@Transactional(readOnly=true)
public class ClientServiceImpl implements IClientService {

	private IClientDao daoClient;
	private static final Logger LOGGER=Logger.getLogger("ClientServiceImpl");
	
	/**
	 * @param daoClient the daoClient to set
	 */
	public void setDaoClient(IClientDao daoClient) {
		this.daoClient = daoClient;
	}

	@Override
	@Transactional(readOnly=false)
	public Client addClient(Client client,Long idBanque) throws ClientException {
		
		List<Client> listeClient= getClientByBanque(idBanque);
		System.out.println(listeClient);
		System.out.println(listeClient.size());
		if(listeClient.size()==0)
		{
			daoClient.addClient(client,idBanque);
		}
		else
		{
			for(Client i:listeClient)
			{
				if(i.getNomClient().equals(client.getNomClient())&&i.getPrenomClient().equals(client.getPrenomClient()))
				{
					LOGGER.info("this client is already existe in this banque");
					throw new ClientException("le client est déjà existé");
				}
				else
				{
					
					daoClient.addClient(client,idBanque);
				}
			}
			
		}
		
		return client;
		
	}

	@Override
	@Transactional(readOnly=false)
	public void removeClient(Long idClient) {
		
		daoClient.removeClient(idClient);
		
	}

	@Override
	@Transactional(readOnly=false)
	public Client updateClient(Client client) {
		
		return daoClient.updateClient(client);
	}

	@Override
	@Transactional(readOnly=false)
	public List<Compte> getComptes(Long idClient) {
		
		return daoClient.getComptes(idClient);
	}

	@Override
	@Transactional(readOnly=false)
	public List<Client> getClientByMC(String motCle) {
		// TODO Auto-generated method stub
		return daoClient.getClientByMC(motCle);
	}

	@Override
	@Transactional(readOnly=false)
	public List<Client> getClientByBanque(Long idBanque) {
		// TODO Auto-generated method stub
		return daoClient.getClientByBanque(idBanque);
	}

	@Override
	@Transactional(readOnly=false)
	public Client getOneClient(Long idClient) {
		return daoClient.getOneClient(idClient);
	}

}
