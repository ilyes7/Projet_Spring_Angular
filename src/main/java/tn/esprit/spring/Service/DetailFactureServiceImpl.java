package tn.esprit.spring.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.DetailFacture;


@RestController
@RequestMapping(value = "/detail-facture")
@Service
public class DetailFactureServiceImpl implements IDetailFactureService {

	@Override
	public List<DetailFacture> retrieveAllDetailFacture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture c) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDetailFacture(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DetailFacture> retrieveDetailFacture(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
