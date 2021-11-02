package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.entity.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long>{
	
	
	@Query("SELECT f  FROM Feedback f WHERE f.produit.idProduit = :idProduit ")
	List<Feedback> findAllByIdProduit(@Param("idProduit") long idProduit);
	
	@Query("SELECT f FROM Feedback f WHERE f.client.idClient = :id AND f.produit.idProduit = :idProduit AND (f.reaction='Like' OR f.reaction='Dislike') ")
	List<Feedback> checkReaction(@Param("id") long id, @Param("idProduit") long idProduit);
	
	@Query("SELECT COUNT(f) FROM Feedback f WHERE f.produit.idProduit = :idProduit AND f.reaction='Like' ")
	long nbrLikes(@Param("idProduit") long idProduit);
	
	@Query("SELECT COUNT(f) FROM Feedback f WHERE f.produit.idProduit = :idProduit AND f.reaction='Dislike' ")
	long nbrDislikes(@Param("idProduit") long idProduit);

	
	

}
