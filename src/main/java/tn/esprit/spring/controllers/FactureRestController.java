package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.service.IClientService;
import tn.esprit.spring.service.IFactureService;
@CrossOrigin
@RestController
@Api(tags = "Facture management")
@RequestMapping("/facture")
public class FactureRestController {
	@Autowired
	IFactureService factureService;
	
	@Autowired
	FactureRepository factureRepository;

	// http://localhost:8089/SpringMVC/facture/retrieve-all-factures
	@ApiOperation(value = "Récupérer la liste des factures")
	@GetMapping("/retrieve-all-factures")
		public List<Facture> getFactures() {
			List<Facture> listFactures = factureService.retrieveAllFacture();
			return listFactures;
		}
	//http://localhost:8089/SpringMVC/facture/retrieve-facture/14
	@ApiOperation(value = "Récupérer une facture")
	/* @ApiResponses(value = {
		        @ApiResponse(code = 200, message = "successful operation"),
		        @ApiResponse(code = 400, message = "Invalid ID supplied"),
		        @ApiResponse(code = 404, message = "Contact not found"),
		        @ApiResponse(code = 405, message = "Validation exception")})*/
	@GetMapping("/retrieve-facture/{facture-id}")
	@ResponseBody
	public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
	return factureService.retrieveFacture(factureId).orElse(null);
	}
	
	//http://localhost:8089/SpringMVC/facture/add-facture
	@ApiOperation(value = "Ajouter une facture")
	@PostMapping("/add-facture")
	@ResponseBody
	public Facture addFacture(@RequestBody Facture c) throws ParseException
	{
		LocalDateTime localDate = LocalDateTime.now();
		
		c.setActive(false);	
		c.setDateFacture(localDate);
		Facture facture = factureService.addFacture(c);
		return facture;
	}
	
	//http://localhost:8089/SpringMVC/facture/remove-facture/{facture-id}
	@ApiOperation(value = "Supprimer une facture")
	@DeleteMapping("remove-facture/{facture-id}")
	@ResponseBody
	public void removeFacture(@PathVariable("facture-id") Long factureId) {
		factureService.deleteFacture(factureId);
	}
	
	//http://localhost:8089/SpringMVC/facture/modify-facture
	@ApiOperation(value = "modifier une facture")
	@PutMapping("/modify-facture")
	@ResponseBody
	public Facture modifyFacture(@RequestBody Facture facture) {
	return factureService.updateFacture(facture);
	}
	
	//http://localhost:8089/SpringMVC/facture/modify-facture
	@ApiOperation(value = "passer une commande")
	@PutMapping("/passer-une-commande")
	@ResponseBody
	public Facture PasserCommande(@RequestBody Facture facture) {
	return factureService.PasserCommande(facture);
	}

	
	
	
	
	

}
