package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Query(value="SELECT *  FROM Feedback f WHERE f.produit_id_produit = :idProduit AND commentaire IS NOT NULL",
			nativeQuery = true)
	List<Feedback> getAllComments(@Param("idProduit") long idProduit);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE client SET categorieclient = 'Blocked' WHERE id_client IN (SELECT client_id_client FROM `feedback` WHERE (commentaire LIKE \\\"%ban%\\\") OR (commentaire LIKE \\\"%ban1\\\"))" , nativeQuery = true)
	void banAccount();
	
	

}
