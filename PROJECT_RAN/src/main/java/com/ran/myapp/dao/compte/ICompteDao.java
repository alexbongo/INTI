package com.ran.myapp.dao.compte;

import java.util.*;

import com.ran.myapp.entities.Compte;

public interface ICompteDao {

	Compte addCompte(Compte compte, Long idBanque, Long idEmploye);

	void deleteCompte(Long idCompte);

	Compte getCompteById(Long idCompte);

	Compte updateCompte(Compte compte);

	List<Compte> getCompteByClient(Long idClient);

	List<Compte> getAllByBank(Long idBanque);

	List<Compte> getComptesByEmpl(Long idEmploye);

}