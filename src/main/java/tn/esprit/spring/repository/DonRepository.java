package tn.esprit.spring.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Don;
import tn.esprit.spring.entities.Jackpot;

@Repository
public interface DonRepository extends CrudRepository <Don , Integer>{

	/*@Query("SELECT SUM(d.amount) FROM Don d GROUP BY d.source")
	public int retrivedonsbyuser();*/
}
