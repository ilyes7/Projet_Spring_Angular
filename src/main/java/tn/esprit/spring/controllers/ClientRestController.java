package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRestController {

@Autowired
IClientService clientService;
@Autowired
ClientRepository clientRepo;


// http://localhost:8089/SpringMVC/client/retrieve-all-clients
@GetMapping("/retrieve-all-clients")
@ResponseBody
	public List<Client> getClients() {
		List<Client> listClients = clientService.retrieveAllClients();
		return listClients;
	}

//http://localhost:8089/SpringMVC/client/retrieve-client/14
@GetMapping("/retrieve-client/{client-id}")
@ResponseBody
public Client retrieveClient(@PathVariable("client-id") Long clientId) {
	Client c=clientService.retrieveClient(clientId);
	List<Facture> factures =(List<Facture>)c.getFactures();
	for( Facture dfacture : factures)
	{
		System.out.println(dfacture.getIdFacture());
	}
		return c;
}



//http://localhost:8089/SpringMVC/client/retrieve-client/14
@GetMapping("/retrieve-client-factures/{client-id}")
@ResponseBody
public List<Facture> retrieveClientFactures(@PathVariable("client-id") Long clientId) {
	return clientService.retrieveClientsFactures(clientId);
}


}