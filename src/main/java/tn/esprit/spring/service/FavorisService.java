package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Favoris;
import tn.esprit.spring.entity.Produit;

public interface FavorisService {
	
	List<Produit> retriveAllFav(long idClient);
	Favoris addFav(Favoris f, long idProduit, long idClient);
	void deleteFav(long idFavoris);
	public Favoris findByIdProduitIdUser(long idProduit, long idUser);

}
