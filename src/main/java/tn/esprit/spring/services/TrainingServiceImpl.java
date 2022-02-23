package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements ITrainingService {
	@Autowired
	TrainingRepository traininigRepo; 

	@Override
	public Training addTraining(Training training) {
		return traininigRepo.save(training);
	}

	@Override
	public Training updateTraining(Training training) {
		return traininigRepo.save(training);
	}

	@Override
	public void deleteTraining(int idTraining) {
		traininigRepo.deleteById(idTraining);
		
	}

	@Override
	public List<Training> getAllTrainings() {
		return (List<Training>) traininigRepo.findAll();
	}

	@Override
	public List<Training> findBySubject(String subject) {
		return traininigRepo.findBySubject(subject);
	}

	@Override
	public Training findById(int id) {
		return traininigRepo.findById(id).orElse(null);
	}

}
