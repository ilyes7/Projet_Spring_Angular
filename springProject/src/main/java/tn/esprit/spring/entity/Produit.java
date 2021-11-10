package tn.esprit.spring.entity;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 long idProduit;
 String code;
 String libelle;
 float prixUnitaire;

 
@ManyToOne
Stock stock;
@OneToOne
DetailProduit DetailProduit;
@ManyToOne
Rayon Rayon ;
@ManyToMany
private Set<Fournisseur> Fournisseurs;
@OneToMany(mappedBy="Produit")
private Set<detailFacture> DetailFacture;
}
