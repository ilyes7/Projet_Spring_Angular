package tn.esprit.spring.service;

import java.util.List;
import java.util.NoSuchElementException;

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

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ProduitRepository;


@Service	
@Slf4j
@RequestMapping("/produit")
public class ProduitServiceImpl implements ProduitService{

	
	@Autowired
	ProduitRepository produitRepository;
	
	
	
	@Override
	 @GetMapping("/display")
	public List<Produit> retrieveAllProducts() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		for(Produit produit : produits) {
		
			log.info("produit: "+ produit);
		}
		return produits;
	}

	@Override
	@PostMapping("/addComment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Produit addProduit(@Valid @RequestBody Produit p) {
		
		return produitRepository.save(p);
	}

	@Override
	@DeleteMapping("/delete/{idProduit}")
	public void deleteProduit(@PathVariable(value = "idProduit") Long idProduit) throws NoSuchElementException {
    	produitRepository.deleteById(idProduit);
	}

	@Override
	@PutMapping("/update/{id}")
	public Produit updateProduit(@PathVariable(value = "id") Long id, @Valid @RequestBody Produit p) {
		Produit p1 = retrieveProduit(id);
		
		p1.setCode(p.getCode()); 
    	p1.setLibelle(p.getLibelle());
    	p1.setPrixUnitaire(p.getPrixUnitaire());
    	p1.setCategorieProduit(p.getCategorieProduit());
		
		return produitRepository.save(p1);
	}

	@Override
	@GetMapping("/retrive/{id}")
	public Produit retrieveProduit(@PathVariable(value = "id") Long id) throws NoSuchElementException{
		Produit p = produitRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produit not found for this id :: " + id));
		return p ;
	}

}
