package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Activity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String designation;
	public Timestamp hour;
	
	@ManyToOne
	public Event Event;
}
