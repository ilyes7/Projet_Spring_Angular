package tn.esprit.spring.DAO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.entity.Stock;
@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
	//retrieveStatus
	@Query("SELECT s from Stock s where s.qteStock< s.qteMin")
	List<Stock> retrieveStatusStock();
	//@Query("UPDATE s FROM Stock SET s.qteStock = s.qteStock - 1 WHERE s.idStock = $number and s.qteStock > 0")
	//Stock decrementStock();
}
