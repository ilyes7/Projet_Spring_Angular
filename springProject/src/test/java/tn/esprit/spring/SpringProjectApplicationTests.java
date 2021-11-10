package tn.esprit.spring;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.interfaces.Iclientservice;
import tn.esprit.spring.interfaces.StockService;
@RunWith(SpringRunner.class)

@SpringBootTest
public class SpringProjectApplicationTests {

	
	@Autowired
	Iclientservice clientservice;
	
	@Autowired
	StockService stockService;
	
	@Test
	public void testretrieveAllClients(){
		clientservice.retrieveAllClients();
	}
	
	
	@Test
	public void testAddStock() {
	Stock s = new Stock();
	s.setLibelleStock("stock test");
	s.setQte(10);
	s.setQteMin(100);
	Stock savedStock=stockService.addStock(s);
	stockService.deleteStock(savedStock.getIdStock());
	}
	
	//@Test
	//public void testdeleteStock() {
	//	stockService.deleteStock(1);
	//}
	
	/*@Test
	public void testRetrieveClientsBydateNaissance(){
		clientservice.retrieveClientsBydateNaissance();
	}*/
	
	

}
