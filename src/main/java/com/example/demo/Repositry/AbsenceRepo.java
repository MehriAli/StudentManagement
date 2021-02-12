package com.example.demo.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Absence;
@Repository
public interface AbsenceRepo  extends JpaRepository<Absence, Long >{
    
	
	@Query("SELECT e.nom  from Absence a , Etudiant e where a.etudiant =?1 ")
	List<Object> fin(Long valueOf, Long valueOf2);
       
}
