package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Activity;
import tn.esprit.spring.entities.Admin;

@Repository
public interface ActivityRepository  extends CrudRepository<Activity, Integer> {

}
