package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Module;

public interface ModuleRepository extends CrudRepository<Module, Integer> {

	
}
