package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Facture;

import tn.esprit.spring.interfaces.FactureService;
import tn.esprit.spring.repository.FactureRepository;

@Slf4j
@Service
public class FactureServiceImp implements FactureService{
	@Autowired 
	FactureRepository factureRepository;
	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> Factures= (List<Facture>) factureRepository.findAll();
		for (Facture Facture: Factures) {
			//System.out.println("Factures :" + Facture);
			log.info("Factures :" + Facture);
		}
		return Factures;
	}

	@Override
	public void cancelFacture(Long id) {
		factureRepository.deleteById(id);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		Facture facture = factureRepository.findById(id).orElse(null);
		//System.out.println("Facture :" + facture);
		log.info("Factures :" + facture);
		return facture;
	}

}
