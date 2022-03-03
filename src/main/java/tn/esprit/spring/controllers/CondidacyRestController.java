package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Condidacy;
import tn.esprit.spring.services.ICondidacyService;


@RestController
@RequestMapping("/condidacy")
public class CondidacyRestController {
	@Autowired
	ICondidacyService condidacyService;
	
	@PostMapping("/add-condidacy")
	public void addCondidacy(@RequestBody Condidacy c){
		condidacyService.addCandidacy(c);
	}
	
	@GetMapping("/retrieve-condidacy")
	public List<Condidacy> AfficherCondidacy(){
		return condidacyService.listCondidacy();
		
	}
	
	@PutMapping("/modifier-condidacy")
	public Condidacy ModifierCondidacy(@RequestBody Condidacy c){
		return condidacyService.UpdateCondidacy(c);
	
	}
	
   @DeleteMapping("/delete-condidacy/{id}")
    public void supprimerCondidacy(@PathVariable("id") int id){
	   
	   condidacyService.DeleteCondidacy(id);
	
}
}	

