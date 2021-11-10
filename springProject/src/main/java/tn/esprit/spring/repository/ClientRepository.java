package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	//@Query("SELECT * FROM Client c WHERE dateNaissance BETWEEN 01-01-1995 AND 31-12-1995")
	//List<Client> retrieveClientsBydateNaissance();

}
