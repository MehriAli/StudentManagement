package com.example.demo.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositry.MatierRepo;
import com.example.demo.model.Matiere;

@Service
public class MatierService {
	@Autowired
	MatierRepo repo;
	
	
	public Matiere getById(Long id) {
		return repo.findById(id).get();
	}


	public Object getALL() {
		return repo.findAll();

	}


	public void delete(Long id) {
		  repo.deleteById(id);
		
	}


	public void addmatere(@Valid Matiere matiere) {
        repo.save(matiere);		
		
	}


	

}
