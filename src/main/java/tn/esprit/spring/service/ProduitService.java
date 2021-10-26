package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Produit;

public interface ProduitService {
	
	List<Produit> retrieveAllProducts();

	Produit addProduit(Produit p);

	void deleteProduit(Long id);

	Produit updateProduit(Long id ,Produit p);

	Produit retrieveProduit(Long id);

}
