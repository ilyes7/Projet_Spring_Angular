package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
	
	

	@Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN '1995-01-01' AND '1995-12-31' ")
	List<Client> retriveByDate();
	

	
	
	
	
	

}
