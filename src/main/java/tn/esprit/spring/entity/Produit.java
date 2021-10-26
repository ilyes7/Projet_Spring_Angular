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

import tn.esprit.spring.enumerate.CategorieProduit;

@Entity
@Table(name = "Produit")
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
	Stock stock ;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Fournisseur> fournissuers;
	@ManyToOne
	Rayon rayon ;
	@ManyToOne
	DetailFacture detailFacture ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Set<Feedback> listFeedback;
	
	
	
	public Produit(String code, String libelle, float prixUnitaire, CategorieProduit categorieProduit) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.categorieProduit = categorieProduit;
	}

	public Produit() {
		super();
	}
	
	
	
	public Produit(Long idProduit) {
		super();
		this.idProduit = idProduit;
	}

	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<Fournisseur> getFournissuers() {
		return fournissuers;
	}
	public void setFournissuers(List<Fournisseur> fournissuers) {
		this.fournissuers = fournissuers;
	}
	public Rayon getRayon() {
		return rayon;
	}
	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}
	public DetailFacture getDetailFacture() {
		return detailFacture;
	}
	public void setDetailFacture(DetailFacture detailFacture) {
		this.detailFacture = detailFacture;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", code=" + code + ", libelle=" + libelle + ", prixUnitaire="
				+ prixUnitaire + ", categorieProduit=" + categorieProduit + ", dateCreation=" + dateCreation
				+"]";
	}
	
	
	
}