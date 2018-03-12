package io.stocks.stocksapi.stock;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, String> {
}
