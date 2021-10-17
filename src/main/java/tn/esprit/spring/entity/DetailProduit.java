package tn.esprit.spring.entity;

import java.io.Serializable;
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

import tn.esprit.spring.enumerate.CategorieProduit;

@Entity
@Table(name="DetailProduit")
public class DetailProduit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailProduit")
	private Long idDetailProduit;
	@Column(name = "dateCreation")
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Column(name = "dateDerniereModification")
	private String dateDerniereModification ;
	@Column(name = "categorieProduit")
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;
	@OneToOne(mappedBy="detailproduit")
	private Produit produit ;
	
	public DetailProduit(Long idDetailProduit, Date dateCreation, String dateDerniereModification,
			CategorieProduit categorieProduit) {
		super();
		this.idDetailProduit = idDetailProduit;
		this.dateCreation = dateCreation;
		this.dateDerniereModification = dateDerniereModification;
		this.categorieProduit = categorieProduit;
	}
	public DetailProduit(Date dateCreation, String dateDerniereModification, CategorieProduit categorieProduit) {
		super();
		this.dateCreation = dateCreation;
		this.dateDerniereModification = dateDerniereModification;
		this.categorieProduit = categorieProduit;
	}
	public DetailProduit() {
		super();
	}
	public Long getIdDetailProduit() {
		return idDetailProduit;
	}
	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getDateDerniereModification() {
		return dateDerniereModification;
	}
	public void setDateDerniereModification(String dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}
	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}
	
	
	

}
