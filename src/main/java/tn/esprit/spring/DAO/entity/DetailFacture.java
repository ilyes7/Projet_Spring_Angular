package tn.esprit.spring.DAO.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "DetailFacture")
public class DetailFacture {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailFacture")
	private long idDetailFacture;
	private Integer qte;
	private float prixTotatl;
	private Integer pourcentageRemise;
	private Integer montantRemise;
	
	 @ManyToOne
	 Facture  detailfacture;
	 @ManyToOne 
	 Produit pro;
	

	
	public DetailFacture() {
		super();
	}
	public DetailFacture(long idDetailFacture, Integer qte, float prixTotatl, Integer pourcentageRemise,
			Integer montantRemise) {
		super();
		this.idDetailFacture = idDetailFacture;
		this.qte = qte;
		this.prixTotatl = prixTotatl;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
	}
	public long getIdDetailFacture() {
		return idDetailFacture;
	}
	public void setIdDetailFacture(long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}
	public Integer getQte() {
		return qte;
	}
	public void setQte(Integer qte) {
		this.qte = qte;
	}
	public float getPrixTotatl() {
		return prixTotatl;
	}
	public void setPrixTotatl(float prixTotatl) {
		this.prixTotatl = prixTotatl;
	}
	public Integer getPourcentageRemise() {
		return pourcentageRemise;
	}
	public void setPourcentageRemise(Integer pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}
	public Integer getMontantRemise() {
		return montantRemise;
	}
	public void setMontantRemise(Integer montantRemise) {
		this.montantRemise = montantRemise;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
