package com.tsaki.marketplace.dao;

import java.util.List;

import com.tsaki.marketplace.dto.Wishlist;
import com.tsaki.marketplace.dto.WishlistLine;

public interface WishlistLineDAO {

	public List<WishlistLine> list(int cartId);
	public WishlistLine get(int id);	
	public boolean add(WishlistLine cartLine);
	public boolean update(WishlistLine cartLine);
	public boolean remove(WishlistLine cartLine);
	
	// fetch the CartLine based on cartId and productId
	public WishlistLine getByWishlistAndProduct(int cartId, int productId);		
		
	// updating the cart
	boolean updateWishlist(Wishlist wishlist);
	
	// list of available cartLine
	public List<WishlistLine> listAvailable(int wishlistId);
	
}
