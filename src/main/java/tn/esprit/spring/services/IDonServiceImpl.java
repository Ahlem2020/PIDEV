package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Don;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.repository.DonRepository;
import tn.esprit.spring.repository.JackpotRepository;
@Service
public class IDonServiceImpl implements IDonService{

	
	
	@Autowired 
	DonRepository dr;
	@Autowired 
	JackpotRepository jr;
	
	
	
	@Override
	public void addDon(Don don) {
		dr.save(don);
		
	}



	@Override
	public List<Don> getDonByJackpot(int id) {
		Jackpot jack = jr.findById(id).orElse(null);
		return jack.getDons();
		
	}






	


	}

