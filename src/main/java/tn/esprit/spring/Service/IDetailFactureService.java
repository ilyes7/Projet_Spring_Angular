package tn.esprit.spring.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.DetailFacture;


public interface IDetailFactureService {
	
	List<DetailFacture> retrieveAllDetailFacture();

	DetailFacture addDetailFacture(DetailFacture c) throws ParseException;

	void deleteDetailFacture(Long id);

	DetailFacture updateDetailFacture(DetailFacture c);

	Optional<DetailFacture> retrieveDetailFacture(Long id);


}
