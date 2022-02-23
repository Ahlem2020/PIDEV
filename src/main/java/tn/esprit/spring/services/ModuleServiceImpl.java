package tn.esprit.spring.services;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Module;

import tn.esprit.spring.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements IModuleService {

	
	@Autowired
	ModuleRepository moduleRepo;
	
	
	@Override
	public void ajouterDc(Module module) {
		
		moduleRepo.save(module);
	}


	@Override
	public List<Module> listerModules() {
			return (List<Module>) moduleRepo.findAll();
	}


	@Override
	public void SupprimerModule(int id) {
		Module m= moduleRepo.findById(id).orElse(null);
		
		moduleRepo.delete(m);
		
	}


	@Override
	public Module UpdateModule(Module m) {
		return moduleRepo.save(m);
	}
	
	
	
	

	
}
