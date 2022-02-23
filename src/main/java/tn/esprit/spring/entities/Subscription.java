package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Subscription implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String designation;
	private Long montant;
	private String duration;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date date ;
	
	 @ManyToOne
	    private Partner partner;
}
