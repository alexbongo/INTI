package com.ran.myapp.entities;

import java.util.Collection;

import javax.persistence.*;

/**
 * @author BNAS
 *
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUser;
	private String name;
	private String password;
	private Boolean activated;
	
	//Relation OneToMany bidirectionnelle avec Role (déjà faite)
	@OneToMany(mappedBy="user")
	private Collection<Role> roles;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	* @param name
	* @param password
	* @param activated
	*/
	public User(String name, String password, Boolean activated) {
		this.name = name;
		this.password = password;
		this.activated = activated;
	}



	/**
	* @return the idUser
	*/
	public Integer getIdUser() {
		return idUser;
	}

	/**
	* @param idUser the idUser to set
	*/
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	/**
	* @return the name
	*/
	public String getName() {
		return name;
	}

	/**
	* @param name the name to set
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* @return the password
	*/
	public String getPassword() {
		return password;
	}

	/**
	* @param password the password to set
	*/
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	* @return the activated
	*/
	public Boolean getActivated() {
		return activated;
	}

	/**
	* @param activated the activated to set
	*/
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	/**
	* @return the roles
	*/
	public Collection<Role> getRoles() {
		return roles;
	}

	/**
	* @param roles the roles to set
	*/
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", password="
				+ password + ", activated=" + activated + ", roles=" + roles
				+ "]";
	}
	
	
	
}


