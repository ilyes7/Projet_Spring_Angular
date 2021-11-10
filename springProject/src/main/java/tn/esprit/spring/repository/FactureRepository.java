package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Facture;
@Repository
public interface FactureRepository extends CrudRepository<Facture, Long>{

	@Modifying
	@Query("DELETE FROM Facture f WHERE f.idFacture= :idFacture AND f.active = FALSE")
	void deleteFacture(@Param("idFacture")Long idFacture);

}
