package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;

import tn.esprit.spring.DAO.entity.Rayon;

public interface IRayonService {
	
	 List<Rayon> retrieveAllRayon();
	 Rayon addRayon(Rayon r);
	 void deleteRayon(Long id);
	 Rayon updateRayon(Rayon r);
	 Rayon retrieveRayon(Long id);
	 List<Rayon> getRayons();
	 Page<Rayon> getAllProduitsParPage(int page, int size);
}
