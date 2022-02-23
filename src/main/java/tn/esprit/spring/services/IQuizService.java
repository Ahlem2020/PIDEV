package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Quiz;

public interface IQuizService {
	
	Quiz addQuiz(Quiz quiz);
	
	Quiz updateQuiz(Quiz quiz);
	
	void deleteQuiz(int idQuiz);
	
	List<Quiz> findAllQuizs();
	
	Quiz findById(int id);

}
