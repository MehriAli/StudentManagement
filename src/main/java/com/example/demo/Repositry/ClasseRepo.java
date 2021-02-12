package com.example.demo.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Classe;

@Repository
public interface  ClasseRepo extends JpaRepository<Classe, Long >{

	
}
