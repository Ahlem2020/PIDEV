package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Advertisement;
@Repository
public interface AdRepository extends CrudRepository<Advertisement, Integer> {

}
