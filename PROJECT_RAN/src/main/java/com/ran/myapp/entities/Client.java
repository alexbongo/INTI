package com.ran.myapp.entities;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	private String nomClient;
	private String prenomClient;
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceClient;
	private Integer cpClient;
	
	
	@ManyToOne
	@JoinColumn(name="fk_banque")
	private Banque banque;
	
	@OneToMany(mappedBy="client",orphanRemoval = true)
	private List<Compte> listeCompte = new ArrayList<Compte>();

	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque
	 *            the banque to set
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
	 * @param listeCompte
	 *            the listeCompte to set
	 */
	public void setListeCompte(List<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}

	/**
	 * @param idClient
	 *            the idClient to set
	 */
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/**
	 * @param nomClient
	 *            the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @return the prenomClient
	 */
	public String getPrenomClient() {
		return prenomClient;
	}

	/**
	 * @param prenomClient
	 *            the prenomClient to set
	 */
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	/**
	 * @return the dateNaissanceClient
	 */
	public Date getDateNaissanceClient() {
		return dateNaissanceClient;
	}

	/**
	 * @param dateNaissanceClient
	 *            the dateNaissanceClient to set
	 */
	public void setDateNaissanceClient(Date dateNaissanceClient) {
		this.dateNaissanceClient = dateNaissanceClient;
	}

	/**
	 * @return the cpClient
	 */
	public Integer getCpClient() {
		return cpClient;
	}

	/**
	 * @param cpClient
	 *            the cpClient to set
	 */
	public void setCpClient(Integer cpClient) {
		this.cpClient = cpClient;
	}

	/**
	 * @return the idClient
	 */
	public Long getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient
	 * @param nomClient
	 * @param prenomClient
	 * @param dateNaissanceClient
	 * @param cpClient
	 */
	public Client(Long idClient, String nomClient, String prenomClient,
			Date dateNaissanceClient, Integer cpClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateNaissanceClient = dateNaissanceClient;
		this.cpClient = cpClient;
	}

	/**
	 * @param nomClient
	 * @param prenomClient
	 * @param dateNaissanceClient
	 * @param cpClient
	 */
	public Client(String nomClient, String prenomClient,
			Date dateNaissanceClient, Integer cpClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateNaissanceClient = dateNaissanceClient;
		this.cpClient = cpClient;
	}

	/**
	 * 
	 */
	public Client() {
		super();
	}
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient
				+ ", prenomClient=" + prenomClient + ", dateNaissanceClient="
				+ dateNaissanceClient + ", cpClient=" + cpClient + "]";
	}

}
