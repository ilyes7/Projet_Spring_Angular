package tn.esprit.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.enumerate.CategorieProduit;

public interface ProduitRepository extends CrudRepository<Produit, Long>{
	
	@Query("SELECT COUNT(p) , p.categorieProduit FROM Produit p GROUP BY p.categorieProduit ")
	List statCategorieProduit();
	
	@Query(value = "SELECT SUM(df.qte) as somme ,"
			+ "p.id_produit , p.categorie_produit , p.code , p.date_creation , p.libelle ,"
			+ "p.prix_unitaire, p.picture FROM detail_facture df "
			+ "INNER JOIN detail_facture_produits dfp ON df.id_detail_facture=dfp.detail_facture_id_detail_facture "
			+ "INNER JOIN produit p ON dfp.produits_id_produit = p.id_produit "
			+ "INNER JOIN facture f ON (f.id_facture=df.facture_id_facture) "
			+ "AND f.date_facture=DATE(NOW()) "
			+ "GROUP BY dfp.produits_id_produit "
			+ "ORDER BY somme DESC LIMIT 3 ", nativeQuery = true)
	List bestSeller();
	
	@Query(value = "SELECT COUNT(*) AS nbrLikes , p.id_produit , p.categorie_produit , p.code ,"
			+ " p.date_creation , p.libelle , p.prix_unitaire, p.picture "
			+ "FROM Feedback f JOIN produit p ON f.produit_id_produit = p.id_produit "
			+ "AND f.reaction='Like' GROUP BY f.produit_id_produit ORDER BY nbrLikes DESC LIMIT 3 " , nativeQuery = true)
	List mostLiked();
	
	@Query(value = "SELECT COUNT(*) FROM produit " , nativeQuery = true)
	long nombreProducts();

}
// ../../../assets/img/products/2.jpg
