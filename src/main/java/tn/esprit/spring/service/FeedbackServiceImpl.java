package tn.esprit.spring.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import nonapi.io.github.classgraph.scanspec.WhiteBlackList.WhiteBlackListLeafname;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Feedback;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.FeedbackRepository;

@Service	
@Slf4j
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackRepository feedbackRepository;



	@Override

	public List<Feedback> retrieveAllFeedback(long idProduit) {
		List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findAllByIdProduit(idProduit);
		for(Feedback feedback : feedbacks) {

			//log.info("feedback: "+ feedback);
		}
		return feedbacks;
	}

	@Override
	public Feedback addComment(Feedback f) {
		return feedbackRepository.save(f);
	}

	@Override
	public void deleteFeedback(long idFeedback) throws NoSuchElementException{
		feedbackRepository.deleteById(idFeedback);		
	}

	@Override
	public Feedback updateComment(long idFeedback,Feedback f) {
		Feedback f1 = retrieveFeedback(idFeedback);
		f1.setCommentaire(f.getCommentaire());
		return feedbackRepository.save(f1);
	}


	@Override
	public long nbrLikes(long idProduit) {
		long likes = (long) feedbackRepository.nbrLikes(idProduit);
		log.info("Likes: "+ likes);
		return (long) likes;
	}

	@Override
	public long nbrDislikes(long idProduit) {
		long dislikes = (long) feedbackRepository.nbrDislikes(idProduit);
		log.info("dislikes: "+ dislikes);
		return (long) dislikes;
	}

	@Override
	public Feedback updateReaction(Long idFeedback,Feedback f) {
		//System.out.println(feedbackRepository.checkReaction((long) 2,(long) 3));

		Feedback f1 = retrieveFeedback(idFeedback);
		f1.setReaction(f.getReaction());

		//f.setCommentaire(null);
		return feedbackRepository.save(f1);
	}

	@Override

	public Feedback retrieveFeedback(long idFeedback) throws NoSuchElementException{
		Feedback f = feedbackRepository.findById(idFeedback).orElseThrow(() -> new NoSuchElementException(" not found for this id :: " + idFeedback)) ;
		log.info("Feedback: "+ f);
		return f ;		
	}

	@Override
	public Feedback addReaction(@Valid @RequestBody Feedback f, long idProduit, long idUser) {
		
		f.setProduit(new Produit(idProduit));
		f.setClient(new Client(idUser));
		
		return feedbackRepository.save(f);

	}

	@Override
	public void banAccount() {
		feedbackRepository.banAccount();
	}
	
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback addComment(@Valid @RequestBody Feedback c, long idProduit, long idUser) {
		c.setProduit(new Produit(idProduit));
		c.setClient(new Client(idUser));
		return feedbackRepository.save(c);
	}

	@Override
	public List<Feedback> getAllComments(long idProduit) {
		return feedbackRepository.getAllComments(idProduit);
	}





}
