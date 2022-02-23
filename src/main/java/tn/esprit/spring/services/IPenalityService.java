package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Penality;

public interface IPenalityService {
	
	Penality addPenalityToLearner(Penality penality, int idLearner);
	
	Penality updatePenality(Penality penality);
	
	void deletePenality(int idPenality);
	
	List<Penality> findAllPenalities();
	
	List<Penality> findByLearner(int idLearner);

}
