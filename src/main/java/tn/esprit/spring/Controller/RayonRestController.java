package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Rayon;
import tn.esprit.spring.DAO.repository.RayonRepository;
import tn.esprit.spring.service.IRayonService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
@RequestMapping("/rayon")
public class RayonRestController {

	@Autowired
	IRayonService rayonService ;

	// http://localhost:8081/SpringMVC/servlet/rayon/retrieve-all-rayons
	@GetMapping("/retrieve-all-rayons")
	public List<Rayon> getRayons() {
		List<Rayon> listRayons = rayonService.retrieveAllRayon();
		return listRayons;
	}

	// http://localhost:8081/SpringMVC/servlet/rayon/retrieve-rayon/1
	@GetMapping("/retrieve-rayon/{rayon-id}")

	public Rayon retrieveRayon(@PathVariable("rayon-id") Long rayonId) {
		return rayonService.retrieveRayon(rayonId);
	}

	// http://localhost:8081/SpringMVC/servlet/rayon/add-rayon
	@PostMapping("/add-rayon")

	public Rayon addRayon(@RequestBody Rayon r)
	{
		Rayon rayon = rayonService.addRayon(r);
		return rayon;
	}

	// http://localhost:8081/SpringMVC/servlet/rayon/remove-rayon/{rayon-id}
	@DeleteMapping("/remove-rayon/{rayon-id}")

	public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
		rayonService.deleteRayon(rayonId);
	}

	// http://localhost:8081/SpringMVC/servlet/rayon/modify-rayon
	@PutMapping("/modify-rayon")
	public Rayon modifyRayon(@RequestBody Rayon rayon) {
		return rayonService.updateRayon(rayon);
	}

	//test de tri + pagination
	@GetMapping("/list")
	public List<Rayon> getRayonss() {
		List<Rayon> listRayons = rayonService.getRayons();
		return listRayons;
	}

	//http://localhost:8081/SpringMVC/servlet/rayon/ListeRayons?page=0&size=3
	@RequestMapping("/ListeRayons")
	public Page<Rayon> listeProduits(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{ 
		Page<Rayon> rayons = rayonService.getAllProduitsParPage(page, size);
		modelMap.addAttribute("rayons", rayons);
		modelMap.addAttribute("pages", new int[rayons.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return rayons;
	}
}
