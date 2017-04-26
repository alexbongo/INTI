package com.ran.myapp.entities;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Employe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmploye;
	
	private String nomEmploye;
	
	@ManyToOne
	@JoinColumn(name="fk_banque")
	private Banque banque;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name="TB_EMPLOYE_COMPTE", joinColumns=@JoinColumn(name="idEmploye"),
			inverseJoinColumns=@JoinColumn(name="idCompte"))
	private List<Compte> listeCompte = new ArrayList<Compte>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name="TB_EMPLOYE_OPERATION", joinColumns=@JoinColumn(name="idEmploye"),
			inverseJoinColumns=@JoinColumn(name="idOperation"))
	private List<Operation> listeOperation = new ArrayList<Operation>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="TB_EMPLOYE_GROUPES", joinColumns=@JoinColumn(name="idEmploye"),
			inverseJoinColumns=@JoinColumn(name="idGroupes"))
	private List<Groupes> listeGroupes = new ArrayList<Groupes>();

	/**
	 * 
	 */
	public Employe() {
		super();
	}

	/**
	 * @param nomEmploye
	 * @param banque
	 * @param listeCompte
	 * @param listeOperation
	 * @param listeGroupes
	 */
	public Employe(String nomEmploye, Banque banque, List<Compte> listeCompte,
			List<Operation> listeOperation, List<Groupes> listeGroupes) {
		super();
		this.nomEmploye = nomEmploye;
		this.banque = banque;
		this.listeCompte = listeCompte;
		this.listeOperation = listeOperation;
		this.listeGroupes = listeGroupes;
	}

	/**
	 * @return the nomEmploye
	 */
	public String getNomEmploye() {
		return nomEmploye;
	}

	/**
	 * @param nomEmploye the nomEmploye to set
	 */
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * @return the listeCompte
	 */
	public List<Compte> getListeCompte() {
		return listeCompte;
	}

	/**
	 * @param listeCompte the listeCompte to set
	 */
	public void setListeCompte(List<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}

	/**
	 * @return the listeOperation
	 */
	public List<Operation> getListeOperation() {
		return listeOperation;
	}

	/**
	 * @param listeOperation the listeOperation to set
	 */
	public void setListeOperation(List<Operation> listeOperation) {
		this.listeOperation = listeOperation;
	}

	/**
	 * @return the listeGroupe
	 */
	public List<Groupes> getListeGroupes() {
		return listeGroupes;
	}

	/**
	 * @param listeGroupe the listeGroupe to set
	 */
	public void setListeGroupe(List<Groupes> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}

	/**
	 * @return the idEmploye
	 */
	public Long getIdEmploye() {
		return idEmploye;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye
				+ "]";
	}
	
	
	
	
}
