package tn.esprit.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entity.Client;
import tn.esprit.spring.enumerate.CategorieClient;
import tn.esprit.spring.enumerate.Profession;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.service.ClientServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClientServiceImplTests {

	
private static final Logger l = LogManager.getLogger(ClientServiceImplTests.class);
	
	@Autowired
	private ClientServiceImpl cs;
	
	@Autowired
	ClientRepository clientRepository;
	

		@Test
	void addClientsTest() {
			
		//	ClientServiceImpl cs = new ClientServiceImpl() ;
			
	
		Client c = new Client("Ilyes","Fitouri",null,"aaaa@gmail.com","aaaaa", CategorieClient.Fidele,Profession.Docteur);
		
		//clientRepository.save(c);
		cs.addClient(c);
		l.info(c);
	} 
	
	@Test
	void retreiveAllClientsTest() {
		
		cs.retrieveAllClients();
		
	}
	
	@Test
	void retriveByDateTest() {
		
		cs.retriveByDate();
		
	}
	
	@Test
	void retreiveClientTest() {
		cs.retrieveClient((long) 1);
		
	}
	
	@Test
	void UpdateClientTest() {
		Client c1 = cs.retrieveClient((long) 1);
		c1.setNom("Ilyes"); 
		c1.setPrenom("ben baaaa");
		c1.setDateNaissance(null);
		c1.setEmail("ilyes@gmail.com");
		c1.setPassword("aaaa");
		c1.setCategorieClient(CategorieClient.Fidele);
		c1.setProfession(Profession.Docteur);
		cs.updateClient((long)1 ,c1);
		l.info("Client: " + c1.toString());
	}
	
	@Test
	void deleteClientTest() {
		cs.deleteClient((long) 12);
		l.info("Client suprime!!");
	}
	
	
	
	}