package com.ran.myapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBanque;
	
	  
	private String nomBanque;
	   private Integer cpBanque;
	   private String adresseBanque;
	   @OneToMany(mappedBy="banque", fetch=FetchType.EAGER)
	   private List<Compte> listeCompte=new ArrayList<Compte>();
	   @OneToMany(mappedBy="banque")
	   private List<Client> listeClient=new ArrayList<Client>();
	   @OneToMany(mappedBy="banque", fetch=FetchType.EAGER)
	   private List<Employe> listeEmploye=new ArrayList<Employe>();

	   
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
	 * @return the listeClient
	 */
	public List<Client> getListeClient() {
		return listeClient;
	}
	/**
	 * @param listeClient the listeClient to set
	 */
	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}
	/**
	 * @return the listeEmploye
	 */
	public List<Employe> getListeEmploye() {
		return listeEmploye;
	}
	/**
	 * @param listeEmploye the listeEmploye to set
	 */
	public void setListeEmploye(List<Employe> listeEmploye) {
		this.listeEmploye = listeEmploye;
	}
	/**
	 * @return the nomBanque
	 */
	public String getNomBanque() {
		return nomBanque;
	}
	/**
	 * @param nomBanque the nomBanque to set
	 */
	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}
	/**
	 * @return the cpBanque
	 */
	public Integer getCpBanque() {
		return cpBanque;
	}
	/**
	 * @param cpBanque the cpBanque to set
	 */
	public void setCpBanque(Integer cpBanque) {
		this.cpBanque = cpBanque;
	}
	/**
	 * @return the adresseBanque
	 */
	public String getAdresseBanque() {
		return adresseBanque;
	}
	/**
	 * @param adresseBanque the adresseBanque to set
	 */
	public void setAdresseBanque(String adresseBanque) {
		this.adresseBanque = adresseBanque;
	}
	/**
	 * @return the idBanque
	 */
	public Long getIdBanque() {
		return idBanque;
	}
	
	/**
	 * @param nomBanque
	 * @param cpBanque
	 * @param adresseBanque
	 */
	public Banque(String nomBanque, Integer cpBanque, String adresseBanque) {
		super();
		this.nomBanque = nomBanque;
		this.cpBanque = cpBanque;
		this.adresseBanque = adresseBanque;
	}
	/**
	 * @param idBanque
	 * @param nomBanque
	 * @param cpBanque
	 * @param adresseBanque
	 */
	public Banque(Long idBanque, String nomBanque, Integer cpBanque,
			String adresseBanque) {
		super();
		this.idBanque = idBanque;
		this.nomBanque = nomBanque;
		this.cpBanque = cpBanque;
		this.adresseBanque = adresseBanque;
	}
	
	
	/**
	 * @param idBanque the idBanque to set
	 */
	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}
	/**
	 * 
	 */
	public Banque() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Banque [idBanque=" + idBanque + ", nomBanque=" + nomBanque
				+ ", cpBanque=" + cpBanque + ", adresseBanque=" + adresseBanque
				+ "]";
	}
	   
	   
	   

}
