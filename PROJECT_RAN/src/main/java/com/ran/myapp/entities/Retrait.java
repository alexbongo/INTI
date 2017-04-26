package com.ran.myapp.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Retrait")
public class Retrait extends Operation {

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, Double montantOperation) {
		super(dateOperation, montantOperation);
		// TODO Auto-generated constructor stub
	}
	
	

}
