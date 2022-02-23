package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Activity;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.repository.EventRepository;



@Service
public class IEventServiceImpl implements IEventService{

	
	
	@Autowired
	EventRepository er;
	@Override
	public void addEvent(Event event) {
		
		er.save(event);
	}
	@Override
	public void suppEvent(int id) {
		er.deleteById(id);
		
	}
	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return (List<Event>) er.findAll();
	}
	@Override
	public Event getEventById(int id) {
	
		return er.findById(id).orElse(null);
	}
	/*@Override
	public List<Activity> GetactByidevent(int id) {
			Event event=er.findById(id).orElse(null);
			
		return 
	}*/

}
