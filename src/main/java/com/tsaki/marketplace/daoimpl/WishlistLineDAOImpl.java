package com.tsaki.marketplace.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsaki.marketplace.dao.WishlistLineDAO;
import com.tsaki.marketplace.dto.Wishlist;
import com.tsaki.marketplace.dto.WishlistLine;


@Repository("wishlistLineDAO")
@Transactional
public class WishlistLineDAOImpl implements WishlistLineDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public WishlistLine getByWishlistAndProduct(int cartId, int productId) {
		String query = "FROM WishlistLine WHERE wishlistId = :cartId AND product.id = :productId";
		try {
			
			return sessionFactory.getCurrentSession()
									.createQuery(query,WishlistLine.class)
										.setParameter("wishlistId", cartId)
										.setParameter("productId", productId)
											.getSingleResult();
			
		}catch(Exception ex) {
			return null;	
		}
		
	}

	@Override
	public boolean add(WishlistLine wishlistLine) {
		try {
			sessionFactory.getCurrentSession().persist(wishlistLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(WishlistLine wishlistLine) {
		try {
			sessionFactory.getCurrentSession().update(wishlistLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(WishlistLine wishlistLine) {	
		try {			
			sessionFactory.getCurrentSession().delete(wishlistLine);
			return true;
		}catch(Exception ex) {
			return false;
		}		
	}


	@Override
	public List<WishlistLine> list(int wishlistId) {
		String query = "FROM WishlistLine WHERE wishlistId = :wishlistId";
		return sessionFactory.getCurrentSession()
								.createQuery(query, WishlistLine.class)
									.setParameter("wishlistId", wishlistId)
										.getResultList();		
	}

	@Override
	public WishlistLine get(int id) {		
		return sessionFactory.getCurrentSession().get(WishlistLine.class, Integer.valueOf(id));
	}

	@Override
	public boolean updateWishlist(Wishlist wishlist) {
		try {			
			sessionFactory.getCurrentSession().update(wishlist);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<WishlistLine> listAvailable(int wishlistId) {
		String query = "FROM WishlistLine WHERE wishlistId = :wishlistId";
		return sessionFactory.getCurrentSession()
								.createQuery(query, WishlistLine.class)
									.setParameter("wishlistId", wishlistId)
										.getResultList();
	}

}
