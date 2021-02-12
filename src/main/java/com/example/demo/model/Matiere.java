package com.example.demo.model;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Matiere {
	


	@Id
	@Column(name="mat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String label;
	private long nbr_heure;
	 
	@ManyToMany(mappedBy = "matiere" ,cascade=CascadeType.ALL)
	List<Etudiant> etudiant;
	
	 @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
	  private Set<Absence> absence;

   
	public void addet(@Valid Matiere mat) {
		// TODO Auto-generated method stub
		
	}

	
	    
	
}
