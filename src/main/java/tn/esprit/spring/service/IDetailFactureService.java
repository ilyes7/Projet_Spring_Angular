package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Produit;


public interface IDetailFactureService {
	
	List<DetailFacture> retrieveAllDetailFacture();

	DetailFacture addDetailFacture(DetailFacture c , Facture f , Produit p) throws ParseException;

	void deleteDetailFacture(Long id);

	DetailFacture updateDetailFacture(DetailFacture c);

	Optional<DetailFacture> retrieveDetailFacture(Long id);
	
	Produit getProduitDetailFacture(Long idDetailFacture);


}
