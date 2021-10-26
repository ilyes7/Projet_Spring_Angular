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

@Entity
@Table(name = "Feedback")
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
	@Column(name = "liked")
	private Boolean liked;
	@Column(name = "disliked")
	private Boolean disliked;
	@Column(name = "verified")
	private Boolean verified;
	
	
	
	
	public Feedback() {
		super();
	}
	
	
	
	public Feedback(Client client, Boolean disliked, Produit produit) {
		super();
		this.client = client;
		this.disliked = disliked;
		this.produit = produit;
		
	}



	public Feedback(Client client, Produit produit, Boolean liked) {
		super();
		this.client = client;
		this.produit = produit;
		this.liked = liked;
	}



	public Feedback(Client client, Produit produit, String commentaire) {
		super();
		this.client = client;
		this.produit = produit;
		this.commentaire = commentaire;
	}



	public Feedback(Client client, Produit produit, String commentaire, Boolean liked, Boolean disliked) {
		super();
		this.client = client;
		this.produit = produit;
		this.commentaire = commentaire;
		this.liked = liked;
		this.disliked = disliked;
	}



	public Feedback(Client client, Produit produit, Long idFeedback, String commentaire, Boolean liked, Boolean disliked) {
		super();
		this.client = client;
		this.produit = produit;
		this.idFeedback = idFeedback;
		this.commentaire = commentaire;
		this.liked = liked;
		this.disliked = disliked;
	}



	public Client getUser() {
		return client;
	}
	public void setUser(Client client) {
		this.client = client;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Long getIdFeedback() {
		return idFeedback;
	}
	public void setIdFeedback(Long idFeedback) {
		this.idFeedback = idFeedback;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Boolean isLike() {
		return liked;
	}
	public void setLike(Boolean liked) {
		this.liked = liked;
	}
	public Boolean isDislike() {
		return disliked;
	}
	public void setDislike(Boolean disliked) {
		this.disliked = disliked;
	}

	
	
}