package tn.esprit.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.interfaces.Iclientservice;
import tn.esprit.spring.repository.ClientRepository;
@Slf4j
@Service
public class ClientServiceImp implements Iclientservice  {
	@Autowired 
	ClientRepository clientRepository;
	
	@Override
	public List<Client> retrieveAllClients() {
		List<Client> clients= (List<Client>) clientRepository.findAll();
		for (Client client: clients) {
			//System.out.println("Client :" + client);
			log.info("client:"+ client);
		}
		return clients;
	}

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
		}
	@Override
	public void deleteClient(Long clientId) {
		clientRepository.deleteById(clientId);
		}

	@Override
	public Client updateClient(Client c) {
		return clientRepository.save(c);
		}

	@Override
	public Client retrieveClient(Long clientId) {
		Client client = clientRepository.findById(clientId).orElse(null);
		//System.out.println("Client :" + client);
		log.info("client:"+ client);
		return client; 
	}

	

	/*public List<Client> retrieveClientsBydateNaissance() {
		List<Client> clients= (List<Client>)clientRepository.retrieveClientsBydateNaissance() ;
		for (Client client: clients) {
		log.info("client:"+ client); }
	
	return clients;
	}*/

}
