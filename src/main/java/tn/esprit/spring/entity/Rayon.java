package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.spring.enumerate.CategorieClient;
import tn.esprit.spring.enumerate.Profession;
@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="Rayon")
public class Rayon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRayon")
	private Long idRayon;
	@Column(name = "code")
	private String code;
	@Column(name = "libelle")
	private String libelle;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private List<Produit> produits;
	
	public Rayon(Long idRayon, String code, String libelle) {
		super();
		this.idRayon = idRayon;
		this.code = code;
		this.libelle = libelle;
	}
	public Rayon(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	/*public Rayon() {
		super();
	}
	public Long getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(Long idRayon) {
		this.idRayon = idRayon;
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
	}*/
	

}