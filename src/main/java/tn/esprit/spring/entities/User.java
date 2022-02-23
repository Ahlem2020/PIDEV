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
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String passwordConfirm;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String sexe;
	private String civilState;
	private String address;
	private int postalCode;
	private int phoneNumber;
	private String nationality;
	private String job;
	private String studyLevel;
	private String status;
	private float monthlyUncome;
	private int nbPersFamily;
	private int nbStudentsInFamily;
	private String favory;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	private Set<Reclamation> reclamations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	private Set<Meeting> meetings;
	
	@OneToOne
	private IntrestedBy intrestedBy;*/
	
	
	
    @OneToMany(mappedBy="candidat", cascade=CascadeType.ALL)
	
	private List<Condidacy> condidaciesC;
   
   

  
  
    



     




}
