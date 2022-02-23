package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Condidacy;

public interface ICondidacyService {
	
	 void addCandidacy(Condidacy c, int idUser);
	 List<Condidacy> listCondidacy();
	 Condidacy UpdateCondidacy(Condidacy c);
	 void DeleteCondidacy(int id);
	 
	 
	 
	  
}
