package com.example.demo.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Absence {
	@Id
	@Column(name="absence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
     private Date date;
     private Long absent;
     
     @ManyToOne
     @JoinColumn(name = "etuidnat_id")
     private Etudiant etudiant;
     
     @ManyToOne
     @JoinColumn(name = "mat_id")
     private Matiere matiere;

	@Override
	public String toString() {
		return "Absence [id=" + id + ", date=" + date + ", absent=" + absent + ", etudiant=" + etudiant + ", matiere="
				+ matiere + "]";
	}

}
