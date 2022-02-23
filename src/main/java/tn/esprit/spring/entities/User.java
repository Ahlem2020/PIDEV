package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private int id;
	private String name;
		
	
	@OneToMany(mappedBy = "learner",  cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Penality> penalities;
	
	@ManyToMany(mappedBy="learners", cascade = CascadeType.ALL)
	private List<Training> trainings;
	
	@OneToMany(mappedBy = "user",  cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Reaction> reactions;

}
