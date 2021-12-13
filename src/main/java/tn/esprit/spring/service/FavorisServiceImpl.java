package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Favoris;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.FavorisRepository;

@Service
public class FavorisServiceImpl implements FavorisService{
	
	@Autowired
	FavorisRepository favorisRepository;

	@Override
	public List<Produit> retriveAllFav(long idClient) {
		return favorisRepository.retriveAllFav(idClient);
	}

	@Override
	public Favoris addFav(Favoris f, long idProduit, long idUser) {
		f.setProduit(new Produit(idProduit));
		f.setClient(new Client(idUser));
		return favorisRepository.save(f);
	}

	@Override
	public void deleteFav(long idFavoris) {
		favorisRepository.deleteById(idFavoris);
		
	}
	
	@Override
	public Favoris findByIdProduitIdUser(long idProduit, long idUser) {
		
		return favorisRepository.findByIdProduitIdUser(idProduit, idUser);
	}





}
