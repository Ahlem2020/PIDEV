package tn.esprit.spring.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Activity;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.services.IEventService;

@RestController
@RequestMapping("/event")
public class EventController {

	
	@Autowired
	IEventService es ;
	@PostMapping("/ajout-event")
	public void addevent(@RequestBody Event e)
	{
		es.addEvent(e);
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
	
	/*@GetMapping("/get-acti/{id}")
	public List<Activity> getactsById(@PathVariable("id") int id)
	{
		
				
		return es.GetactByidevent(id);
	}*/
}
