package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;

public interface IClientService {
	List<Client> retrieveAllClients();

	Client addClient(Client c) throws ParseException;

	void deleteClient(Long id);

	Client updateClient(Client c);

	  Client retrieveClient(Long id);
	  List<Facture> retrieveClientsFactures(Long id);
	  
}
