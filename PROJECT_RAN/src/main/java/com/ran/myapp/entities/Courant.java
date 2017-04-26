package com.ran.myapp.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Courant")
public class Courant extends Compte {
	
	private Double decouvert;


/**Constructeur par défaut */
	public Courant() {
		super();
		
	}

/**Constructeur avec paramètres*/	
	public Courant(double soldeCompte, Date dateCreationCompte, 
			Client client, Double decouvert) {
		super(soldeCompte, dateCreationCompte, client);
		this.decouvert = decouvert;
	}

	/**
	 * @return the decouvert
	 */
	public Double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert the decouvert to set
	 */
	public void setDecouvert(Double decouvert) {
		this.decouvert = decouvert;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Courant [decouvert=" + decouvert + "]";
	}
	
	

}
