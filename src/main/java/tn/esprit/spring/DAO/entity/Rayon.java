package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table( name = "Rayon")
public class Rayon implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private Long idRayon;
	private String codeRayon;
	private String libelleRayon;


	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> produit;


	public Long getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(Long idRayon) {
		this.idRayon = idRayon;
	}
	public String getCodeRayon() {
		return codeRayon;
	}
	public void setCodeRayon(String codeRayon) {
		this.codeRayon = codeRayon;
	}
	public String getLibelleRayon() {
		return libelleRayon;
	}
	public void setLibelleRayon(String libelleRayon) {
		this.libelleRayon = libelleRayon;
	}
	public Rayon(Long idRayon, String codeRayon, String libelleRayon) {
		super();
		this.idRayon = idRayon;
		this.codeRayon = codeRayon;
		this.libelleRayon = libelleRayon;
	}
	public Rayon() {
		super();

	}


}