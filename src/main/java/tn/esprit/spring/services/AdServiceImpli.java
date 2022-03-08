package tn.esprit.spring.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entities.Advertisement;
 import tn.esprit.spring.repository.AdRepository;
 
@Service

public class AdServiceImpli implements IAdService{
	@Autowired
	AdRepository adRepository;
	@Override
	public List<Advertisement> retrieveAllAdvertisement() {
		return  (List<Advertisement>) adRepository.findAll();

	}


	public Advertisement addAdvertisement(Advertisement A)   {
		return adRepository.save(A);

	}



	@Override
	public void deleteAdvertisement(int id) {
		adRepository.deleteById(id);
	}

	@Override
	public Advertisement updateAdvertisement(Advertisement A) {
		return adRepository.save(A);

	}

	@Override
	public Advertisement retrieveAdvertisement(int id) {
		return adRepository.findById(id).orElse(null);	

	}

}
