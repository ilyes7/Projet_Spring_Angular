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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.FactureServiceImpl;
import tn.esprit.spring.service.IDetailFactureService;
import tn.esprit.spring.service.IFactureService;

@RestController
@Api(tags = "Detail Facture management")
@RequestMapping("/detail-facture")
public class DetailFactureRestController {
	@Autowired
	IDetailFactureService detailFactureService;
	@Autowired
	IFactureService factser;
	
	// http://localhost:8089/SpringMVC/detail-facture/retrieve-all-factures
	@ApiOperation(value = "Récupérer la liste des details factures")
	@GetMapping("/retrieve-all-factures")
	@ResponseBody
		public List<DetailFacture> getDetailFactures() {
			List<DetailFacture> listFactures = detailFactureService.retrieveAllDetailFacture();
			return listFactures;
		}

	//http://localhost:8089/SpringMVC/detail-facture/retrieve-facture/14
	@ApiOperation(value = "Récupérer une detail facture")
	@GetMapping("/retrieve-facture/{facture-id}")
	@ResponseBody
	public DetailFacture retrieveDetailFacture(@PathVariable("facture-id") Long factureId) {
	return detailFactureService.retrieveDetailFacture(factureId).orElse(null);
	}
	//http://localhost:8089/SpringMVC/detail-facture/add-facture
	@ApiOperation(value = "Ajouter une detail facture")
	@PostMapping("/add-facture/{facture-id}")
	@ResponseBody
	public DetailFacture addDetailFacture(@RequestBody DetailFacture c,@PathVariable("facture-id") Long factureId) throws ParseException
	{
		Facture f=factser.retrieveFacture(factureId).orElse(null);
		DetailFacture detailFacture = detailFactureService.addDetailFacture(c,f);
		return detailFacture;
	}

	//http://localhost:8089/SpringMVC/detail-facture/remove-facture/{facture-id}
	@ApiOperation(value = "Supprimer une detail facture")
	@DeleteMapping("remove-facture/{facture-id}")
	@ResponseBody
	public void removeDetailFacture(@PathVariable("facture-id") Long factureId) {
		detailFactureService.deleteDetailFacture(factureId);
	}

	//http://localhost:8089/SpringMVC/detail-facture/modify-facture
	@PutMapping("/modify-facture")
	@ApiOperation(value = "modifier une detail facture")
	@ResponseBody
	public DetailFacture modifyDetailFacture(@RequestBody DetailFacture detailFacture) {
	return detailFactureService.updateDetailFacture(detailFacture);
	
	}

}
