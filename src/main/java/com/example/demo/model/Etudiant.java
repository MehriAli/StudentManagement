package com.example.demo.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant {

	@Id
	@Column(name="etuidnat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String nom;
    private String prennom;
    private String email;
    private Date  datenaissance;
    
    @OneToOne()
    @JoinColumn(name = "classe_id", referencedColumnName = "classe_id")
    private Classe classe;

    @ManyToMany
    @JoinTable(
      name = "Matiere_etudiant", 
      joinColumns = @JoinColumn(name = "etuidnat_id"), 
      inverseJoinColumns = @JoinColumn(name = "mat_id"))
      List<Matiere> matiere;
   

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private Set<Absence> absence;

    
    
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrennom() {
		return prennom;
	}


	public void setPrennom(String prennom) {
		this.prennom = prennom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDatenaissance() {
		return datenaissance;
	}


	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public List<Matiere> getMatiere() {
		return matiere;
	}


	public void setMatiere(List<Matiere> matiere) {
		this.matiere = matiere;
	}



    
    
    
	
    
    
    
}
