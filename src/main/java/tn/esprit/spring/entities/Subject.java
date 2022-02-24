package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Subject  implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Name;
	private String Description;
	private int nbLike;
	private int nbDislike;

	private int nbVue;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreatedAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date UpdatedAt;
	
	@Enumerated(EnumType.STRING)
	private Domain domaine;
	
	@OneToMany(mappedBy="subject") 
	private List<Comment> Comments;


	
	
	
	

	
}
