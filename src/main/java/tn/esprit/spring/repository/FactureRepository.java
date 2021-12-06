package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;

public interface FactureRepository extends CrudRepository <Facture,Long> {
	List<Facture> findByClientLike(Client user);
}
