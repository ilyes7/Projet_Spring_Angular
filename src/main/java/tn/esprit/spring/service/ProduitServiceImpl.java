package tn.esprit.spring.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.DetailProduit;
import tn.esprit.spring.DAO.entity.Produit;
import tn.esprit.spring.DAO.entity.Rayon;
import tn.esprit.spring.DAO.entity.Stock;
import tn.esprit.spring.DAO.repository.DetailProduitRepository;
import tn.esprit.spring.DAO.repository.ProduitRepository;
import tn.esprit.spring.DAO.repository.RayonRepository;
import tn.esprit.spring.DAO.repository.StockRepository;


@Service
public class ProduitServiceImpl implements IProduitService {
	
@Autowired
	ProduitRepository produitRepository;
@Autowired
	RayonRepository rayonRepository;
@Autowired 
	StockRepository stockRepository;
 @Autowired
 DetailProduitRepository detailrepository;


@Override
public List<Produit> retrieveAllProduit() {
	
List<Produit> produits =(List<Produit> )produitRepository.findAll();

for (Produit p: produits){
	
	System.out.println("test");
}
return produits;

}


@Transactional //nhotou fiha des req et des transaction sur ++ tables (idha bech nbadel fi 4  table idha wehed fihom fih prob taamel rollback )
public Produit addProduit(Produit p, Long idRayon, Long idStock) {
	Stock stock=stockRepository.findById(idStock).orElse(null);// set men child lel parent 
	Rayon rayon=rayonRepository.findById(idRayon).orElse(null) ;
	p.setRayon(rayon);
	p.setStock(stock);
	 produitRepository.save(p);
	 return p;

}

@Override
public void deleteProduit(Long id) {
	produitRepository.deleteById(id);
	
}

@Override
public Produit updateProduit(Produit p) {
	produitRepository.save(p);
	return p;

}

@Override
public Produit retrieveProduit(Long id) {
	Optional<Produit> p = produitRepository.findById(id) ;
	if ( p.isPresent())
	 return p.get(); // nzidha get pour renfonrcer l'objet dima ma findbyId nzid get
	else return null ;
	

}
 // Kid tebda relation 1..* nsavi fel etoile w njib set mta3 l child (1) 
@Transactional
private DetailProduit saveDetailProduit(Produit p){
if(p.getDetailproduit().getDatecreation()==null){
p.getDetailproduit().setDatecreation(new Date());
p.getDetailproduit().setDateDernierModification(new Date());
}else{
p.getDetailproduit().setDateDernierModification(new Date());
}
DetailProduit dp = detailrepository.save(p.getDetailproduit());
return dp;
}

	
	
	
}
