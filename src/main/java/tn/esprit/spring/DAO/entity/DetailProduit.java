package tn.esprit.spring.DAO.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "DetailProduit")
public class DetailProduit {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idClient")
private long idDetailFacture;
	@Temporal(TemporalType.DATE) // indiquer que le champs est de type date n'importiw java.utile
	private Date dateDernierModification;
	@Temporal(TemporalType.DATE) 
	private Date datecreation;
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;
	
	
	@OneToOne (mappedBy="detailproduit")
	private Produit produit;
	
	
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public DetailProduit() {
		super();
	}
	public DetailProduit(long idDetailFacture, Date dateDernierModification, CategorieProduit categorieProduit) {
		super();
		this.idDetailFacture = idDetailFacture;
		this.dateDernierModification = dateDernierModification;
		this.categorieProduit = categorieProduit;
	}
	public long getIdDetailFacture() {
		return idDetailFacture;
	}
	public void setIdDetailFacture(long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}
	public Date getDateDernierModification() {
		return dateDernierModification;
	}
	public void setDateDernierModification(Date dateDernierModification) {
		this.dateDernierModification = dateDernierModification;
	}
	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
