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

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Produit")
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduit")
	@ApiModelProperty(value = "idProduit")
	private Long idProduit;
	@Column(name = "code")
	@ApiModelProperty(value = "code")
	private String code;
	@Column(name = "libelle")
	@ApiModelProperty(value = "libelle")
	private String libelle;
	@Column(name = "prixUnitaire")
	@ApiModelProperty(value = "prixUnitaire")
	private float prixUnitaire;
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "categorieProduit")
	private CategorieProduit categorieProduit;
	@Column(name = "dateCreation")
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "dateCreation")
	private Date dateCreation;
	private String picture;

	@JsonIgnore
	@ManyToOne
	@ToString.Exclude
	Stock stock;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Fournisseur> fournissuers;
	@JsonIgnore
	@ManyToOne
	@ToString.Exclude
	Rayon rayon;
	@JsonIgnore
	@ToString.Exclude
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Set<DetailFacture> detailfactures;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
	@ToString.Exclude
	private Set<Feedback> listFeedback;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
	private List<Favoris> favoris;

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