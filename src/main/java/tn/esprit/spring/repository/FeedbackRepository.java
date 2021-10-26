package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.entity.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long>{
	
	
	@Query("SELECT f FROM Feedback f WHERE f.produit.idProduit = :idProduit ")
	List<Feedback> findAllByIdProduit(@Param("idProduit") long idProduit);
	
	@Query("SELECT COUNT(f) FROM Feedback f WHERE f.produit.idProduit = :idProduit AND f.liked=1 ")
	long nbrLikes(@Param("idProduit") long idProduit);
	
	@Query("SELECT COUNT(f) FROM Feedback f WHERE f.produit.idProduit = :idProduit AND f.liked=0 ")
	long nbrDislikes(@Param("idProduit") long idProduit);

}
