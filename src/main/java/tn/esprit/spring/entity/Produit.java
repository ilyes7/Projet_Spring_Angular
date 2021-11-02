package tn.esprit.spring.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.spring.enumerate.CategorieProduit;

@Entity
@Table(name = "Produit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduit")
	private Long idProduit ; 
	@Column(name = "code")
	private String code;
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "prixUnitaire")
	private float prixUnitaire;
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;
	@Column(name = "dateCreation")
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	
	@ManyToOne
	@ToString.Exclude Stock stock ;
	@ManyToMany(cascade = CascadeType.ALL)
	@ToString.Exclude private List<Fournisseur> fournissuers;
	@ManyToOne
	@ToString.Exclude Rayon rayon ;
	@ManyToOne
	@ToString.Exclude DetailFacture detailFacture ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	@ToString.Exclude private Set<Feedback> listFeedback;
	
	
	
	public Produit(String code, String libelle, float prixUnitaire, CategorieProduit categorieProduit) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.categorieProduit = categorieProduit;
	}


	
	
	
	public Produit(Long idProduit) {
		super();
		this.idProduit = idProduit;
	}

  

	public Produit(String code, String libelle, float prixUnitaire, CategorieProduit categorieProduit,
			Date dateCreation) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.categorieProduit = categorieProduit;
		this.dateCreation = dateCreation;
	}





	public Produit(Long idProduit, String code, String libelle, float prixUnitaire, CategorieProduit categorieProduit) {
		super();
		this.idProduit = idProduit;
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.categorieProduit = categorieProduit;
	}
	
	
	
}