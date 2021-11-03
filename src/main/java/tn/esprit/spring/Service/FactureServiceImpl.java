package tn.esprit.spring.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;



@RestController
@RequestMapping(value = "/facture")
@Service
public class FactureServiceImpl implements IFactureService {
	@Autowired
	FactureRepository factureRepository;
	private static final Logger l = LogManager.getLogger(IFactureService.class);

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	@Override
	public List<Facture> retrieveAllFacture() {
		List<Facture> factures =(List<Facture>)factureRepository.findAll();
		for( Facture facture : factures)
		{
			l.info("facture:"+ facture);
		}
		return factures ;
	}

	@Override
	public Facture addFacture(Facture f) throws ParseException {
		f=factureRepository.save(f);
		return f;
	}

	@Override
	public void deleteFacture(Long id) {
		factureRepository.deleteById(id);
		
	}

	@Override
	public Facture updateFacture(Facture c) {
		c=factureRepository.save(c);
		return null;
	}

	@Override
	public Optional<Facture> retrieveFacture(Long id) {
		return factureRepository.findById(id);
	}

}
