package io.stocks.stocksapi.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping("/stocks")
	public List<Stock> getAllStocks(){
		return stockService.getAllStocks();
	}
	
	@RequestMapping("stocks/{symbol}")
	public Stock getStock(@PathVariable("symbol") String id){
		return stockService.getStock(id.toUpperCase());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/stocks")
	public void addStock(@RequestBody Stock stock){
		stockService.addStock(stock);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/stocks/{id}")
	public void updateStock(@RequestBody Stock stock, @PathVariable String id){
		stockService.updateStock(id.toUpperCase(), stock);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/stocks/{id}")
	public void deleteStock(@PathVariable String id){
		stockService.deleteStock(id.toUpperCase());
	}
	
}
