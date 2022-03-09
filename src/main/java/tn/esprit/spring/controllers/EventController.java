package tn.esprit.spring.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import CSVHelper.CSVHelper;
import CSVHelper.ResponseMessage;
import tn.esprit.spring.entities.Activity;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.services.CSVsService;
import tn.esprit.spring.services.FileUploadUtil;
import tn.esprit.spring.services.IEventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	  CSVsService fileService;
	
	@Autowired
	IEventService es ;
	@PostMapping("/ajout-event")
	public void addevent(@RequestBody Event e,@RequestParam String designation,@RequestParam String goal ,@RequestParam int amount )
	{
		es.addEvent(e, designation,goal,amount);
	}
	
	
	@PostMapping(value="/ajout-event-upload")
			//consumes = MediaType., produces = MediaType.APPLICATION_JSON_VALUE )
	
	public void addeventwithimg(/*@RequestBody Event e*/@RequestParam("description")String description,@RequestParam("domain")String domain,@RequestParam("eventDate") Date eventDate,@RequestParam("endDate") Date endDate ,@RequestParam("image") MultipartFile multipartFile)throws IOException 
	{	
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	
	Event e = new Event();
	e.setDescription(description);
	e.setDomain(domain);
	e.setEventDate(eventDate);
	e.setEndDate(endDate);
	e.setPhotos(fileName);
	e.setCreated_at(date);

	es.addEvent(e);
	
    String uploadDir = "uploads/";

    try {
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     
   
		
		
		/*e.setPhotos(multipartFile.getOriginalFilename());
		es.addEvent(e);*/
	}
	@DeleteMapping("/delete-event/{id}")
	public void suppEvent(@PathVariable("id") int id)
	{
		es.suppEvent(id);
	}
	
	
	@GetMapping("/get-events")
	public List<Event> getAllEvents()
	{
		return es.getAllEvents();
	}
	@GetMapping("/get-events/{id}")
	public Event getEventsById(@PathVariable("id") int id)
	{
		
				
		return es.getEventById(id);
	}
	
	@GetMapping("/get-acti/{id}")
	public List<Activity> getactsById(@PathVariable("id") int id)
	{
		
				
		return es.GetactByidevent(id);
	}
	@GetMapping("/get-eventbydesc/{description}")
	public List<Event> geteventsbydesc(@PathVariable("description") String description)
	{
		return es.geteventsbydescription(description);
	}
	
	

	
	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (CSVHelper.hasCSVFormat(file)) {
	      try {
	    	  
	    	  fileService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/api/csv/download/")
	                .path(file.getOriginalFilename())
	                .toUriString();

	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,fileDownloadUri));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
	      }
	    }

	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
	  }
}
