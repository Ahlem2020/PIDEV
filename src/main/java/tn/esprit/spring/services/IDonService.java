package tn.esprit.spring.services;

import java.util.List;
import java.util.Map;

import tn.esprit.spring.entities.Don;

public interface IDonService {

	
	
	public void addDon(Don don);
	public List<Don> getDonByJackpot(int id);
	//public int retrivedonsbyuser();
}
