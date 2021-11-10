package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.interfaces.StockService;
import tn.esprit.spring.repository.StockRepository;

@Slf4j
@Service
public class StockServiceImpl implements StockService {
	@Autowired 
	StockRepository stockRepository;

	
	@Override
	public List<Stock> retrieveAllStocks() {

	return stockRepository.findAll() ;
	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
		
	}

	@Override
	public Stock updateStock(Stock u) {
		return stockRepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		Stock stock = stockRepository.findById(id).orElse(null);
		//System.out.println("Stock :" + stock);
		log.info("Stock :" + stock);
		return stock; 
	}

	@Override
	public void deleteStock(long idStock) {
		stockRepository.deleteById(idStock);
		
	}

}
