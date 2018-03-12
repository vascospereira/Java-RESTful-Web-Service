package io.stocks.stocksapi.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.stocks.stocksapi.stock.Stock;

@RestController
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping("stocks/{id}/indices")
	public List<Index> getAllIndices(@PathVariable String id){
		return indexService.getAllIndices(id);
	}
	
	@RequestMapping("stocks/{stockId}/indices/{id}")
	public Index getIndex(@PathVariable String id){
		return indexService.getIndex(id.toUpperCase());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/stocks/{stockId}/indices")
	public void addIndex(@RequestBody Index index, @PathVariable String stockId){
		index.setStock(new Stock(stockId, "", 0.0));
		indexService.addIndex(index);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/stocks/{stockId}/indices/{id}")
	public void updateIndex(@RequestBody Index index, @PathVariable String stockId, @PathVariable String id){
		index.setStock(new Stock(stockId, "", 0.0));
		indexService.updateIndex(index);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/stocks/{stockId}/indices/{id}")
	public void deleteIndex(@PathVariable String id){
		indexService.deleteIndex(id.toUpperCase());
	}
	
}
