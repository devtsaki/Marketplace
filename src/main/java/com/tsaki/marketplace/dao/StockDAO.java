package com.tsaki.marketplace.dao;

import java.util.List;

import com.tsaki.marketplace.dto.Stock;

public interface StockDAO {

	Stock get(int stockId);
	List<Stock> list();
	boolean add(Stock stock);
	boolean update(Stock stock);
	boolean delete(Stock stock);
}
