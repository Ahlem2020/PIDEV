package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.services.IJackportServiceImpl;
import tn.esprit.spring.services.IJackpotService;

@RestController
@RequestMapping("/jackpot")
public class JackpotController {

	@Autowired
	IJackpotService js;
	
	
	@PostMapping("/ajout-jackpot")
	public void addjackpot(@RequestBody Jackpot j)
	{
		js.addJackpot(j);
	}
}
