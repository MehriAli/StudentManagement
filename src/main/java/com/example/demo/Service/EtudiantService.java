package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositry.EtudiantRepo;
import com.example.demo.model.Etudiant;

import javassist.NotFoundException;



@Service
public class EtudiantService {
	
	@Autowired
	EtudiantRepo repo; 
	
	public List<Etudiant> getALL(){
		return repo.findAll();
		
	}
	

	
	
	public  long countstudent(){
		return repo.count();
		
	}
	 public  Optional<Etudiant> findById(Long inte) {
      return  repo.findById(inte);
	    }
	 
	 
	 
	 
	
	public void  saveetu(Etudiant entity){
		 repo.save(entity);
		
	}
  
	public void delete(Long id) {
	  repo.deleteById(id);
  }

	public void update(Etudiant newuser, Long id) {
		 Optional<Etudiant> user = repo.findById(id);
		 user.get().setNom(newuser.getNom());
		 user.get().setPrennom(newuser.getPrennom());
		 user.get().setEmail(newuser.getEmail());
         user.get().setDatenaissance(newuser.getDatenaissance());
         user.get().setClasse(newuser.getClasse());
         repo.save(user.get());
	}


	public Etudiant getById(Long id) {
		return repo.findById(id).get();		
	}


	public void addet(@Valid Etudiant etudiant) {
            repo.save(etudiant);		
	}
	

	
	
}
