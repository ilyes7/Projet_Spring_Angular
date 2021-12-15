package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.Stock;
import tn.esprit.spring.service.IStockService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/stock")
public class StockRestController {

	@Autowired
	IStockService stockService;

	// http://localhost:8081/SpringMVC/servlet/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	public List<Stock> getStocks() {
		List<Stock> listStocks = stockService.retrieveAllStocks();
		return listStocks;
	}

	// http://localhost:8081/SpringMVC/servlet/stock/retrieve-stock/1
	@GetMapping("/retrieve-stock/{stock-id}")

	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

	// http://localhost:8081/SpringMVC/servlet/stock/add-stock
	@PostMapping("/add-stock")

	public Stock addStock(@RequestBody Stock s)
	{
		Stock stock = stockService.addStock(s);
		return stock;
	}

	// http://localhost:8081/SpringMVC/servlet/stock/remove-stock/{stock-id}
	@DeleteMapping("/remove-stock/{stock-id}")

	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}

	// http://localhost:8081/SpringMVC/servlet/stock/modify-stock
	@PutMapping("/modify-stock")
	public Stock modifyFournisseur(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}

}
