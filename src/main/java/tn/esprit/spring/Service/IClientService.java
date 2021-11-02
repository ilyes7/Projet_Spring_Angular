package tn.esprit.spring.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import tn.esprit.spring.entity.Client;

public interface IClientService {
	List<Client> retrieveAllClients();

	Client addClient(Client c) throws ParseException;

	void deleteClient(Long id);

	Client updateClient(Client c);

	Optional<Client> retrieveClient(Long id);

}
