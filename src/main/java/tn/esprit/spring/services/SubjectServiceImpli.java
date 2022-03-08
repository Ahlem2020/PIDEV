package tn.esprit.spring.services;

 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.IntrestedBy;
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.repository.SubjectRepository;


@Service

public class SubjectServiceImpli implements ISubjectService {
	@Autowired
	EmailSenderService service;
	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	TagsServiceImpli tag;
	@Override
	public List<Subject> retrieveAllSubject() {
		return (List<Subject>) subjectRepository.findAll();

	}




//	@EventListener(ApplicationReadyEvent.class)
//	public void send(){
//	service.sendMail("ahlem.benfradj@esprit.tn","New Subject is Added Check this out !!", "New Subject is Added Check this out !!");
//	}





	public void deleteSubject(int id) {

		subjectRepository.deleteById(id);

	}

	@Override
	public Subject updateSubject(Subject S) {
		String Description = S.getDescription();
		S.setDescription(BadWordFilter.getCensoredText(Description));
		Date currentUtilDate = new Date();
		S.setCreatedAt(null);
		S.setUpdatedAt(currentUtilDate);

		
		return subjectRepository.save(S);
	}

	@Override
	public Subject retrieveSubject(int id) {

		Subject S = subjectRepository.findById(id).orElse(null);
		int nb = S.getNbVue() + 1;
		S.setNbVue(nb);
		subjectRepository.save(S);
		return S;

	}


	@Override
	public List<Subject> retrieveSubjectByDate() {
		return (List<Subject>) subjectRepository.retrieveClientsByDateSql();
	}


@Scheduled(cron = "0 0 0 * * ? ")
	public void bandedSubject() {
	List<Subject> ListSu = (List<Subject>) subjectRepository.findAll();
	for (Subject S : ListSu) {
		if ((S.getNbLike() == 0) && (S.getNbDislike() == 0)) {
			subjectRepository.delete(S);
			System.out.println("Subject is deleted cuz there's no interactions");
		}

	}
}
	@Override
	public Subject addSubject(Subject S) {

		//send();


			List<Subject> ListSub = subjectRepository.exists(S.getDescription(), S.getName());
		System.out.println(ListSub);
		if (!ListSub.isEmpty()) {
			System.out.println("already exist");
		}
		else {
			String Description = S.getDescription();
			S.setDescription(BadWordFilter.getCensoredText(Description));
			Date currentUtilDate = new Date();
			S.setCreatedAt(currentUtilDate);
			S.setUpdatedAt(null);
			S.setNbLike(0);
			S.setNbDislike(0);
			S.setNbVue(0);	
 			tag.addTag(S);
			subjectRepository.save(S);
		}

		return S;
	}
}

	
