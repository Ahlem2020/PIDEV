package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperience implements Serializable{
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String employer ;
	private String location ;
	private Date StartDate;
	private Date endDate ;
	private String description;
	

	 @ManyToOne
	    private CV cv;
}
