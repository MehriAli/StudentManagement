package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classe {
	
	@Id
	@Column(name="classe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String label;
	private String Nom_complet;
	
	@OneToMany(mappedBy="classe" , cascade=CascadeType.ALL)
	 private Set<Etudiant> etudiant;

	@Override
	public String toString() {
		return "Classe [id=" + id + ", label=" + label + ", Nom_complet=" + Nom_complet + ", etudiant=" + etudiant
				+ "]";
	}
	


	

}
