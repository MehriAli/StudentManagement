package com.example.demo.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Classe;
import com.example.demo.model.Etudiant;
@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long > {

	@Query("SELECT e from Classe c , Etudiant e where c.id = e.classe and c.Nom_complet=?1")
	 List<Etudiant> findbyclas(String string);
}
