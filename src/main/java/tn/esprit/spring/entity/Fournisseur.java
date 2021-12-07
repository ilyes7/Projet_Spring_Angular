package tn.esprit.spring.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Fournisseur")
public class Fournisseur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "idFournisseur")
	 private Long idFournisseur ;
	 @Column(name = "code",unique =true)
	 private String code;
	 @Column(name = "libelle")
	 private String libelle;
	 @Column(name="email")
	 private String email;
	 
	public Fournisseur(Long idFournisseur, String code, String libelle) {
		super();
		this.idFournisseur = idFournisseur;
		this.code = code;
		this.libelle = libelle;
	}
	public Fournisseur(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	/*public Fournisseur() {
		super();
	}
	public Long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
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