package tn.esprit.spring.controllers;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.services.*;
 @RestController
@RequestMapping("/Subject")
public class SubjectRestController {
	@Autowired
	SubjectServiceImpli subjectService;

	
	// http://localhost:8083/women/Subject/All 
	@GetMapping("/All")
	public List<Subject> getSubjects() {
	List<Subject> listSubject = subjectService.retrieveAllSubject();
	return listSubject;
 
}
	// http://localhost:8083/women/Subject/ShowSubject/{Subject-id}
	@GetMapping("/ShowSubject/{Subject-id}")
	public Subject retrieveSubject(@PathVariable("Subject-id") int id) {
	return subjectService.retrieveSubject(id);
	}
	// http://localhost:8083/women/Subject/AddSubject

	@PostMapping("/AddSubject")
	public Subject addSubject(@RequestBody  Subject s)   {
	return subjectService.addSubject(s);
 
	}
	// http://localhost:8083/women/Subject/DeleteSubject/{Subject-id}

	@DeleteMapping("/DeleteSubject/{Subject-id}")
	public void DeleteSubject(@PathVariable("Subject-id") int id) {
		subjectService.deleteSubject(id);
	}
	// http://localhost:8083/women/Subject/UpdateSubject

	@PutMapping("/UpdateSubject")
	public Subject updateSubject(@RequestBody Subject subject) {
	return subjectService.updateSubject(subject);
	}
	// http://localhost:8083/women/Subject/news
	@GetMapping("/news")
	public  List<Subject>  retrieveSubjectByDate(){
		List<Subject> listNews = subjectService.retrieveSubjectByDate();
	return listNews;
	}
	
 }