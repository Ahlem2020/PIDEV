package tn.esprit.spring.services;

import java.util.List;

import javax.mail.MessagingException;

import tn.esprit.spring.entities.Subject;


public interface ISubjectService {

	List<Subject> retrieveAllSubject();
	Subject addSubject(Subject S) ;
	void deleteSubject(int id);
	Subject updateSubject(Subject c);
	Subject retrieveSubject(int id);
	List<Subject> retrieveSubjectByDate();
}
	
