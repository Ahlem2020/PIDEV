package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Partner;
import tn.esprit.spring.repository.PartnerRepository;

@Service
public class PartnerServiceImpl implements IPartnerService{
	
	@Autowired
	PartnerRepository partnerRepository;
	@Override
	public List<Partner> retrieveAllPartners() {
		return (List<Partner>) partnerRepository.findAll();
	}
	
	@Override
	public Partner addPartner(Partner u) {
		partnerRepository.save(u);
		return u;
	}

	@Override
	public void deletePartner (long id) {
		partnerRepository.deleteById(id);
	}

	@Override
	public Partner updatePartner(Partner u) {
		partnerRepository.save(u);
		return u;
	}

	@Override
	public Partner retrievePartner(long id) {
		Partner u = partnerRepository.findById(id).get();
		return u;
	}

}
