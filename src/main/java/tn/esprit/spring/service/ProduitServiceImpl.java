package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.enumerate.CategorieProduit;
import tn.esprit.spring.repository.ProduitRepository;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<Produit> retrieveAllProducts() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		for (Produit produit : produits) {

			log.info("produit: " + produit);
		}
		return produits;
	}

	@Override
	public Produit addProduit(Produit p) {

		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Long idProduit) throws NoSuchElementException {
		produitRepository.deleteById(idProduit);
	}
	
	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}  

	@Override
	public Produit retrieveProduit(Long id) throws NoSuchElementException {
		Produit p = produitRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Produit not found for this id :: " + id));
		return p;
	}

	@Override
	public List statCategProd() {
		// System.out.println(produitRepository.statCategorieProduit());
		return produitRepository.statCategorieProduit();
	}

	@Override
	public List bestSeller() {
		return produitRepository.bestSeller();
	}

	@Override
	public List mostLiked() {
		return produitRepository.mostLiked();
	}

	@Override
	public long nombreProducts() {
		return produitRepository.count();
	}

}
