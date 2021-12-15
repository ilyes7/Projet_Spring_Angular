package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.DetailProduit;
import tn.esprit.spring.service.IDetailProduitService;

@RestController
@RequestMapping("/detailproduit")
public class DetailProduitRestController {
	@Autowired
	IDetailProduitService detailProduitService;


	//  http://localhost:8081/SpringMVC/servlet/detailproduit/retrieve-all-detailproduit
	@GetMapping("/retrieve-all-detailproduit")
	public List<DetailProduit> getDetailProduits() {
		List<DetailProduit> detailsP = detailProduitService.retrieveAllDetailProduit();
		return detailsP;
	}

	// http://localhost:8081/SpringMVC/servlet/detailproduit/retrieve-detailproduit/{detailproduit-id}
	@GetMapping("/retrieve-detailproduit/{detailproduit-id}")

	public DetailProduit retrieveDetailProduit(@PathVariable("detailproduit-id") Long idDetailProduit) {
		return detailProduitService.retrieveDetailProduit(idDetailProduit);
	}

	// http://localhost:8081/SpringMVC/servlet/detailproduit/add-detailproduit
	@PostMapping("/add-detailproduit")

	public DetailProduit addDetailProduit(@RequestBody DetailProduit d)
	{
		DetailProduit detail = detailProduitService.addDetailProduit(d);
		return detail;
	}

	// http://localhost:8081/SpringMVC/servlet/detailproduit/remove-detailproduit/{detailproduit-id}
	@DeleteMapping("/remove-detailproduit/{detailproduit-id}")

	public void removeDetailFacture(@PathVariable("detailproduit-id") Long DetailProduitId) {
		detailProduitService.deleteDetailProduit(DetailProduitId);
	}

	// http://localhost:8081/SpringMVC/servlet/detailproduit/modify-detailproduit
	@PutMapping("/modify-detailproduit")
	public DetailProduit DetailProduit(@RequestBody DetailProduit detailproduit) {
		return detailProduitService.updateDetailProduit(detailproduit);
	}


}
