package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(nullable = false, unique=true, length=255)
	private String email;
	@Column(nullable = false, unique=true, length=255)
	private String password;
	@Column(nullable = false, unique=true, length=255)
	private String passwordConfirm;
	private int note;
	private String name;
	private Date subscriptionDate;
    @Enumerated(EnumType.STRING)
	private PartnerType type;
    private boolean isDesactivate;
	private int counterLogin;
	private String accessToken;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="partners")
	private Set<Subscription> subscriptions;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="partner")
	private Set<Meeting> meetings;

	public Partner(String email, String password, String passwordConfirm, int note, String name, Date subscriptionDate,
			PartnerType type) {
		super();
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.note = note;
		this.name = name;
		this.subscriptionDate = subscriptionDate;
		this.type = type;
	}
	

}
