package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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

public class Subject  implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Name;
	private String Description;
	private int nbLike;
	private int nbDislike;

	private int nbVue;
	private Date CreatedAt;
	private Date UpdatedAt;
	private Domaine domaine;
	@OneToMany 
	private List<Comment> Comments;
	public enum Domaine{
		couture,texture,Sewing,Coiffure;
	}

	
	
	
	

	
}
