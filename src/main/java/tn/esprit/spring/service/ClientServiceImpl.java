package tn.esprit.spring.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.enumerate.CategorieClient;
import tn.esprit.spring.enumerate.Profession;
import tn.esprit.spring.repository.ClientRepository;
@RestController
@RequestMapping(value = "/student")
@Service
public class ClientServiceImpl implements IClientService {
	@Autowired
	ClientRepository clientRepository;
	private static final Logger l = LogManager.getLogger(ClientServiceImpl.class);

	@Override
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public List<Client> retrieveAllClients() {
		List<Client> clients =(List<Client>)clientRepository.findAll();
		for( Client client : clients)
		{
			l.info("client:"+ client);
		}
		return clients ;
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Client addClient(Client c) throws ParseException {
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
		
		
		
		
		c=clientRepository.save(c);
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
		
	}

	@Override
	public Client updateClient(Client c) {
		c=clientRepository.save(c);
		return null;
	}

	@Override
	public Client retrieveClient(Long id) {
		return clientRepository.findById(id).orElse(null);
	}
	@Override
	public List<Facture> retrieveClientsFactures(Long id) {
		Client c= clientRepository.findById(id).orElse(null);
		List<Facture> factures =(List<Facture>)c.getFactures();
		for( Facture dfacture : factures)
		{
			System.out.println(dfacture.getIdFacture());
		}
		return factures;
	}

	
	

	




}
