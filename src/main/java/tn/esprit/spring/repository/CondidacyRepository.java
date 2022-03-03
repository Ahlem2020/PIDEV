package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Condidacy;

public interface CondidacyRepository extends CrudRepository<Condidacy, Integer> {
	@Query("select c from Condidacy c where c.state = 'In_Progress' And c.type ='JOB'")
	List<Condidacy> getModuleAutomatique();

}
