package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.JobOffer;
import tn.esprit.spring.repository.JobOfferRepository;

@Service
public class JobOfferService implements IJobOfferService {

	@Autowired
	JobOfferRepository JobOfferRepo ;

	@Override
	public void AddJobOffer(JobOffer jobOffer) {
		JobOfferRepo.save(jobOffer ) ;
		
	}
/*
	@Override
	public Iterable<JobOffer> listAllJobOffers() {
		
		return  JobOfferRepo.findAll();
	}
*/
	/*@Override
	public JobOffer getJobOfferById(Integer id) {
		return JobOfferRepo.findAllById(id);
	}
*/
	@Override
	public void deleteJobOffer(Integer id) {
		JobOfferRepo.deleteById(id);
		
	}

	/*@Override
	public JobOffer getJobOfferById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public JobOffer updateJobOffer(JobOffer jobOffer) {
		return JobOfferRepo.save(jobOffer);
	}

	@Override
	public List<JobOffer> getAllJobs() {
		return (List<JobOffer>) JobOfferRepo.findAll();
	}
/*
	@Override
	public List<JobOffer> findById(Integer idJOffer) {
		return JobOfferRepo.findById(idJOffer);
	}

	*/
	/*
	 * @Override
	 /*
	public void UpdateJobOffer(Integer id, JobOffer jobOffer) {
		JobOfferRepo.save(jobOffer) ;
	}
*/
	
}
