package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Condidacy;
import tn.esprit.spring.repository.CondidacyRepository;

@Service
public class CondidacyService implements ICondidacyService{
  
	@Autowired
	CondidacyRepository condidacyRepo;

	@Override
	public void addCandidacy(Condidacy c) {
		
		
	}


}
