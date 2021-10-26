package tn.esprit.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.enumerate.CategorieProduit;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.service.ProduitServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTests {
	
	private static final Logger l = LogManager.getLogger(ProduitServiceImplTests.class);
	
	@Autowired
	private ProduitServiceImpl ps;
	@Autowired
	ProduitRepository produitRepository;
	
	@Test
	void addProduitTest() {
			
		
			
	
		Produit p = new Produit("code","libelle",70,CategorieProduit.Alimentaire);
		
		//clientRepository.save(c);
		ps.addProduit(p);
		l.info(p);
	} 
	
	@Test
	void retreiveAllProduitsTest() {
		
		ps.retrieveAllProducts();
		
	}
	
	@Test
	void retreiveProduitTest() {
		ps.retrieveProduit((long) 1);
		
	}
	
	@Test
	void UpdateProduitTest() {
		Produit p1 = ps.retrieveProduit((long) 1);
		p1.setCode("code"); 
    	p1.setLibelle("libelle");
    	p1.setPrixUnitaire(70);
    	p1.setCategorieProduit(CategorieProduit.Quincaillerie);
		ps.updateProduit((long)1 ,p1);
		l.info("Produit: " + p1.toString());
	}
	
	@Test
	void deleteProduitTest() {
		ps.deleteProduit((long) 4);
		l.info("Produit suprime!!");
	}

}
