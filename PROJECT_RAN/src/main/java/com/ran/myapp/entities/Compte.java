package com.ran.myapp.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING)
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompte;
	private double soldeCompte;
	private Date dateCreationCompte;
	@ManyToOne
	@JoinColumn(name = "fk_banque2")
	private Banque banque;
	@ManyToOne
	@JoinColumn(name = "fk_client")
	private Client client;
	//fetch=FetchType.EAGER,
	@OneToMany( mappedBy = "compte")
	private List<Operation> listeOperations = new ArrayList<Operation>();

	
	/**Constructeur par défaut */
	public Compte() {
		super();
	}

	/** Constructeur avec paramètres */
	public Compte(double soldeCompte, Date dateCreationCompte, Client client) {
		super();
		this.soldeCompte = soldeCompte;
		this.dateCreationCompte = dateCreationCompte;
		this.client = client;
	}

	/**
	 * @return the idCompte
	 */
	public Long getIdCompte() {
		return idCompte;
	}


	/**
	 * @return the soldeCompte
	 */
	public double getSoldeCompte() {
		return soldeCompte;
	}

	/**
	 * @param soldeCompte
	 *            the soldeCompte to set
	 */
	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	/**
	 * @return the dateCreationCompte
	 */
	public Date getDateCreationCompte() {
		return dateCreationCompte;
	}

	/**
	 * @param dateCreationCompte
	 *            the dateCreationCompte to set
	 */
	public void setDateCreationCompte(Date dateCreationCompte) {
		this.dateCreationCompte = dateCreationCompte;
	}

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
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the listeOperations
	 */
	public List<Operation> getListeOperations() {
		return listeOperations;
	}

	/**
	 * @param listeOperations
	 *            the listeOperations to set
	 */
	public void setListeOperations(List<Operation> listeOperations) {
		this.listeOperations = listeOperations;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", soldeCompte=" + soldeCompte
				+ ", dateCreationCompte=" + dateCreationCompte + "]";
	}

	

}
