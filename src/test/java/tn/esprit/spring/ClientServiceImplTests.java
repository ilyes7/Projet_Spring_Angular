package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.enumerate.CategorieClient;
import tn.esprit.spring.enumerate.Profession;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.Service.ClientServiceImpl;
@RequestMapping(value = "/test")
@RunWith(SpringRunner.class)
@SpringBootTest
class ClientServiceImplTests {

	
private static final Logger l = LogManager.getLogger(ClientServiceImplTests.class);
	
	@Autowired
	private ClientServiceImpl cs;
	
	@Autowired
	ClientRepository clientRepository;
	
		@Test
	void addClientsTest() throws ParseException {
			
	
			Client c=new Client();
			String pattern = "dd/MM/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			Date daten = simpleDateFormat.parse(date);
			System.out.println(date);
			CategorieClient cat=  CategorieClient.valueOf("Ordinaire");
			Profession p=Profession.valueOf("Etudiant");
			c.setNom("nom");
			c.setPrenom("prenom");
			c.setDateNaissance(daten);
			c.setEmail("email");
			c.setPassword("pwd");
			c.setCategorieClient(cat);
			c.setProfession(p);
					
		cs.addClient(c);
		l.info(c);
	} 
	
	@Test
	void retreiveAllClientsTest() {
		
		cs.retrieveAllClients();
		
	}
	

	
	@Test
	void retreiveClientTest() {
		cs.retrieveClient((long) 1);
		
	}
	
	@Test
	void UpdateClientTest() throws ParseException {
		//Client c = cs.retrieveClient((long) 1);
		
		Client c= new Client();
		c.setIdClient((long)1);
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		Date daten = simpleDateFormat.parse(date);
		System.out.println(date);
		CategorieClient cat=  CategorieClient.valueOf("Fidele");
		Profession p=Profession.valueOf("Docteur");
		c.setNom("Zohra");
		c.setPrenom("Haribi");
		c.setDateNaissance(daten);
		c.setEmail("emailUpdated");
		c.setPassword("pwdUpdated");
		c.setCategorieClient(cat);
		c.setProfession(p);
		
		
		cs.updateClient(c);
		l.info("Client: " + c.toString());
	}
	
	@Test
	void deleteClientTest() {
		cs.deleteClient((long) 12);
		l.info("Client suprime!!");
	}
	
	
	
	}