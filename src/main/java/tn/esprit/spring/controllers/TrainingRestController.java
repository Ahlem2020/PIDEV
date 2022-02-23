package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.services.ITrainingService;

@RestController
@RequestMapping("/training")
public class TrainingRestController {
	@Autowired
	ITrainingService trainingServ;
	
	@PostMapping("/add")
	@ResponseBody
	public Training addTraining(@RequestBody Training t)
	{
		return trainingServ.addTraining(t);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public Training updateTraining(@RequestBody Training t) {
		return trainingServ.updateTraining(t);
	}
	
	@DeleteMapping("/remove/{id}")
	@ResponseBody
	public void removeClient(@PathVariable("id") int id) {
		trainingServ.deleteTraining(id);
	}
	
	@GetMapping("/retrieve-Training/{id}")
	@ResponseBody
	public Training retrieveTraining(@PathVariable("id") int id) {
		return trainingServ.findById(id);
	}
	
	@GetMapping("/retrieve-Subject/{subj}")
	@ResponseBody
	public List<Training> retrieveBySubject(@PathVariable("subj") String subj){
		return trainingServ.findBySubject(subj);
	}
	
	@GetMapping("/retrieve-all-training")
	@ResponseBody
	public List<Training> getClients() {
		return trainingServ.getAllTrainings();
	}

}
