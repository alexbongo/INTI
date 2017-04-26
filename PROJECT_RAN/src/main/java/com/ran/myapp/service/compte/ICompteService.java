package com.ran.myapp.service.compte;

import java.util.List;

import com.ran.myapp.entities.Compte;
import com.ran.myapp.exception.ForbiddenBanqueSwitchException;

public interface ICompteService {

	Compte addCompte(Compte compte, Long idBanque, Long idEmploye);

	void deleteCompte(Long idCompte);

	Compte getCompteById(Long idCompte);

	Compte updateCompte(Compte compte) throws ForbiddenBanqueSwitchException;

	List<Compte> getCompteByClient(Long idClient);

	List<Compte> getAllByBank(Long idBanque);

	List<Compte> getComptesByEmpl(Long idEmploye);

}
