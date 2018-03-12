package io.stocks.stocksapi.index;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IndexRepository extends CrudRepository<Index, String>{
	public List<Index> findByStockId(String stockId);
}
