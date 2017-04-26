package com.ran.myapp.entities;

import javax.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRole;
	
	private String nomRole;
	
	//Relation ManyToOne bidirectionnelle avec User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user")
	private User user;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	* @param nomRole
	*/
	public Role(String nomRole) {
		this.nomRole = nomRole;
	}



	/**
	* @return the idRole
	*/
	public Integer getIdRole() {
		return idRole;
	}

	/**
	* @param idRole the idRole to set
	*/
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	/**
	* @return the nomRole
	*/
	public String getNomRole() {
		return nomRole;
	}

	/**
	* @param nomRole the nomRole to set
	*/
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	/**
	* @return the user
	*/
	public User getUser() {
		return user;
	}

	/**
	* @param user the user to set
	*/
	public void setUser(User user) {
		this.user = user;
	}
	
	

}