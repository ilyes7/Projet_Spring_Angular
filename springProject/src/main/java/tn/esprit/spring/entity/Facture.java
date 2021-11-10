package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Facture {@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
long idFacture;
float montantRemise;
float montantFacture;
@Temporal (TemporalType.DATE)
Date dateFacture;
Boolean active;


@OneToMany(mappedBy="Facture")
private Set<detailFacture> DetailFactures;;;;
@ManyToOne
Client Client;

}
