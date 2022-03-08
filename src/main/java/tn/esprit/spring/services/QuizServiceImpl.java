package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;

@Service
public class QuizServiceImpl implements IQuizService {
	@Autowired
	QuizRepository quizRepo;
	@Autowired
	QuestionRepository questionRepo;

	@Override
	@Transactional
	public Quiz addQuiz(Quiz quiz) {
		List<Question> questions = quiz.getQuestions();
		for (Question question : questions) {
			question.setQuiz(quiz);
			questionRepo.save(question);
		}
		return quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		List<Question> questions = quiz.getQuestions();
		for (Question question : questions) {
			question.setQuiz(quiz);
			questionRepo.save(question);
		}
		return quizRepo.save(quiz);
	}

	@Override
	public void deleteQuiz(int idQuiz) {
		Quiz quiz = quizRepo.findById(idQuiz).orElse(null);
		List<Question> questions = quiz.getQuestions();
		questionRepo.deleteAll(questions);
		quizRepo.deleteById(idQuiz);
	}

	@Override
	public List<Quiz> findAllQuizs() {		
		return (List<Quiz>) quizRepo.findAll();
	}

	@Override
	public Quiz findById(int id) {
		return quizRepo.findById(id).orElse(null);
	}

}
