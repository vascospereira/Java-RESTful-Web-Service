package io.stocks.stocksapi.index;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.stocks.stocksapi.stock.Stock;

@Entity
public class Index {

	@Id
	private String id;
	private String name;
	private double price;

	@ManyToOne
	private Stock stock;

	public Index() {
	}

	public Index(String id, String name, double price, String stockId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = new Stock(stockId, "", 0.0);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
