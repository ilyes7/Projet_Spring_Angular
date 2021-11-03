package tn.esprit.spring.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Facture;


@RestController
@RequestMapping(value = "/facture")
@Service
public class FactureServiceImpl implements IFactureService {

	@Override
	public List<Facture> retrieveAllFacture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture addFacture(Facture c) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFacture(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Facture updateFacture(Facture c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Facture> retrieveFacture(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
