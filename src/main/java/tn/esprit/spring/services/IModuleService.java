package tn.esprit.spring.services;



import java.util.List;

import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Module;


public interface IModuleService {
	 void ajouterModule(Module module);
	 List<Module> listerModules();
	 void SupprimerModule(int id);
	 Module UpdateModule(Module m);
	 
	 
	     


}
