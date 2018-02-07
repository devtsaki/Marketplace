package com.tsaki.marketplace.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsaki.marketplace.dao.StockDAO;
import com.tsaki.marketplace.dto.Stock;

@Repository("stockDAO")
@Transactional
public class StockDAOImpl implements StockDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Stock get(int stockId) {
		try {
			return sessionFactory.getCurrentSession().get(Stock.class, Integer.valueOf(stockId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Stock> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Stock", Stock.class).getResultList();
	}

	@Override
	public boolean add(Stock stock) {
		try {
			sessionFactory.getCurrentSession().persist(stock);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Stock stock) {
		try {
			sessionFactory.getCurrentSession().update(stock);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean delete(Stock stock) {
		try {
			sessionFactory.getCurrentSession().delete(stock);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
