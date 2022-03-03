package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Advertisement;
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.services.AdServiceImpli;
import tn.esprit.spring.services.SubjectServiceImpli;

@RestController
@RequestMapping("/Ad")
public class AdRestController {
 
	 	@Autowired
	 	AdServiceImpli adServiceImpli;
		
		// http://localhost:8083/women/Ad/All 
		@GetMapping("/All")
		public List<Advertisement> getAdvertisements() {
		List<Advertisement> listAd = adServiceImpli.retrieveAllAdvertisement();  
		return listAd;
 	}
		// http://localhost:8083/women/Ad/ShowAdvertisement/{Advertisement-id}
		@GetMapping("/ShowAdvertisement/{Advertisement-id}")
		public Advertisement ShowAdvertisement(@PathVariable("Advertisement-id") int id) {
		return adServiceImpli.retrieveAdvertisement(id);
		}
		// http://localhost:8083/women/Ad/AddAdvertisement
		@PostMapping("/AddAdvertisement")
		public Advertisement addAdvertisement(@RequestBody  Advertisement A) {
		return adServiceImpli.addAdvertisement(A);
		}
		// http://localhost:8083/women/Ad/DeleteAdvertisement/{Advertisement-id}

		@DeleteMapping("/DeleteAdvertisement/{Advertisement-id}")
		public void DeleteAdvertisement(@PathVariable("Advertisement-id") int id) {
			adServiceImpli.deleteAdvertisement(id);
		}
		// http://localhost:8083/women/Ad/UpdateSubject

		@PutMapping("/UpdateSubject")
		public Advertisement updateAdvertisement(@RequestBody Advertisement advertisement) {
		return adServiceImpli.updateAdvertisement(advertisement);
		}
}
		
