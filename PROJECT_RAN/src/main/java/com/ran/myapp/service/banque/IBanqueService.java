package com.ran.myapp.service.banque;

import java.util.List;

import com.ran.myapp.entities.Banque;
import com.ran.myapp.exception.BanqueException;

public interface IBanqueService {
	
	Banque addBanque(Banque banque) throws BanqueException;

	Banque getOneById(Long idBanque);
	Banque updateBanque(Banque banque);
	List<Banque> getAllBanque();
}
