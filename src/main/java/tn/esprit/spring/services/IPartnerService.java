package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.*;

public interface IPartnerService {
	
	List<Partner> retrieveAllPartners();

	Partner addPartner(Partner p);

	void deletePartner(long id);

	Partner updatePartner(Partner p);

	Partner retrievePartner(long id);

}
