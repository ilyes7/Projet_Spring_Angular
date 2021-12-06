package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;


public interface ClientRepository extends CrudRepository <Client,Long> {
	//List<Facture> findByFacturesAndFindOne(Long id);
	//@Query("SELECT c FROM Client c WHERE c.idclient= :id")
	//List<Facture> retrieveFacturesByClient(@Param("id") Long id);
	

}
