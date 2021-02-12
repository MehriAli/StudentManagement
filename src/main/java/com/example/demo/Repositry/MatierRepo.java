package com.example.demo.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Matiere;

@Repository
public interface MatierRepo  extends JpaRepository<Matiere, Long>{

}
