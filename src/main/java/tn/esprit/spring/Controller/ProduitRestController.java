package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Produit;
import tn.esprit.spring.service.IProduitService;

@RestController
@RequestMapping("/produit")
public class ProduitRestController {
	@Autowired
	IProduitService produitService;

	// http://localhost:8081/SpringMVC/servlet/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	public List<Produit> getProduits() {
		List<Produit> listProduits = produitService.retrieveAllProduit();
		return listProduits;
	}

	// http://localhost:8081/SpringMVC/servlet/produit/retrieve-produit/1
	@GetMapping("/retrieve-produit/{produit-id}")

	public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	// http://localhost:8081/SpringMVC/servlet/produit/add-produit
	@PostMapping("/add-produit")

	public Produit addProduit(@RequestBody Produit p)
	{
		Produit produit = produitService.addProduit(p,p.getRayon().getIdRayon(),p.getStock().getIdStock());
		return produit;
	}

	// http://localhost:8081/SpringMVC/servlet/produit/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{produit-id}")

	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	// http://localhost:8081/SpringMVC/servlet/produit/modify-produit
	@PutMapping("/modify-produit")
	public Produit modifyProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}

}
