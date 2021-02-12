package com.example.demo.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Repositry.ClasseRepo;
import com.example.demo.Repositry.EtudiantRepo;
import com.example.demo.Service.AbsService;
import com.example.demo.Service.ClasseService;
import com.example.demo.Service.EtudiantService;
import com.example.demo.Service.MatierService;
import com.example.demo.model.Absence;
import com.example.demo.model.Classe;
import com.example.demo.model.Etudiant;
import com.example.demo.model.Matiere;

import lombok.var;

@Controller
public class MainController {
	
	@Autowired
	EtudiantRepo clre;
	
	@Autowired
	EtudiantService etuservice;
	
	
	@Autowired
	MatierService mat;
	
	@Autowired
	ClasseService cl;

	@Autowired
	AbsService abs;

	
	
	
	  @RequestMapping("/")
	    public String home(Model model) {
		   model.addAttribute("nbr",etuservice.countstudent());
		   model.addAttribute("nb",cl.countclasse());

	        return "index";
	  }
	  
	  

	  /**
	   *Etudiant 
	   */
	  @GetMapping("/getall")
	    public String getetudaint(Model model) {
		    model.addAttribute("etudiant", etuservice.getALL());
	        return "alletud";
	  }
	  
	  
	  
	  @GetMapping("delete/{id}")
	    public String deleteById(@PathVariable String id){
		    etuservice.delete(Long.valueOf(id));
	        return "redirect:/getall";
	    }
	  
	
	  @GetMapping("view/{id}")
	    public String view(@PathVariable String id,Model model)
	  {
		    model.addAttribute("etudiant", etuservice.getById(Long.valueOf(id)));
	        return "viewoneetud";

	        
	    }
	  
	
	  @GetMapping("/adduser")
	    public String view(Model model)
	  {     model.addAttribute("etudiant", new Etudiant());
		    model.addAttribute("cl",cl.getALL());
	        return "addetud";       
	    }
	  
	   @PostMapping("/add")
	    public String addetudiant1(@Valid Etudiant etudiant, Model model) {
		   etuservice.addet(etudiant);
	        return "redirect:/getall";
	   }
	  
	 
	  
	  /**
	   *Matiérre 
	   */
	   
	   @GetMapping("/getallmat")
	    public String getmat(Model model) {
		    model.addAttribute("matiere",mat.getALL());
	        return "allmat";
	  }
	  
	  
	  
	  @GetMapping("deletemat/{id}")
	    public String deleteByIdmat(@PathVariable String id){
		    mat.delete(Long.valueOf(id));
	        return "redirect:/getallmat";
	    }
	  
	
	  @GetMapping("viewmat/{id}")
	    public String viewmat(@PathVariable String id,Model model)
	  {
		    model.addAttribute("matiere", mat.getById(Long.valueOf(id)));
	        return "viewonemat";

	        
	    }
	  
	
	  @GetMapping("/getmatform")
	    public String addmatForm(Model model)
	  {     model.addAttribute("matiere", new Matiere());
	        return "matadd";       
	    }
	  
	  @RequestMapping("/addmatiere")
	    public String addmat(@Valid Matiere matiere, Model model) {
		   mat.addmatere(matiere);
	        return "redirect:/getallmat";
	   }
	  
	  /**
	   * Classe 
	   */
	  @GetMapping("/getallclasse")
	    public String getclasse(Model model) {
		    model.addAttribute("classe",cl.getALL());
	        return "alleclass";
	  }
	  
	  
	  
	  @GetMapping("deletclass/{id}")
	    public String deleteByIdclasse(@PathVariable String id){
		    cl.delete(Long.valueOf(id));
	        return "redirect:/getallclasse";
	    }
	  
	
	  @GetMapping("vieclass/{id}")
	    public String viewclasse(@PathVariable String id,Model model)
	  {
		    model.addAttribute("classe", cl.getById(Long.valueOf(id)));
	        return "viewclass";

	        
	    }
	  
	
	  @GetMapping("/getclassform")
	    public String addclassForm(Model model)
	  {     model.addAttribute("classe", new Classe());
	        return "classadd";       
	    }
	  
	  @RequestMapping("/addclasse")
	    public String addclass(@Valid Classe classe, Model model) {
		   cl.addclass(classe);
	        return "redirect:/allclass";
	   }
	  /**
	   * Abscence
	   */
	  
	  @GetMapping("/getabsentformglsi1")
	    public String addabsrnt(Model model)
	      
	  {  
		  
		  
		  String string="GLSI1"; 
	        model.addAttribute("localDate", LocalDate.now());
	        model.addAttribute("etudiant",clre.findbyclas(string));
	        model.addAttribute("matiere",mat.getALL());
	        model.addAttribute("abse",abs.getAl());
	        
	        
	        return "absentform";       
	    }
	  
	  @GetMapping("/getabsentformglsi2")
	    public String addabsrnt2(Model model)
	      
	  {  String string="GLSI2"; 
	        model.addAttribute("localDate", LocalDate.now());
	        model.addAttribute("etudiant",clre.findbyclas(string));
	        model.addAttribute("matiere",mat.getALL());
	        model.addAttribute("abse",abs.getAl());
	        return "absentform";       
	    }
	  @GetMapping("/getabsentformdm")
	    public String addabsrnt3(Model model)
	      
	  {  String string="DMW"; 
	        model.addAttribute("localDate", LocalDate.now());
	        model.addAttribute("etudiant",clre.findbyclas(string));
	        model.addAttribute("matiere",mat.getALL());
	        model.addAttribute("abse",abs.getAl());
	        return "absentform";       
	    }
	  @GetMapping("/getabsentformdas")
	    public String addabsrnt4(Model model)
	      
	  {  String string="DAS"; 
	        model.addAttribute("localDate", LocalDate.now());
	        model.addAttribute("etudiant",clre.findbyclas(string));
	        model.addAttribute("matiere",mat.getALL());
	        model.addAttribute("abse",abs.getAl());
	        return "absentform";       
	    }
	  
	  @GetMapping("/getabsentformai")
	    public String addabsrnt5(Model model)
	      
	  {  String string="AI"; 
	        model.addAttribute("localDate", LocalDate.now());
	        model.addAttribute("etudiant",clre.findbyclas(string));
	        model.addAttribute("matiere",mat.getALL());
	        return "absentform";       
	    }
	  
	  
	  
	  @GetMapping("/absence")
	    public String ab(Model model)   
	  {  
		  
		  model.addAttribute("abs",abs.getAl());
		  System.out.println(abs.getAl());
	        return "absence";       
	    }
	  
	  
	  
	  
	  
	  
	  @RequestMapping("/absent/{id_etud}/{id_matiere}")
	    public String addabsent(@PathVariable  String id_etud,@PathVariable  String id_matiere)
	    
	  {
		  long num=1;
		  Absence absen=new Absence();
	      Etudiant etud= etuservice.getById(Long.valueOf(id_etud));
	      Matiere mate=mat.getById(Long.valueOf(id_matiere));
	      absen.setAbsent(num);
	      absen.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
	      absen.setEtudiant(etud);
	      absen.setMatiere(mate);
	      abs.enreg(absen);
	        return "redirect:/absence";       
	    }
	  
	  
	  @RequestMapping("/absentt/{id_etud}/{id_matiere}")
	    public String marqueAbsence( @PathVariable Long id_etud,@PathVariable Long id_matiere) {
			
		  abs.getabscence(mat.getById(id_matiere), etuservice.getById(id_etud));
		  
		  return null;
		  
	  }
	  
}
