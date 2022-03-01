package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.services.IReclamationService;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationRestController {
	
	@Autowired
	IReclamationService reclamationService;
	
	
	
	

}
