package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String firstName;
	public String lastName;
	public int monthlyIncome;
	public String civilState;
	public int nbPersFamily;
	
	@ManyToMany(cascade = CascadeType.ALL)
	public List<Event> events;
	
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	public List<Don> dons;
	
	
}
