package tn.esprit.spring.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Advertisement;
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.services.AdServiceImpli;
import tn.esprit.spring.services.FileUploadUtil;
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
 
  		public void addAdvertisement(@RequestParam ("nameAd") String nameAd, @RequestParam ("canal") String canal, @RequestParam ("dateDeb") Date dateDeb, @RequestParam ("dateFin") Date dateFin,
  			
  				@RequestParam ("nbVueCible") int nbVueCible, @RequestParam ("nbVueFinal") int nbVueFinal,@RequestParam ("price") Double  price,@RequestParam("upload") MultipartFile upload )
  		
		{

			String fileName = StringUtils.cleanPath(upload.getOriginalFilename());
			Advertisement A = new Advertisement();
			A.setNameAd(nameAd);
			A.setCanal(canal);
			A.setDateDeb(dateDeb);
			A.setDateFin(dateFin);
			A.setNbVueCible(nbVueFinal);
			A.setNbVueFinal(nbVueFinal);
			A.setPrice(price);
			A.setUpload(fileName);
		Advertisement SavedAdd= adServiceImpli.addAdvertisement(A);

			String uploadDir = "upload/" + SavedAdd.getId();


			try {
				FileUploadUtil.saveFile(uploadDir, fileName, upload);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	 
 			
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
		
