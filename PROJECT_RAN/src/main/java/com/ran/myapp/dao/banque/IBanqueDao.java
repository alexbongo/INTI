package com.ran.myapp.dao.banque;

import java.util.List;

import com.ran.myapp.entities.Banque;

public interface IBanqueDao {
	
	 Banque addBanque(Banque banque);
	 
	 Banque getOneById(Long idBanque);
	 
	 Banque updateBanque(Banque banque);

	 
	 List<Banque> getAllBanque();
}
