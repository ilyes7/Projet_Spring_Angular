package tn.esprit.spring.entity;



import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.spring.enumerate.CategorieClient;
import tn.esprit.spring.enumerate.Profession;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Facture")
public class Facture implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture;
	@Column(name="montantRemise")
	private float montantRemise;
	@Column(name="montantFacture")
	private float montantFacture;
	@Column(name="dateFacture")
	//@Temporal(TemporalType.DATE)
	private LocalDateTime dateFacture;
	@Column(name="active")
	private boolean active ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	@JsonIgnore
	private List<DetailFacture> detailFactures;
	
	@ManyToOne
	Client client ;
	@ManyToOne
	Coupon coupon ;
	
	
	/*public Facture(Long idFacture, float montantRemise, float montantFacture, LocalDateTime dateFacture, boolean active) {
		super();
		this.idFacture = idFacture;
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
	}
	public Facture(float montantRemise, float montantFacture, LocalDateTime dateFacture, boolean active) {
		super();
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
	}*/
	/*public Facture() {
		super();
	}
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public float getMontantRemise() {
		return montantRemise;
	}
	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}
	public float getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(float montantFacture) {
		this.montantFacture = montantFacture;
	}
	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}*/
	
	
	

}
