package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.enumerate.CategorieProduit;

public interface ProduitService {
	
	List<Produit> retrieveAllProducts();

	Produit addProduit(Produit p);

	void deleteProduit(Long id);

	Produit updateProduit(Produit p);

	Produit retrieveProduit(Long id);
	
	List statCategProd();
	
	List bestSeller();
	
	List mostLiked();

}
