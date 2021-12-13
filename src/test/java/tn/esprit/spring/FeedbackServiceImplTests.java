package tn.esprit.spring;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Feedback;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.FeedbackRepository;
import tn.esprit.spring.service.FeedbackServiceImpl;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class FeedbackServiceImplTests {

	
	@InjectMocks
	private FeedbackServiceImpl fs;
	
	@Mock
	FeedbackRepository feedbackRepository ;




	@Test
	void addCommentTest() {
		Feedback f = new Feedback(new Client((long) 1),new Produit((long) 2),"test");
		Mockito.when(feedbackRepository.save(f)).thenReturn(f);
		Feedback f1 = fs.addComment(f);
		assertThat(f).isEqualTo(f1);
		log.info(f1.toString());
	} 

	
	
	@Test 
	void deleteFeedbackTest() {
		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setCommentaire("cmnt");
		f.setReaction("like");
		f.setProduit(new Produit(50L));
		f.setClient(new Client(50L));
		Mockito.when(feedbackRepository.findById(f.getIdFeedback())).thenReturn(null);
        fs.deleteFeedback(f.getIdFeedback());
        assertThat(feedbackRepository.findById(f.getIdFeedback())).isEqualTo(null);
	  log.info("Produit suprime!!");
	}
	

	@Test
	void nbrLikesTest() {
		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setReaction("Like");
		f.setProduit(new Produit(50L));
		f.setClient(new Client(50L));
		
		Feedback f1 = new Feedback();
		f1.setIdFeedback(50L);
		f1.setReaction("Like");
		f1.setProduit(new Produit(50L));
		f1.setClient(new Client(51L));
		Mockito.when(feedbackRepository.nbrLikes(f.getProduit().getIdProduit())).thenReturn(2L);
		long nbrLike = fs.nbrLikes(f.getProduit().getIdProduit());
		assertThat(feedbackRepository.nbrLikes(f.getProduit().getIdProduit())).isEqualTo(nbrLike);
		log.info(""+nbrLike);
	}
	
	@Test
	void nbrDislLikesTest() {
		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setReaction("Dislike");
		f.setProduit(new Produit(50L));
		f.setClient(new Client(50L));
		
		Feedback f1 = new Feedback();
		f1.setIdFeedback(50L);
		f1.setReaction("Dislike");
		f1.setProduit(new Produit(50L));
		f1.setClient(new Client(51L));
		Mockito.when(feedbackRepository.nbrDislikes(f.getProduit().getIdProduit())).thenReturn(2L);
		long nbrDislike = fs.nbrDislikes(f.getProduit().getIdProduit());
		log.info(""+nbrDislike);
	}
	
	@Test 
	void retrieveAllFeedbacksTest() {
				//fs.retrieveAllFeedback((long) 1);
		List<Feedback> feedbacks = new ArrayList<>();
		feedbacks.add(new Feedback(new Produit(50L)));
		feedbacks.add(new Feedback(new Produit(50L)));
		feedbacks.add(new Feedback(new Produit(50L)));
		feedbacks.add(new Feedback(new Produit(51L)));
		
		List<Feedback> subFeedbacks = feedbacks.subList(0, 3);
		System.out.println(subFeedbacks.size());
		Mockito.when(feedbackRepository.findAllByIdProduit(50L)).thenReturn(subFeedbacks);
		List<Feedback> expected = fs.retrieveAllFeedback(50);
		assertEquals(expected, subFeedbacks);
		assertEquals(3, subFeedbacks.size());
	}


	@Test
	void UpdateCommentTest() { 
		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setCommentaire("comment");;
		f.setProduit(new Produit(50L));
		f.setClient(new Client(50L));
		
		Feedback newf = new Feedback();
		newf.setIdFeedback(f.getIdFeedback());
		newf.setCommentaire("NEWcomment");;
		newf.setProduit(new Produit(50L));
		newf.setClient(new Client(50L));
		Mockito.when(feedbackRepository.findById(f.getIdFeedback())).thenReturn(Optional.of(f)); 
		 fs.updateComment(f.getIdFeedback() ,newf); 
		 assertEquals(f.getIdFeedback(), newf.getIdFeedback());
		 assertEquals(f.getCommentaire(), newf.getCommentaire());
		 assertEquals(f.getProduit().getIdProduit(), newf.getProduit().getIdProduit());
		 assertEquals(f.getClient().getIdClient(), newf.getClient().getIdClient());
		 
		 log.info("Updated Feedback: " + newf.toString());
		}
	
	
	@Test
	void addReactionTest() throws NoSuchElementException {
	
		Feedback f = new Feedback();
		f.setIdFeedback(50L);
		f.setReaction("Like");
		f.setProduit(new Produit(50L));
		f.setClient(new Client(50L));
		
		List<Feedback> list = new ArrayList<>();
		list.add(f);
		List<Feedback> fergha = new ArrayList<>();
		Mockito.when(feedbackRepository.checkReaction((long) 50,(long) 50)).thenReturn(fergha);
		if((feedbackRepository.checkReaction((long) 50,(long) 50)).isEmpty()) {
			System.out.println("if");
			
			 Mockito.when(feedbackRepository.save(f)).thenReturn(f) ;
			// Feedback f1 = fs.addReaction(f);
			// assertThat(f).isEqualTo(f1);
			 
			log.info(f.toString());
			
		}else {
			System.out.println("else");
			Feedback newf = new Feedback();
			newf.setIdFeedback(f.getIdFeedback());
			newf.setReaction("Dislike");
			newf.setProduit(new Produit(50L));
			newf.setClient(new Client(50L));
			Mockito.when(feedbackRepository.findById(f.getIdFeedback())).thenReturn(Optional.of(f)); 
			fs.updateReaction(f.getIdFeedback() ,newf);
			assertEquals(f.getIdFeedback(), newf.getIdFeedback());
			 assertEquals(f.getReaction(), newf.getReaction());
			 assertEquals(f.getProduit().getIdProduit(), newf.getProduit().getIdProduit());
			 assertEquals(f.getClient().getIdClient(), newf.getClient().getIdClient());
			
			log.info(newf.toString());
		}
	
	}

	
	

	


}