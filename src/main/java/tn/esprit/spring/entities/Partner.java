package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Partner implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String email;
	private String password;
	private String note;
	private String isDisponible ;
	@Enumerated(EnumType.STRING)
	private PartnerType type;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date  SubscriptionDate ;
	
	
	 @OneToMany(mappedBy="candidature", cascade=CascadeType.ALL)
		
	  	private List<JobOffer> jobOffer;
	 
	 
	 @OneToMany(mappedBy="partner", cascade=CascadeType.ALL)
		
	  	private List<Subscription> Subscription;
}
