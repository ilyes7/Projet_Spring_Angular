package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Produit;

import tn.esprit.spring.interfaces.ProduitService;
import tn.esprit.spring.repository.ProduitRepository;
@Slf4j
@Service
public class ProduitServiceImp implements ProduitService {
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> Produits= (List<Produit>) produitRepository.findAll();
		for (Produit Produit: Produits) {
			//System.out.println("Produit :" + Produit);
			log.info("Produit :" + Produit);
		}
		return Produits;
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		
		return produitRepository.addProduit(p.getCode(), p.getLibelle(), p.getPrixUnitaire(), idRayon, idStock);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		Produit produit = produitRepository.findById(id).orElse(null);
		//System.out.println("produit :" +produit);
		log.info("Produit :" + produit);
		return produit; 
	}

}
