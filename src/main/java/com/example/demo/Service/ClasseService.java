package com.example.demo.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.Repositry.ClasseRepo;
import com.example.demo.Repositry.EtudiantRepo;
import com.example.demo.model.Classe;
import com.example.demo.model.Etudiant;
import com.example.demo.model.Matiere;

@Service
public class ClasseService {
	
	@Autowired
	ClasseRepo repo; 
	
	public List<Classe> getALL(){
		return repo.findAll();
		
	}
	
	public  long countclasse(){
		return repo.count();
		
	}

	public void delete(Long id) {
		 repo.deleteById(id);		
	}

	public Object getById(Long id) {
		return repo.findById(id).get();
	}



	public void addclass(@Valid  Classe classe) {
		 repo.save(classe);	
					
	}



	
		
	

}
