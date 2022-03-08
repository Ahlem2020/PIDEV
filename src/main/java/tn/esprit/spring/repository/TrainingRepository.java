package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Training;
@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {
	
	List<Training> findBySubject(String subject);

}
