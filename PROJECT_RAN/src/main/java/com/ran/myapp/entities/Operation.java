package com.ran.myapp.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING)
public abstract class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperation;
	
	private Date dateOperation;
	private Double montantOperation;
	@ManyToOne
	@JoinColumn(name="fk_compte")
	private Compte compte;
	
	
	
/** COnstructeur par défaut */
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/** Constructeur avec paramètres */	
	public Operation(Date dateOperation, Double montantOperation) {
		super();
		this.dateOperation = dateOperation;
		this.montantOperation = montantOperation;
	}

	/**
	 * @return the dateOperation
	 */
	public Date getDateOperation() {
		return dateOperation;
	}

	/**
	 * @param dateOperation the dateOperation to set
	 */
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	/**
	 * @return the montantOperation
	 */
	public Double getMontantOperation() {
		return montantOperation;
	}

	/**
	 * @param montantOperation the montantOperation to set
	 */
	public void setMontantOperation(Double montantOperation) {
		this.montantOperation = montantOperation;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * @return the idOperation
	 */
	public Long getIdOperation() {
		return idOperation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operation [idOperation=" + idOperation + ", dateOperation="
				+ dateOperation + ", montantOperation=" + montantOperation
				+ ", compte=" + compte + "]";
	}
	
	
	
	

}
