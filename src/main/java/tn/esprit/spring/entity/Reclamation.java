package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Reclamation")
public class Reclamation implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReclamation")
	private Long idReclamation;
	@Column(name="objet")
	private String objet; 
	@Column(name="description")
	private String description;
	@ManyToOne
	Client client;
	
	public Reclamation() {
		super();
	}
	public Reclamation(Long idReclamation, String objet, String description) {
		super();
		this.idReclamation = idReclamation;
		this.objet = objet;
		this.description = description;
	}
	public Long getIdReclamation() {
		return idReclamation;
	}
	public void setIdReclamation(Long idReclamation) {
		this.idReclamation = idReclamation;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}