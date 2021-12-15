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

import tn.esprit.spring.DAO.entity.Fournisseur;
import tn.esprit.spring.service.IFournisseurService;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurRestController {

	@Autowired
	IFournisseurService fournisseurService;

	// http://localhost:8081/SpringMVC/servlet/fournisseur/retrieve-all-fournisseurs
	@GetMapping("/retrieve-all-fournisseurs")
	public List<Fournisseur> getFournisseurs() {
		List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseur();
		return listFournisseurs;
	}

	// http://localhost:8081/SpringMVC/servlet/fournisseur/retrieve-facture/1
	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")

	public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		return fournisseurService.retrieveFournisseur(fournisseurId);
	}

	// http://localhost:8081/SpringMVC/servlet/fournisseur/add-fournisseur
	@PostMapping("/add-fournisseur")

	public Fournisseur addFournisseur(@RequestBody Fournisseur f)
	{
		Fournisseur fournisseur = fournisseurService.addFournisseur(f);
		return fournisseur;
	}

	// http://localhost:8081/SpringMVC/servlet/fournisseur/remove-fournisseur/{fournisseur-id}
	@DeleteMapping("/remove-facture/{facture-id}")

	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		fournisseurService.deleteFournisseur(fournisseurId);
	}

	// http://localhost:8081/SpringMVC/servlet/fournisseur/modify-fournisseur
	@PutMapping("/modify-fournisseur")
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.updateFournisseur(fournisseur);
	}

}
