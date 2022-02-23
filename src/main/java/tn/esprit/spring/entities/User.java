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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;

  @OneToMany(mappedBy="candidat", cascade=CascadeType.ALL)
	
	private List<Condidacy> condidaciesC;
   
  // @OneToMany(mappedBy="employer", cascade=CascadeType.ALL)
	
	//private List<Condidacy> condidaciesE;
  
  
	 @OneToOne
	    private CV cv;

  // @OneToMany(mappedBy="user", cascade=CascadeType.ALL)

   // private List<Module> module;
}
