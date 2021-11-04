package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.service.ProduitServiceImpl;


@RestController
@RequestMapping("/produit")
public class ProduitRestController {
	
	@Autowired
	ProduitServiceImpl ps ;

	
	 @GetMapping("/display")
	public List<Produit> retrieveAllProductsC() {
		List<Produit> produits = ps.retrieveAllProducts();
		return produits ;
		
	}

	@PostMapping("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Produit addProduitC(@Valid @RequestBody Produit p) {
		Produit p1 = ps.addProduit(p);
		return p1;
	}


	@DeleteMapping("/delete/{idProduit}")
	public void deleteProduitC(@PathVariable(value = "idProduit") Long idProduit) throws NoSuchElementException {
		ps.deleteProduit(idProduit);
	}

	
	@PutMapping("/update/{id}")
	public Produit updateProduitC(@PathVariable(value = "id") Long id, @Valid @RequestBody Produit p) {
		Produit p1 = ps.updateProduit(id, p);
		return p1;
	}


	@GetMapping("/retrive/{id}")
	public Produit retrieveProduitC(@PathVariable(value = "id") Long id) throws NoSuchElementException{
		Produit p = ps.retrieveProduit(id);
		return p ;
	}

}
