package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Activity;
import tn.esprit.spring.entities.Event;

public interface IEventService {

	
	
	
	void addEvent(Event event);
	void suppEvent(int id);
	public List<Event> getAllEvents();
	public Event getEventById(int id);
	//public List<Activity> GetactByidevent(int id);
}
