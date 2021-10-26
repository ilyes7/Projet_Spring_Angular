package tn.esprit.spring;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entity.Feedback;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.FeedbackRepository;
import tn.esprit.spring.service.FeedbackServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class FeedbackServiceTest {


	private static final Logger l = LogManager.getLogger(FeedbackServiceTest.class);

	@Autowired
	private FeedbackServiceImpl fs;
	
	@Autowired
	FeedbackRepository feedbackRepository ;




	@Test
	void addCommentTest() {
		Client c = new Client((long) 2);
		Feedback f = new Feedback(c,new Produit((long) 2),"test");
		fs.addComment(f);
		l.info(f);
	
	} 
	@Test
	void addLikeTest() {
		Client c = new Client((long) 2);
		Feedback f = new Feedback(c,new Produit((long) 3),true);

		fs.like(f);
		l.info(f);
	} 
	
	
	@Test
	void addDislikeikeTest() {
		Client c = new Client((long) 2);
		Feedback f = new Feedback(c,true,new Produit((long) 3));
		fs.dislike(f);
		l.info(f);
	} 


	@Test
	void nbrLikesTest() {
		long nbrLike=fs.nbrLikes(3);
		l.info(nbrLike);
	}
	
	@Test
	void nbrDislLikesTest() {
		long nbrDislike=fs.nbrDislikes(3);
		l.info(nbrDislike);
	}
	
	@Test 
	void retrieveAllFeedbacksTest() {
				fs.retrieveAllFeedback((long) 3);
	}


	@Test
	void UpdateCommentTest() { 
	
		 Feedback f1 = fs.retrieveFeedback((long) 4); 
		 f1.setCommentaire("updateComm");	  
		 fs.updateComment((long)4 ,f1); 
		 l.info("Feedback: " + f1.toString());
		}

	
	@Test 
	void deleteFeedbackTest() {
	  fs.deleteFeedback((long) 6);
	  l.info("Produit suprime!!");
	}

	


}