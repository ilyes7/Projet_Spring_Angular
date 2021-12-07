package tn.esprit.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.enumerate.CategorieProduit;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.service.ProduitServiceImpl;


@RestController
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {
	
	@Autowired
	ProduitServiceImpl ps ;

	
	 @GetMapping("/display")
	 @ApiOperation(value = "Recuperer la liste des produits")
	public List<Produit> retrieveAllProductsC() {
		List<Produit> produits = ps.retrieveAllProducts();
		return produits ;
		
	}

	@PostMapping("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	 @ApiOperation(value = "Ajouter un produit")
	public Produit addProduitC(@Valid @RequestBody Produit p) {
		Produit p1 = ps.addProduit(p);
		return p1;
	}


	@DeleteMapping("/delete/{idProduit}")
	 @ApiOperation(value = "Supprimer un produit")
	public void deleteProduitC(@PathVariable(value = "idProduit") Long idProduit) throws NoSuchElementException {
		ps.deleteProduit(idProduit);
	}

	
	  @PutMapping("/update")
	  @ApiOperation(value = "Modifier un produit")
	public Produit updateProduitC(@Valid @RequestBody Produit p) {
		Produit p1 = ps.updateProduit(p);
		return p1;
	} 


	@GetMapping("/retrive/{id}")
	 @ApiOperation(value = "Recuperer un produit")
	public Produit retrieveProduitC(@PathVariable(value = "id") Long id) throws NoSuchElementException{
		Produit p = ps.retrieveProduit(id);
		return p ;
	}
	
	@GetMapping("/stat")
	 @ApiOperation(value = "Nombre des produits par categorie")
	public List statCategProdC() {
		return ps.statCategProd();
	}
	
	@GetMapping("/bestSeller")
	 @ApiOperation(value = "Le produit le plus vendu du jour")
	public List bestSellerC() {
		return ps.bestSeller();
	}
	
	@GetMapping("/mostLiked")
	 @ApiOperation(value = "The most liked product")
	public List mostLikedC() {
		return ps.mostLiked();
	}


}
