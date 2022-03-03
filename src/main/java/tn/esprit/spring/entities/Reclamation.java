package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;


import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reclamation implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	private String title;
	private String text;
	private String decision;
	
	@ManyToOne
	private User user;

	

}
