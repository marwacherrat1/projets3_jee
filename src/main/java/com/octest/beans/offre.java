package com.octest.beans;

import java.sql.Date;

public class offre {
	int idoffre; 
	int id_entreprise;
	String dateoffre;
	String delai;
	String titre;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getIdoffre() {
		return idoffre;
	}
	public void setIdoffre(int idoffre) {
		this.idoffre = idoffre;
	}
	public int getId_entreprise() {
		return id_entreprise;
	}
	public void setId_entreprise(int id_entreprise) {
		this.id_entreprise = id_entreprise;
	}
	public String getDateoffre() {
		return dateoffre;
	}
	public void setDateoffre(String date) {
		this.dateoffre = date;
	}
	public String getDelai() {
		return delai;
	}
	public void setDelai(String delai) {
		this.delai = delai;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	String description ; 
	String  competence;
}
