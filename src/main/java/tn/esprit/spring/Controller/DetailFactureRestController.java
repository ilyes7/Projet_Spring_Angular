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

import tn.esprit.spring.DAO.entity.DetailFacture;
import tn.esprit.spring.service.IDetailFactureService;

@RestController
@RequestMapping("/detailfacture")
public class DetailFactureRestController {
	@Autowired
	IDetailFactureService detailFactureService ;

	//  http://localhost:8081/SpringMVC/servlet/detailfacture/retrieve-all-detailfacture
	@GetMapping("/retrieve-all-detailfacture")
	public List<DetailFacture> getDetailFactures() {
		List<DetailFacture> detailsF = detailFactureService.retrieveAllDetailFacture();
		return detailsF;
	}

	// http://localhost:8081/SpringMVC/servlet/detailfacture/retrieve-detailfacture/1
	@GetMapping("/retrieve-detailfacture/{detailFacture-id}")

	public DetailFacture retrieveDetailFacture(@PathVariable("detailFacture-id") Long idDetailFacture) {
		return detailFactureService.retrieveDetailFacture(idDetailFacture);
	}

	// http://localhost:8081/SpringMVC/servlet/detailfacture/add-detailfacture
	@PostMapping("/add-detailfacture")

	public DetailFacture addDetailFacture(@RequestBody DetailFacture d)
	{
		DetailFacture detail = detailFactureService.addDetailFacture(d);
		return detail;
	}

	// http://localhost:8081/SpringMVC/servlet/detailfacture/remove-detailfacture/{detailfacture-id}
	@DeleteMapping("/remove-detailfacture/{detailfacture-id}")

	public void removeDetailFacture(@PathVariable("detailfacture-id") Long DetailFactureId) {
		detailFactureService.deleteDetailFacture(DetailFactureId);
	}

	// http://localhost:8081/SpringMVC/servlet/detailfacture/modify-detailfacture
	@PutMapping("/modify-detailfacture")
	public DetailFacture modifyDetailFacture(@RequestBody DetailFacture detailfacture) {
		return detailFactureService.updateDetailFacture(detailfacture);
	}

}
