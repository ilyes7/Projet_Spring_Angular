package tn.esprit.spring.interfaces;

import java.util.List;

import tn.esprit.spring.entity.Facture;

public interface FactureService {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);

}
