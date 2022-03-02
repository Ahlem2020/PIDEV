package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Activity;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.JackpotRepository;



@Service
public class IEventServiceImpl implements IEventService{

	
	
	@Autowired
	EventRepository er;
	
	@Autowired 
	IJackpotService js;
	@Autowired
	JackpotRepository jr;
	
	/*@Override
	public void addEvent(Event event,Jackpot j) {
		er.save(event);
		
		Jackpot j = new Jackpot();
		j.setDesignation(designation);
		j.setGoal(goal);
		j.setEvent(event);
		j.setEvent(event);
		
		js.addJackpot(j);
		
	}*/
	@Override
	public void suppEvent(int id) {
		er.deleteById(id);
		
	}
	@Override
	public List<Event> getAllEvents() {
		List<Event> x = new ArrayList<>();
		for (Event e:er.findAll()){
			x.add(e);
		}
		return x;
	}
	@Override
	public Event getEventById(int id) {
	
		return er.findById(id).orElse(null);
	}
	
	@Override
	public List<Activity> GetactByidevent(int id) {
			Event event=er.findById(id).orElse(null);
			
		return event.getActivitys();
	}
	@Override
	public void addEvent(Event e) {
		er.save(e);
		
	}
	@Override
	public void addEvent(Event event, String designation, String goal) {
		er.save(event);
		Jackpot j=new Jackpot();
		j.setEvent(event);
		j.setDesignation(designation);
		j.setGoal(goal);
		jr.save(j);
		
	}

}
