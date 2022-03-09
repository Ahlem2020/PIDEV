package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Condidacy;
import tn.esprit.spring.entities.Module;
import tn.esprit.spring.entities.Partner;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.payload.MessageResponse;
import tn.esprit.spring.repository.PartnerRepository;
import tn.esprit.spring.security.JwtUtils;
import tn.esprit.spring.services.IModuleService;
import tn.esprit.spring.services.IPartnerService;

@RestController
@RequestMapping("/module")
public class ModuleRestController {

	@Autowired
	IModuleService moduleService;
	
	@Autowired
	PartnerRepository partnerRepository;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/add-module/{id}")
	public  ResponseEntity<?> addCondidacy(@RequestBody Module m,@RequestHeader (name="Authorization") String token){
		if(token==null){
			return ResponseEntity.badRequest().body(new MessageResponse("You are not connected" ));
		}
		String email;
		try{
			token=token.replace("Bearer ", "");
			email = jwtUtils.getUserNameFromJwtToken(token);
		if(email==null){
			return ResponseEntity.badRequest().body(new MessageResponse("You are not authorized" ));	
		}
		}catch(Exception e){
			return ResponseEntity.badRequest().body(new MessageResponse("You are not authorized" ));	
		}
		
		Partner partner=partnerRepository.findByEmail(email).get();
		 moduleService.ajouterModule(m,partner.getId());
		
		 return ResponseEntity.ok(m);
		 
	}
	
	@GetMapping("/retrieve-module")
	public List<Module> AfficherModule(){
		return moduleService.listerModules();
		
	}
	
	@PutMapping("/modifier-module")
	public Module ModifierModule(@RequestBody Module m){
		return moduleService.UpdateModule(m);
	
	}
	
	
	 @DeleteMapping("/delete-module/{id}")
	    public void supprimerModule(@PathVariable("id") int id){
		   
		 moduleService.SupprimerModule(id);
		
	}
	
	
	
	
	
	
	
	
	
}
