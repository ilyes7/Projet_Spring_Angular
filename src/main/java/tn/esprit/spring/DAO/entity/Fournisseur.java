package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
@Entity
@Table( name = "Fournisseur") 
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFournisseur")
	private long  idFournisseur;
	private String codeFournisseur;
	private String libelleFournisseur;
	
	/*@ManyToMany
	@JoinTable(
	  name = "Produit", 
	  joinColumns = @JoinColumn(name = "idFournisseur"), 
	  inverseJoinColumns = @JoinColumn(name = "idProduit"))
	Set<Produit> produits;
	*/
	public Fournisseur() {
		super();
	}
	
	public Fournisseur(long idFournisseur, String codeFournisseur, String libelleFournisseur) {
		super();
		this.idFournisseur = idFournisseur;
		this.codeFournisseur = codeFournisseur;
		this.libelleFournisseur = libelleFournisseur;
	}
	public long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getCodeFournisseur() {
		return codeFournisseur;
	}
	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}
	public String getLibelleFournisseur() {
		return libelleFournisseur;
	}
	public void setLibelleFournisseur(String libelleFournisseur) {
		this.libelleFournisseur = libelleFournisseur;
	}
	
	
	
	
	
	
	
	
	
}
