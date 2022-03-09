package tn.esprit.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import tn.esprit.spring.entities.Penality;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.QuizResponse;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IPdfGenaratorService;
import tn.esprit.spring.services.IPenalityService;
import tn.esprit.spring.services.IQuizService;

@RestController
@RequestMapping("/quiz")
public class QuizRestController {
	@Autowired
	IQuizService quizServ;
	
	@Autowired
	IPdfGenaratorService pdfGenerateService;
	
	@PostMapping("/add")
	@ResponseBody
	public Quiz addQuiz(@RequestBody Quiz q)
	{
		return quizServ.addQuiz(q);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public Quiz updateQuiz(@RequestBody Quiz q) {
		return quizServ.updateQuiz(q);
	}
	
	@DeleteMapping("/remove/{id}")
	@ResponseBody
	public void removeQuiz(@PathVariable("id") int id) {
		quizServ.deleteQuiz(id);
	}
	
	@GetMapping("/retrieve-by-id/{id}")
	@ResponseBody
	public Quiz retrieveById(@PathVariable("id") int id){
		return quizServ.findById(id);
	}
	
	@GetMapping("/retrieve-all-Quizs")
	@ResponseBody
	public List<Quiz> getQuizs() {
		return quizServ.findAllQuizs();
	}
	
	
	@GetMapping("/doQuiz/{idLearner}")
	@ResponseBody
	public int doQuiz(@PathVariable("idLearner") int idLearner, @RequestBody List<Question> questions ) {

		return quizServ.doQuiz(idLearner, questions);
	}
	
	
}
