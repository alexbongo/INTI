package com.ran.myapp.service.banque;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.ran.myapp.dao.banque.IBanqueDao;
import com.ran.myapp.entities.Banque;
import com.ran.myapp.exception.BanqueException;
@Transactional(readOnly=true)
public class BanqueServiceImpl implements IBanqueService {

	private IBanqueDao daoBanque;
	
	private static Logger LOGGER=Logger.getLogger("BanqueServiceImpl");
	
	/**
	 * @param daoBanque the daoBanque to set
	 */
	public void setDaoBanque(IBanqueDao daoBanque) {
		this.daoBanque = daoBanque;
	}
	@Override
	@Transactional(readOnly=false)
	public Banque addBanque(Banque banque) throws BanqueException {
		// TODO Auto-generated method stub
		List<Banque> listeBanque=getAllBanque();
		if(listeBanque.size()==0)
		{
			 daoBanque.addBanque(banque);
		}
		else
		{
			for(Banque i:listeBanque)
			{
				if(i.getIdBanque()==banque.getIdBanque())
				{
					LOGGER.info("la banque est déjà existé");
					throw new BanqueException("la banque est déjà existé");
				}
				else
				{
					 daoBanque.addBanque(banque);
				}
				
				
			}
		}
		
		return banque;
		
	}
	@Override
	@Transactional(readOnly=false)
	public Banque getOneById(Long idBanque) {
		// TODO Auto-generated method stub
		return daoBanque.getOneById(idBanque);
	}
	@Override
	@Transactional(readOnly=false)
	public Banque updateBanque(Banque banque) {
		// TODO Auto-generated method stub
		return daoBanque.updateBanque(banque);
	}
	@Override
	@Transactional(readOnly=false)
	public List<Banque> getAllBanque() {
		// TODO Auto-generated method stub
		return daoBanque.getAllBanque();
	}

}
