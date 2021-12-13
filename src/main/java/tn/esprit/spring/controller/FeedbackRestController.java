package tn.esprit.spring.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Feedback;
import tn.esprit.spring.service.FeedbackServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/feedback")
@RestController
public class FeedbackRestController {
	
	@Autowired
	FeedbackServiceImpl fs ;
	
	@GetMapping("/display/{idProduit}")
	public List<Feedback> retrieveAllFeedbackC(@PathVariable(value = "idProduit") long idProduit) {
		List<Feedback> feedbacks = fs.retrieveAllFeedback(idProduit);
		return feedbacks;
	}


	@PostMapping("/addComment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback addCommentC(@Valid @RequestBody Feedback f) {
		
		Feedback f1 = fs.addComment(f);
		return f1;
	}


	@DeleteMapping("/delete/{idFeedback}")
	public void deleteFeedbackC(@PathVariable(value = "idFeedback") long idFeedback) throws NoSuchElementException{
		fs.deleteFeedback(idFeedback);
		System.out.println("Feedback deleted");
	}


	@PutMapping("/updateComment/{idFeedback}")
	public Feedback updateCommentC(@PathVariable(value = "idFeedback") long idFeedback, @Valid @RequestBody Feedback f) {
		Feedback f1 = fs.updateComment(idFeedback, f);
		return f1;
	}



	@GetMapping("/nbrLike/{idProduit}")
	public long nbrLikesC(@PathVariable(value = "idProduit") long idProduit) {
		long likes = fs.nbrLikes(idProduit);
		return likes;
	}


	@GetMapping("/nbrDislike/{idProduit}")
	public long nbrDislikesC(@PathVariable(value = "idProduit") long idProduit) {
		long dislikes = fs.nbrDislikes(idProduit);
		return dislikes;
	}
	

	@PutMapping("/updateReaction/{idFeedback}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback updateReactionC(@PathVariable(value = "idFeedback") Long idFeedback, @Valid @RequestBody Feedback f) {	
			Feedback f1 = fs.updateReaction(idFeedback, f);
			return f1;
		}


	@GetMapping("/retrive/{idFeedback}")
	public Feedback retrieveFeedbackC(@PathVariable(value = "idFeedback") long idFeedback) throws NoSuchElementException{
		Feedback f = fs.retrieveFeedback(idFeedback);
		return f ;		
	}

	@PostMapping("/addReaction/{idProduit}/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback addReactions(@Valid @RequestBody Feedback f,@PathVariable(value = "idProduit") long idProduit,@PathVariable(value = "idUser") long idUser) {
		Feedback f1 = fs.addReaction(f,idProduit,idUser);
		return f1;

	}
	
	@PutMapping("/ban")
	public void banAccountC() {
		fs.banAccount();
	}
	
	@GetMapping("comments/{idProduit}")
	public List<Feedback> retreiveComments(@PathVariable(value = "idProduit") Long idProduit) {

		return fs.getAllComments(idProduit);
	}
	
	@PostMapping("/addComment/{idProduit}/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Feedback addCommentire(@Valid @RequestBody Feedback f,@PathVariable(value = "idProduit") long idProduit,@PathVariable(value = "idUser") long idUser) {
		Feedback f1 = fs.addComment(f,idProduit,idUser);
		return f1;
	}

}
