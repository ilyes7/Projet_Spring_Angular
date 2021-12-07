package tn.esprit.spring.service;

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
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.FactureRepository;


@Slf4j
@Service
public class DetailFactureServiceImpl implements IDetailFactureService {
	@Autowired
	DetailFactureRepository DFactureRepository;
	@Autowired
	IFactureService factureService;


	@Override
	public List<DetailFacture> retrieveAllDetailFacture() {
		List<DetailFacture> dfactures =(List<DetailFacture>)DFactureRepository.findAll();
		for( DetailFacture dfacture : dfactures)
		{
			log.info("facture:"+ dfacture);
		}
		return dfactures ;
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture df, Facture fact) throws ParseException {
	
		df.setFacture(fact);
		df=DFactureRepository.save(df);
		
		return df;
	}

	@Override
	public void deleteDetailFacture(Long id) {
		DFactureRepository.deleteById(id);
		
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture c) {
		c=DFactureRepository.save(c);
		return null;
	}
	
	@Override
	public Optional<DetailFacture> retrieveDetailFacture(Long id) {
		return DFactureRepository.findById(id);
	}

}
