package com.ran.myapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Groupes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupes;
	  
	private String nomGroupes;
	
	@ManyToMany(mappedBy="listeGroupes")
	private List<Employe> listeEmploye= new ArrayList<Employe>();

	
	
	/**
	 * 
	 */
	public Groupes() {
		super();
	}






	/**
	 * @param nomGroupes
	 * @param listeEmploye
	 */
	public Groupes(String nomGroupes, List<Employe> listeEmploye) {
		super();
		this.nomGroupes = nomGroupes;
		this.listeEmploye = listeEmploye;
	}






	/**
	 * @return the nomGroupe
	 */
	public String getNomGroupes() {
		return nomGroupes;
	}





	/**
	 * @param nomGroupe the nomGroupe to set
	 */
	public void setNomGroupes(String nomGroupes) {
		this.nomGroupes = nomGroupes;
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
	 * @return the idGroupe
	 */
	public Long getIdGroupes() {
		return idGroupes;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Groupes [idGroupes=" + idGroupes + ", nomGroupe=" + nomGroupes
				+ "]";
	}
	
	
	
	
}
