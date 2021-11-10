package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@RequiredArgsConstructor
@Setter
@ToString
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idClient")
	long idClient;
	String nom ;
	String prenom;
	@Temporal (TemporalType.DATE)
	Date dateNaissance;
	String email;
	String password;
	@Enumerated
	CategorieClient categorieClient;
	@Enumerated
	profession profession;
	
	
	@OneToMany(mappedBy="Client",cascade=CascadeType.ALL)
	private Set<Facture> Factures;
	
}
