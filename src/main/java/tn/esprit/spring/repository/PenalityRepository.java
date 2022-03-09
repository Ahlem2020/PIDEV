package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Penality;

@Repository
public interface PenalityRepository extends CrudRepository<Penality, Integer> {
	List<Penality> findByLearner(long idLearner);

}
