package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Training;

public interface ITrainingService {
	
	Training addTraining(Training training);
	
	Training updateTraining(Training training);
	
	void deleteTraining(int idTraining);
	
	Training findById(int id);
	
	List<Training> getAllTrainings();
		
	List<Training> findBySubject(String subject);

}
