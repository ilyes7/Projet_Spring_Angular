package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.enumerate.CategorieProduit;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.service.ProduitServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProduitServiceImplTests {
	

	
	
	@Mock
	ProduitRepository produitRepository;
	
    @InjectMocks
	private ProduitServiceImpl ps;
	
	@Test
	void addProduitTest() {
	
		Produit p = new Produit(50L ,"code","libelle",70,CategorieProduit.Alimentaire);
		Mockito.when(produitRepository.save(p)).thenReturn(p);
		Produit p1 = ps.addProduit(p);
		assertThat(p).isEqualTo(p1);
	} 
	
	@Test
	void retreiveAllProduitsTest() {
		List<Produit> produits = new ArrayList<>();
		produits.add(new Produit());
		produits.add(new Produit());
		produits.add(new Produit());
		Mockito.when(produitRepository.findAll()).thenReturn(produits);
		List<Produit> expected = ps.retrieveAllProducts();
	//	System.out.println(produits.size());
		assertEquals(expected, produits);
		assertEquals(3, produits.size());	
	}
	
	@Test
	void retreiveProduitTest() {
		Produit p = new Produit();
		p.setIdProduit((long)55);
		p.setCategorieProduit(CategorieProduit.Alimentaire);
		p.setCode("code");
		p.setLibelle("libelle");
		p.setPrixUnitaire(50);
		Mockito.when(produitRepository.findById(p.getIdProduit())).thenReturn(Optional.of(p));
		Produit p1 = ps.retrieveProduit(p.getIdProduit());
	//	System.out.println(p);
		assertThat(p1.getCode()).isEqualTo(p.getCode());
		assertThat(p1.getCategorieProduit()).isEqualTo(p.getCategorieProduit());
		assertThat(p1.getIdProduit()).isEqualTo(p.getIdProduit());
		assertThat(p1.getPrixUnitaire()).isEqualTo(p.getPrixUnitaire());
		assertThat(p1.getLibelle()).isEqualTo(p.getLibelle());	
	}
	
	@Test
	void UpdateProduitTest() {
		Produit p = new Produit();
		p.setIdProduit((long)55);
		p.setCategorieProduit(CategorieProduit.Alimentaire);
		p.setCode("code");
		p.setLibelle("libelle");
		p.setPrixUnitaire(50);
		Produit newp = new Produit();
		newp.setIdProduit(p.getIdProduit());
		newp.setCategorieProduit(CategorieProduit.Electromenager);
		newp.setLibelle("newlibelle");
		newp.setPrixUnitaire(100);
		newp.setCode("newCode");
		Mockito.when(produitRepository.findById(p.getIdProduit())).thenReturn(Optional.of(p));
		ps.updateProduit(newp);
		//System.out.println(newp);
		//System.out.println(p);
		assertThat(newp.getCode()).isEqualTo(p.getCode());
		assertThat(newp.getCategorieProduit()).isEqualTo(p.getCategorieProduit());
		assertThat(newp.getIdProduit()).isEqualTo(p.getIdProduit());
		assertThat(newp.getPrixUnitaire()).isEqualTo(p.getPrixUnitaire());
		assertThat(newp.getLibelle()).isEqualTo(p.getLibelle());
	}
	
	
	@Test
	void deleteProduitTest() {
		Produit p = new Produit();
		p.setIdProduit((long)55);
		p.setCategorieProduit(CategorieProduit.Alimentaire);
		p.setCode("code");
		p.setLibelle("libelle");
		p.setPrixUnitaire(50);
		Mockito.when(produitRepository.findById(p.getIdProduit())).thenReturn(null);
		ps.deleteProduit(p.getIdProduit());
		System.out.println(p);
		assertThat(produitRepository.findById(p.getIdProduit())).isEqualTo(null);
	}

}
