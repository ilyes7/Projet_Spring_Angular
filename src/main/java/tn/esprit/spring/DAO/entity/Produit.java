package tn.esprit.spring.DAO.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Produit")
public class Produit {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prixUnitaire;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pro")
	private Set<DetailFacture> details;
	
	@ManyToOne
	 Stock stock;
	@ManyToOne 
	Rayon rayon;
	
	@OneToOne
	 private DetailProduit detailproduit ;
	
	@ManyToMany (cascade=CascadeType.ALL)
	   private Set<Fournisseur>Fournissuers;
	   
	
	public Produit() {
		super();
	}
	public Produit(long idProduit, String codeProduit, String libelleProduit, float prixUnitaire) {
		super();
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prixUnitaire = prixUnitaire;
	}
	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	public String getCodeProduit() {
		return codeProduit;
	}
	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}
	public String getLibelleProduit() {
		return libelleProduit;
	}
	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Set<DetailFacture> getDetails() {
		return details;
	}
	public void setDetails(Set<DetailFacture> details) {
		this.details = details;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public Rayon getRayon() {
		return rayon;
	}
	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}
	public DetailProduit getDetailproduit() {
		return detailproduit;
	}
	public void setDetailproduit(DetailProduit detailproduit) {
		this.detailproduit = detailproduit;
	}
	public Set<Fournisseur> getFournissuers() {
		return Fournissuers;
	}
	public void setFournissuers(Set<Fournisseur> fournissuers) {
		Fournissuers = fournissuers;
	}
	
	
	
	
	
	
	
	
	
	
}
