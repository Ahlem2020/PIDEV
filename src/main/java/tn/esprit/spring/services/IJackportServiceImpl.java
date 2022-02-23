package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.repository.JackpotRepository;

@Service
public class IJackportServiceImpl implements IJackpotService{

	
	@Autowired
	JackpotRepository jr;
	@Override
	public void addJackpot(Jackpot jackpot) {
		jr.save(jackpot);
		
	}

}
