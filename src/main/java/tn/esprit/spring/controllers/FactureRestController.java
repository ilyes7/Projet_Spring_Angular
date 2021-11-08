package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.Service.IFactureService;

@RestController
@RequestMapping("/facture")
public class FactureRestController {
	@Autowired
	IFactureService factureService;
	
	// http://localhost:8089/SpringMVC/facture/retrieve-all-factures
	@GetMapping("/retrieve-all-factures")
	@ResponseBody
		public List<Facture> getFactures() {
			List<Facture> listFactures = factureService.retrieveAllFacture();
			return listFactures;
		}
	//http://localhost:8089/SpringMVC/facture/retrieve-facture/14
	@GetMapping("/retrieve-facture/{facture-id}")
	@ResponseBody
	public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
	return factureService.retrieveFacture(factureId).orElse(null);
	}
	
	//http://localhost:8089/SpringMVC/facture/add-facture
	@PostMapping("/add-facture")
	@ResponseBody
	public Facture addFacture(@RequestBody Facture c) throws ParseException
	{
		Facture facture = factureService.addFacture(c);
		return facture;
	}
	
	//http://localhost:8089/SpringMVC/facture/remove-facture/{facture-id}
	@DeleteMapping("remove-facture/{facture-id}")
	@ResponseBody
	public void removeFacture(@PathVariable("facture-id") Long factureId) {
		factureService.deleteFacture(factureId);
	}
	
	//http://localhost:8089/SpringMVC/facture/modify-facture
	@PutMapping("/modify-facture")
	@ResponseBody
	public Facture modifyFacture(@RequestBody Facture facture) {
	return factureService.updateFacture(facture);
	}
	
	

}
