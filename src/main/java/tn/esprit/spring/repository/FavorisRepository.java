package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Favoris;
import tn.esprit.spring.entity.Produit;

@Repository
public interface FavorisRepository extends CrudRepository<Favoris, Long>{
	
	@Query(value="SELECT f.id_favoris, p.id_produit, p.categorie_produit, p.code ,p.libelle , p.prix_unitaire ,p.picture, p.date_creation "
			+ "FROM produit p INNER JOIN favoris f ON f.produit_id_produit=p.id_produit "
			+ "INNER JOIN client c ON f.client_id_client=c.id_client WHERE f.client_id_client=:idClient",nativeQuery = true)
	List retriveAllFav(long idClient);
	
	@Query(value="SELECT * FROM favoris f WHERE f.produit_id_produit=:idProduit AND f.client_id_client=:idUser",nativeQuery = true)
		Favoris findByIdProduitIdUser(long idProduit,long idUser);
	
	
	
	

}
