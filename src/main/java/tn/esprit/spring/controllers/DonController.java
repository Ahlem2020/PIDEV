package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Don;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.services.IDonService;
import tn.esprit.spring.services.IJackpotService;

@RestController
@RequestMapping("/don")
public class DonController {

	
	@Autowired
	IDonService ds;
	
	
	@PostMapping("/ajout-don")
	public void adddon(@RequestBody Don d)
	{
		ds.addDon(d);
	}
}
