package io.stocks.stocksapi.stock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	/*
	private List<Stock> stocks = new ArrayList<>( Arrays.asList(new Stock("APPL", "Apple", 123.45),
			new Stock("NFLX", "Netflix", 232.89),
			new Stock("MSFT", "Microsoft", 45.23)
			));
	*/
	
	public List<Stock> getAllStocks() {
		List<Stock> stocks = new ArrayList<>();
		stockRepository.findAll().forEach(stocks::add);
		return stocks;
	}
	
	public Stock getStock(String id){
		return stockRepository.findOne(id);
	}

	public void addStock(Stock stock) {
		stockRepository.save(stock);
	}

	public void updateStock(String id, Stock stock) {
		stockRepository.save(stock);
	}

	public void deleteStock(String id) {
		stockRepository.delete(id);
	}
	
}
