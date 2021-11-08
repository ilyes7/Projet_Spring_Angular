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


import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.Service.IDetailFactureService;

@RestController
@RequestMapping("/detail-facture")
public class DetailFactureRestController {
	@Autowired
	IDetailFactureService detailFactureService;
	
	// http://localhost:8089/SpringMVC/detail-facture/retrieve-all-factures
	@GetMapping("/retrieve-all-factures")
	@ResponseBody
		public List<DetailFacture> getDetailFactures() {
			List<DetailFacture> listFactures = detailFactureService.retrieveAllDetailFacture();
			return listFactures;
		}

	//http://localhost:8089/SpringMVC/detail-facture/retrieve-facture/14
	@GetMapping("/retrieve-facture/{facture-id}")
	@ResponseBody
	public DetailFacture retrieveDetailFacture(@PathVariable("facture-id") Long factureId) {
	return detailFactureService.retrieveDetailFacture(factureId).orElse(null);
	}
	//http://localhost:8089/SpringMVC/detail-facture/add-facture
	@PostMapping("/add-facture")
	@ResponseBody
	public DetailFacture addDetailFacture(@RequestBody DetailFacture c) throws ParseException
	{
		DetailFacture detailFacture = detailFactureService.addDetailFacture(c);
		return detailFacture;
	}

	//http://localhost:8089/SpringMVC/detail-facture/remove-facture/{facture-id}
	@DeleteMapping("remove-facture/{facture-id}")
	@ResponseBody
	public void removeDetailFacture(@PathVariable("facture-id") Long factureId) {
		detailFactureService.deleteDetailFacture(factureId);
	}

	//http://localhost:8089/SpringMVC/detail-facture/modify-facture
	@PutMapping("/modify-facture")
	@ResponseBody
	public DetailFacture modifyDetailFacture(@RequestBody DetailFacture detailFacture) {
	return detailFactureService.updateDetailFacture(detailFacture);
	}

}
