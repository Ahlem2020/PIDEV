package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Penality;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.PenalityRepository;
import tn.esprit.spring.repository.TrainingRepository;

@Service
public class PenalityServiceImpl implements IPenalityService {
	
	@Autowired
	PenalityRepository penalityRepo;
	@Autowired
	TrainingRepository trainingRepo;

	@Override
	public Penality addPenalityToLearner(Penality penality, long idLearner, int idTraining) {
		Training t = trainingRepo.findById(idTraining).orElse(null);
		User learner = new User();
		learner.setId(idLearner);
		
		penality.setLearner(learner);
		penality.setTraining(t);
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
	public List<Penality> findByLearner(long idLearner) {
		// TODO Auto-generated method stub
		return penalityRepo.findByLearner(idLearner);
	}

	@Override
	public List<Penality> findAllPenalities() {
		// TODO Auto-generated method stub
		return (List<Penality>) penalityRepo.findAll();
	}


}
