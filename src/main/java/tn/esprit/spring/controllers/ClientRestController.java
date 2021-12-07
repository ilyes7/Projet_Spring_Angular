package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRestController {

@Autowired
IClientService clientService;

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
return clientService.retrieveClient(clientId);
}


}