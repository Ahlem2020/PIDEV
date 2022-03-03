package tn.esprit.spring.services;

import java.util.List;

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
		
		condidacyRepo.save(c);
		
	}

	@Override
	public List<Condidacy> listCondidacy() {
		
		return (List<Condidacy>) condidacyRepo.findAll();
	}

	@Override
	public Condidacy UpdateCondidacy(Condidacy c) {
		
		return condidacyRepo.save(c);
	}

	@Override
	public void DeleteCondidacy(int id) {

		Condidacy c=condidacyRepo.findById(id).orElse(null);
		condidacyRepo.delete(c);
	}


}
