package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.Feedback;
import tn.esprit.spring.entity.Produit;

public interface FeedbackService {
	
	List<Feedback> retrieveAllFeedback(long idProduit);
	Feedback addComment(Feedback f);
	void deleteFeedback(long idFeedback);
	Feedback updateComment(long idFeedback , Feedback f);
	Feedback retrieveFeedback(long idFeedback);
	long nbrLikes(long idProduit);
	long nbrDislikes(long idProduit);
	public Feedback updateReaction(Long idFeedback,  Feedback f);
	Feedback addReaction(Feedback f, long idProduit, long idUser);
	public void banAccount();
	List<Feedback> getAllComments( long idProduit);
	public Feedback addComment(Feedback c, long idProduit, long idUser);
	

}
