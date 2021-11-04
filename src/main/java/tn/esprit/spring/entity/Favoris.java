package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Favoris")
public class Favoris implements Serializable{

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "idFavoris")
	 private Long idFavoris ;
	 
	 @ManyToMany(cascade = CascadeType.ALL)
	 private Set<Produit> produits;
	 @JsonIgnore
	 @ManyToOne
	 Client client;
}
