package tn.esprit.spring.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class detailFacture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDetailFacture")
	long idDetailFacture;
	int qte;
	float prixTotal;
	int pourcentageRemise;
	float montantRemis;
	
	
	@OneToOne
	Produit Produit;
	@ManyToOne
	Facture Facture;
	
}
