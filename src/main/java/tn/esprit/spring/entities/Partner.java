package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Partner implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String passwordConfirm;
	private int note;
	private boolean isDisponible;
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date subscriptionDate;
	
	@Enumerated(EnumType.STRING)
	private PartnerType type;
	
	@OneToMany(mappedBy = "partner", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Subscription> subscriptions;
	
	@OneToMany(mappedBy = "partner", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Meeting> meetings;
	
	@OneToMany(mappedBy = "employer", cascade={CascadeType.PERSIST, CascadeType.REMOVE})	
	private List<Condidacy> condidaciesE;
 
	@OneToMany(mappedBy="partner", cascade=CascadeType.ALL)	
	private List<Module> modules;
	
	@OneToMany(mappedBy="candidature", cascade=CascadeType.ALL)	
  	private List<JobOffer> jobOffer;
 
 
	@OneToMany(mappedBy="partner", cascade=CascadeType.ALL)	
  	private List<Subscription> Subscription;
	

}
