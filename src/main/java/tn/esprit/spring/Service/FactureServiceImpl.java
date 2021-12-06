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

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;

@Service
@Slf4j
public class FactureServiceImpl implements IFactureService {
	@Autowired
	FactureRepository factureRepository;

	@Override
	public List<Facture> retrieveAllFacture() {
		List<Facture> factures =(List<Facture>)factureRepository.findAll();
		for( Facture facture : factures)
		{
			log.info("facture:"+ facture);
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
		return c;
	}

	@Override
	public Optional<Facture> retrieveFacture(Long id) {
		return factureRepository.findById(id);
	}

	

}
