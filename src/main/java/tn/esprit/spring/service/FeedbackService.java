package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Feedback;
import tn.esprit.spring.entity.Produit;

public interface FeedbackService {
	
	List<Feedback> retrieveAllFeedback(long idProduit);
	Feedback addComment(Feedback f);
	void deleteFeedback(long idFeedback);
	Feedback updateComment(long idFeedback , Feedback f);
	Feedback like(Feedback f);
	Feedback dislike(Feedback f);
	Feedback retrieveFeedback(long idFeedback);
	long nbrLikes(long idProduit);
	long nbrDislikes(long idProduit);
	

}
