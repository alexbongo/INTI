package com.ran.myapp.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Versement")
public class Versement extends Operation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateOperation, Double montantOperation) {
		super(dateOperation, montantOperation);
		// TODO Auto-generated constructor stub
	}
	
	

}
