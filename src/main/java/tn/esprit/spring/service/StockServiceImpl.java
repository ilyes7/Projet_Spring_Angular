package tn.esprit.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.Produit;
import tn.esprit.spring.DAO.entity.Stock;
import tn.esprit.spring.DAO.repository.ProduitRepository;
import tn.esprit.spring.DAO.repository.StockRepository;

@Service
public class StockServiceImpl implements IStockService{
	@Autowired
	StockRepository stocktRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stocks =(List<Stock> )stocktRepository.findAll();

		for (Stock s: stocks){

			System.out.println("test");
		}
		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		return stocktRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		stocktRepository.save(u);
		return u;

	}

	@Override
	public Stock retrieveStock(Long id) {
		return stocktRepository.findById(id).get();
	}

	@Override
	public void deleteStock(Long id) {
		stocktRepository.deleteById(id);

	}

	@Scheduled(cron = "*/60 * * * * *" )
	public String retrieveStatusStock() {
		SimpleDateFormat sdf = new 	SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String finalMessage = "";
		String newLine = System.getProperty("line.separator");
		List<Stock> stocks = stocktRepository.retrieveStatusStock();
		for (int i= 0; i < stocks.size(); i++) {
			finalMessage = newLine + finalMessage +  msgDate + newLine + ": le produit"
					+stocks.get(i).getLibelleStock() +  "a un stock de" + stocks.get(i).getQteStock()
					+ "infÃ©rieur Ã  la quantitÃ© minimale a ne pas dÃ©passer de " + stocks.get(i).getQteMin()
					+newLine;
		}
		//log.info(finalMessage);
		return finalMessage;
	}


}
