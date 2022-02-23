package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.CascadeType;
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
public class Partner {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
 @OneToMany(mappedBy="employer", cascade=CascadeType.ALL)
	
	private List<Condidacy> condidaciesE;
 
 @OneToMany(mappedBy="partner", cascade=CascadeType.ALL)
	
	private List<Module> modules;
   


}
