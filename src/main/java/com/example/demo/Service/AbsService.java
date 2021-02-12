package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositry.AbsenceRepo;
import com.example.demo.model.Absence;
import com.example.demo.model.Etudiant;
import com.example.demo.model.Matiere;

@Service
public class AbsService {
@Autowired
AbsenceRepo repo;


public void enreg(Absence absent) {
	repo.save(absent);
}


public List<Absence> getAl() {
	// TODO Auto-generated method stub
	return repo.findAll();
}



public Optional<Absence> getabscence(Matiere matiere, Etudiant etudiant) {
      
	  List<Absence> abs = repo.findAll();  
	  Stream<Absence> absences = abs.stream();
	  Optional<Absence> absence = absences.filter(x->x.getEtudiant().equals(etudiant))
	  .filter(x->x.getMatiere().equals(matiere)).findFirst();
	return absence;
	  
	  
	  
}
}
