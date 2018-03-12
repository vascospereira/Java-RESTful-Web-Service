package io.stocks.stocksapi.index;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

	@Autowired
	private IndexRepository indexRepository;

	public List<Index> getAllIndices(String stockId) {
		List<Index> index = new ArrayList<>();
		indexRepository.findByStockId(stockId).forEach(index::add);
		return index;
	}

	public Index getIndex(String id) {
		return indexRepository.findOne(id);
	}

	public void addIndex(Index index) {
		indexRepository.save(index);
	}

	public void updateIndex(Index index) {
		indexRepository.save(index);
	}

	public void deleteIndex(String id) {
		indexRepository.delete(id);
	}

}
