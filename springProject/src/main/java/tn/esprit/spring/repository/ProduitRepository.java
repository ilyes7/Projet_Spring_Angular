package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

	@Modifying
	@Query(value = "INSERT INTO Produit (code, libelle,,PrixUnitaire,idrayon,idstock) VALUES (:code,:libelle, :PrixUnitaire, :idrayon, :idstock)",
	nativeQuery = true)
	public Produit addProduit(@Param("code") String code, @Param("libelle") String libelle,
			@Param("PrixUnitaire") float PrixUnitaire, @Param("idrayon") Long idrayon, 
			@Param("idstock") Long idstock);
}
