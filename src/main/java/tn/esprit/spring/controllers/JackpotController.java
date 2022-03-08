package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Donationuser;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.payload.MessageResponse;
import tn.esprit.spring.repository.DonationuserRepository;
import tn.esprit.spring.security.JwtUtils;
import tn.esprit.spring.services.IJackportServiceImpl;
import tn.esprit.spring.services.IJackpotService;

@RestController
@RequestMapping("/jackpot")
public class JackpotController {

	@Autowired
	IJackpotService js;
	@Autowired 
	DonationuserRepository dr;
	
	@Autowired
	JwtUtils jwtUtils;
	@PostMapping("/ajout-jackpot")
	public ResponseEntity<?> addjackpot(@RequestHeader (name="Authorization") String token ,@RequestBody Jackpot j)
	{
		if(token==null){
			return ResponseEntity.badRequest().body(new MessageResponse("You are not connected" ));
		}
		String email;
		try{
			token=token.replace("Bearer ", "");
			email = jwtUtils.getUserNameFromJwtToken(token);
		if(email==null){
			return ResponseEntity.badRequest().body(new MessageResponse("You are not authorized" ));	
		}else
		{
			js.addJackpot(j);
			
			 return ResponseEntity.ok(new MessageResponse("Jackpot created"));
		}
		}catch(Exception e){
			return ResponseEntity.badRequest().body(new MessageResponse("You are not authorized" ));	
		}
		
	
		
		
		
	}
	
	@GetMapping("/jackpots-encours")
	public List<Jackpot> getalljackpotsencours()
	{
		return js.jackpotencrs();
	}
	@GetMapping("/listegangant")
	public  Map<Integer, Integer> listegagants()
	{
		return js.afficherlisteneedy();
	}
	@GetMapping("/score/{id}")
	public int calculer (@PathVariable("id")int id)
	{	Donationuser u=dr.findById(id).orElse(null);
		return js.calculerscore(u);
	}
	@GetMapping("/att/{id}")
	public Map<Integer, Integer> attribuerjackpot(@PathVariable("id") int i)
	{
		return js.attribuerjackpot(i);
	}
}
