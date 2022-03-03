package tn.esprit.spring.services;

 
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.repository.SubjectRepository;


@Service

public class SubjectServiceImpli implements ISubjectService  {
	@Autowired
	  EmailSenderService service;
	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public List<Subject> retrieveAllSubject() {
			return  (List<Subject>) subjectRepository.findAll();
		
	}

	@Override
	public Subject addSubject(Subject S) {
		send();
		return subjectRepository.save(S);
		
 
	}
 
				
	@EventListener(ApplicationReadyEvent.class)
	public void send(){
	service.sendMail("ahlem.benfradj@esprit.tn","New Subject is Added Check this out !!", "New Subject is Added Check this out !!");
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
		return subjectRepository.findById(id).orElse(null);	
	}

	@Override
	public List<Subject> retrieveSubjectByDate(){
 				return (List<Subject>) 	subjectRepository.retrieveClientsByDateSql();
	}

	
}
