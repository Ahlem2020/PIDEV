package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Condidacy;

public interface ICondidacyService {
	
	 void addCandidacy(Condidacy c);
	 List<Condidacy> listCondidacy();
	 Condidacy UpdateCondidacy(Condidacy c);
	 void DeleteCondidacy(int id);
	 
	 
	 
	  
}
