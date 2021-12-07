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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Feedback")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feedback  implements Serializable{
	@ManyToOne
	private Client client;
	@ManyToOne
	private Produit produit;
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFeedback")
	private Long idFeedback;
	@Column(name = "commentaire")
	private String commentaire;
	@Column(name = "reaction")
	private String reaction ;
	



	

	public Feedback(Client client, Produit produit, Long idFeedback, String reaction) {
		super();
		this.client = client;
		this.produit = produit;
		this.idFeedback = idFeedback;
		this.reaction = reaction;
	}









	public Feedback(Client client, Produit produit, String commentaire) {
		super();
		this.client = client;
		this.produit = produit;
		this.commentaire = commentaire;
	}









	public Feedback(String reaction , Client client, Produit produit ) {
		super();
		this.client = client;
		this.produit = produit;
		this.reaction = reaction;
	}









	public Feedback(Produit produit) {
		super();
		this.produit = produit;
	}
	
	





	
	
}