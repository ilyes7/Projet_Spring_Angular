package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	public Feedback addReaction(Feedback f);
	public void banAccount();
	

}
