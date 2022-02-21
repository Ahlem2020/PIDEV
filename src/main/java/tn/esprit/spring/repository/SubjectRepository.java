package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Subject;
@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {

}
