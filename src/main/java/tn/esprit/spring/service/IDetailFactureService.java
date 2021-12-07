package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;


public interface IDetailFactureService {
	
	List<DetailFacture> retrieveAllDetailFacture();

	DetailFacture addDetailFacture(DetailFacture c , Facture f) throws ParseException;

	void deleteDetailFacture(Long id);

	DetailFacture updateDetailFacture(DetailFacture c);

	Optional<DetailFacture> retrieveDetailFacture(Long id);


}
