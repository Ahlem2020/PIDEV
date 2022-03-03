package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String passwordConfirm;
	private String firstName;
	private String lastName;
	
	@Temporal(TemporalType.DATE)
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
	
	@OneToMany(mappedBy = "user", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Reclamation> reclamations;
	
	@OneToMany(mappedBy = "user", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Meeting> meetings;
	
	@OneToOne
	private IntrestedBy intrestedBy;
		
	@OneToMany(mappedBy = "candidat", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Condidacy> condidaciesC;
	
	@ManyToMany(cascade = CascadeType.ALL)
	public List<Event> events;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	public List<Don> dons;

}
