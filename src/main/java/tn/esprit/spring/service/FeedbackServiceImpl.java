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
import tn.esprit.spring.entity.Feedback;
import tn.esprit.spring.repository.FeedbackRepository;

@Service	
@Slf4j
@RequestMapping("/feedback")
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	FeedbackRepository feedbackRepository;
	


	@Override
	@GetMapping("/display/{idProduit}")
	public List<Feedback> retrieveAllFeedback(@PathVariable(value = "idProduit") long idProduit) {
		List<Feedback> feedbacks = (List<Feedback>) feedbackRepository.findAllByIdProduit(idProduit);
		for(Feedback feedback : feedbacks) {
		
			log.info("feedback: "+ feedback);
		}
		return feedbacks;
	}

	@Override
	@PostMapping("/addComment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback addComment(@Valid @RequestBody Feedback f) {
		return feedbackRepository.save(f);
	}

	@Override
	@DeleteMapping("/delete/{idFeedback}")
	public void deleteFeedback(@PathVariable(value = "idFeedback") long idFeedback) throws NoSuchElementException{
		feedbackRepository.deleteById(idFeedback);		
	}

	@Override
	@PutMapping("/updateComment/{idFeedback}")
	public Feedback updateComment(@PathVariable(value = "idFeedback") long idFeedback, @Valid @RequestBody Feedback f) {
		Feedback f1 = retrieveFeedback(idFeedback);
	    f1.setCommentaire(f.getCommentaire());
		return feedbackRepository.save(f1);
	}


	@Override
	@ResponseBody
	@GetMapping("/nbrLike/{idProduit}")
	public long nbrLikes(@PathVariable(value = "idProduit") long idProduit) {
		long likes = (long) feedbackRepository.nbrLikes(idProduit);
		log.info("Likes: "+ likes);
		return (long) likes;
	}

	@Override
	@ResponseBody
	@GetMapping("/nbrDislike/{idProduit}")
	public long nbrDislikes(@PathVariable(value = "idProduit") long idProduit) {
		long dislikes = (long) feedbackRepository.nbrDislikes(idProduit);
		log.info("dislikes: "+ dislikes);
		return (long) dislikes;
	}
	
	@Override
	@PostMapping("/updateReaction/{idFeedback}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback updateReaction(@PathVariable(value = "idFeedback") Long idFeedback, @Valid @RequestBody Feedback f) {
		//System.out.println(feedbackRepository.checkReaction((long) 2,(long) 3));
		
			Feedback f1 = retrieveFeedback(idFeedback);
			f1.setReaction(f.getReaction());

			//f.setCommentaire(null);
			return feedbackRepository.save(f1);
		}

	@Override
	@GetMapping("/retrive/{idFeedback}")
	public Feedback retrieveFeedback(@PathVariable(value = "idFeedback") long idFeedback) throws NoSuchElementException{
		Feedback f = feedbackRepository.findById(idFeedback).orElseThrow(() -> new NoSuchElementException(" not found for this id :: " + idFeedback)) ;
		log.info("Feedback: "+ f);
		return f ;		
	}
	
	@Override
	@ResponseBody
	@PostMapping("/addReaction")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback addReaction(@Valid @RequestBody Feedback f) {
		
			return feedbackRepository.save(f);

	}

}
