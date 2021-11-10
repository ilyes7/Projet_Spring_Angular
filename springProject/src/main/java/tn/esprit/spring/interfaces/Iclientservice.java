package tn.esprit.spring.interfaces;

import java.util.List;

import tn.esprit.spring.entity.Client;

public interface Iclientservice {
	
	    List<Client> retrieveAllClients();

		Client addClient(Client c);

		void deleteClient(Long id);

		Client updateClient(Client c);

		Client retrieveClient(Long id);
		//List<Client> retrieveClientsBydateNaissance();
}
