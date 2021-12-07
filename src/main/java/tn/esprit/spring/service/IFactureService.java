package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;

public interface IFactureService {
	List<Facture> retrieveAllFacture();

	Facture addFacture(Facture c) throws ParseException;

	void deleteFacture(Long id);

	Facture updateFacture(Facture c);

	Optional<Facture> retrieveFacture(Long id);
	


}
