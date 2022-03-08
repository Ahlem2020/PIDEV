package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Penality;
import tn.esprit.spring.repository.PenalityRepository;

@Service
public class PenalityServiceImpl implements IPenalityService {
	
	@Autowired
	PenalityRepository penalityRepo;

	@Override
	public Penality addPenalityToLearner(Penality penality, int idLearner) {
		return penalityRepo.save(penality);
	}

	@Override
	public Penality updatePenality(Penality penality) {
		return penalityRepo.save(penality);
	}

	@Override
	public void deletePenality(int idPenality) {
		penalityRepo.deleteById(idPenality);
		
	}
	
	@Override
	public List<Penality> findByLearner(int idLearner) {
		// TODO Auto-generated method stub
		return penalityRepo.findByLearner(idLearner);
	}

	@Override
	public List<Penality> findAllPenalities() {
		// TODO Auto-generated method stub
		return (List<Penality>) penalityRepo.findAll();
	}


}
