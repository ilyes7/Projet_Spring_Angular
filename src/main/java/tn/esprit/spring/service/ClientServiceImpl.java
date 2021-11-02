package tn.esprit.spring.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.enumerate.CategorieClient;
import tn.esprit.spring.enumerate.Profession;
import tn.esprit.spring.repository.ClientRepository;

@Service	
@Slf4j
@RequestMapping("/client")
public class ClientServiceImpl implements ClientSerivce {
	
	@Autowired
	ClientRepository clientRepository;


	
	@Override
	 @GetMapping("/display")
	public List<Client> retrieveAllClients() {
		List<Client> clients = (List<Client>) clientRepository.findAll();
		for(Client client : clients) {
		
			log.info("client: "+ client);
		}
		return clients;
	}

	@Override
	@PostMapping("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Client addClient(@Valid @RequestBody Client c) {		
		return clientRepository.save(c);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteClient(Long id) throws NoSuchElementException {
		Client c1 = retrieveClient(id);
		 clientRepository.delete(c1);
		
	}

	@Override
	@PutMapping("/update/{id}")
	public Client updateClient(@PathVariable(value = "id") Long id, @Valid @RequestBody Client c) {
		Client c1 = retrieveClient(id);
		
		c1.setNom(c.getNom()); 
		c1.setPrenom(c.getPrenom());
		c1.setDateNaissance(null);
		c1.setEmail(c.getEmail());
		c1.setPassword(c.getPassword());
		c1.setCategorieClient(CategorieClient.Ordinaire);
		c1.setProfession(Profession.Docteur);
		
		return clientRepository.save(c1);
	}

	@Override
	public Client retrieveClient(@PathVariable(value = "id") Long id) throws NoSuchElementException {
		Client c = clientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Client not found for this id :: " + id)); ;
		return c ;
	}

	@Override
	public List<Client> retriveByDate() {
		List<Client> clients = (List<Client>) clientRepository.retriveByDate();
		for(Client client : clients) {
		
			log.info("client: "+ client);
		}
		return clients;
	}
	
	

}