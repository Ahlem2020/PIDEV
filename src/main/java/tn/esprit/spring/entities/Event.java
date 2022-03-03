package tn.esprit.spring.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	public String description;
	public Date eventDate;
	public Date endDate;
	public Date created_at;
	public String domain;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="Event")
	public List<Activity> activitys;
	
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="events")
	public List<User> participants;
	
	@OneToOne(mappedBy="event")
	public Jackpot jackpot;
	
	
}


