package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Condidacy implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date created_at;
	@Enumerated(EnumType.STRING)
	private State state;
	@Enumerated(EnumType.STRING)
	private Type type;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date dateInterview;
	 
	
    @ManyToOne
    private User candidat;
   
    @ManyToOne
    private JobOffer jobOffer;
    
   /* @ManyToOne
    private Interview interview;
*/
  
    @ManyToOne
    private Partner employer;
    
    @OneToMany(mappedBy="partner", cascade=CascadeType.ALL)

    private List<Module> module;
    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}