package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.repository.SubjectRepository;



public class SubjectService implements ISubjectService  {
	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public List<Subject> retrieveAllSubject() {
			return  (List<Subject>) subjectRepository.findAll();
		
	}

	@Override
	public Subject addSubject(Subject S) {
		return subjectRepository.save(S);
 
	}

	@Override
	public void deleteSubject(int id) {
		  subjectRepository.deleteById(id);

	}

	@Override
	public Subject updateSubject(Subject S) {
		return subjectRepository.save(S);
	}

	@Override
	public Subject retrieveSubject(int id) {
 		return null;
	}

	@Override
	public List<Subject> retrieveSubjectByDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
