package com.ran.myapp.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Epargne")
public class Epargne extends Compte {
	
	private Double tauxInteret;

	
/** Constructeur avec taux Interet*/
	public Epargne(double soldeCompte, Date dateCreationCompte,
			Client client, Double tauxInteret) {
		super(soldeCompte, dateCreationCompte, client);
		this.tauxInteret = tauxInteret;
	}

/** Constructeur par défaut */
public Epargne() {
	super();
	// TODO Auto-generated constructor stub
}

/**
 * @return the tauxInteret
 */
public Double getTauxInteret() {
	return tauxInteret;
}

/**
 * @param tauxInteret the tauxInteret to set
 */
public void setTauxInteret(Double tauxInteret) {
	this.tauxInteret = tauxInteret;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Epargne [tauxInteret=" + tauxInteret + "]";
}




	

	

}
