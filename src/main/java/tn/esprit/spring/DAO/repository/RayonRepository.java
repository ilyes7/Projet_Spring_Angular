package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Rayon;

@Repository
public interface RayonRepository extends JpaRepository<Rayon, Long> {
	//List<Rayon> findAll(Pageable sort);
}
