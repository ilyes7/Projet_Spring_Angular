package tn.esprit.spring.entity;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class DetailProduit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDetailProduit")
	long idDetailProduit;
	@Temporal (TemporalType.DATE)
	Date dateCreation;
	String dateDerniereModification;  
	CategorieProduit categorieProduit;
	
		
	@OneToOne(mappedBy="DetailProduit")
	private Produit Produit ;
}
