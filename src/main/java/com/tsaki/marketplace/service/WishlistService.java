package com.tsaki.marketplace.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsaki.marketplace.dao.ProductDAO;
import com.tsaki.marketplace.dao.WishlistLineDAO;
import com.tsaki.marketplace.dto.Product;
import com.tsaki.marketplace.dto.Wishlist;
import com.tsaki.marketplace.dto.WishlistLine;
import com.tsaki.marketplace.model.UserModel;

@Service("wishlistService")
public class WishlistService {

	@Autowired
	private WishlistLineDAO wishlistLineDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private HttpSession session;

	public List<WishlistLine> getWishlistLines() {

		return wishlistLineDAO.list(getWishlist().getId());

	}

	/* to update the cart count */
	public String manageWishlistLine(int wishlistLineId, int count) {

		WishlistLine wishlistLine = wishlistLineDAO.get(wishlistLineId);

		Product product = wishlistLine.getProduct();

		// check if that much quantity is available or not
		if (product.getQuantity() < count) {
			return "result=unavailable";
		}

		// update the cart line
		wishlistLine.setProductCount(count);
		wishlistLine.setBuyingPrice(product.getUnitPrice());
		wishlistLine.setTotal(product.getUnitPrice() * count);
		wishlistLineDAO.update(wishlistLine);

		// update the cart
		Wishlist wishlist = this.getWishlist();
		wishlistLineDAO.updateWishlist(wishlist);

		return "result=updated";
	}

	public String addWishlistLine(int productId) {
		Wishlist wishlist = this.getWishlist();
		String response = null;
		WishlistLine wishlistLine = wishlistLineDAO.getByWishlistAndProduct(wishlist.getId(), productId);
		if (wishlistLine == null) {
			// add a new cartLine if a new product is getting added
			wishlistLine = new WishlistLine();
			Product product = productDAO.get(productId);
			// transfer the product details to cartLine
			wishlistLine.setWishlistId(wishlist.getId());
			wishlistLine.setProduct(product);
			wishlistLine.setProductCount(1);
			wishlistLine.setBuyingPrice(product.getUnitPrice());
			wishlistLine.setTotal(product.getUnitPrice());

			// insert a new cartLine
			wishlistLineDAO.add(wishlistLine);

			// update the cart
			wishlist.setWishlistLines(wishlist.getWishlistLines() + 1);
			wishlistLineDAO.updateWishlist(wishlist);

			response = "result=added";
		} else {
			// check if the cartLine has been already reached to maximum count
			if (wishlistLine.getProductCount() < 3) {
				// call the manageCartLine method to increase the count
				response = this.manageWishlistLine(wishlistLine.getId(), wishlistLine.getProductCount() + 1);
			} else {
				response = "result=maximum";
			}
		}
		return response;
	}

	private Wishlist getWishlist() {
		return ((UserModel) session.getAttribute("userModel")).getWishlist();
	}

	public String removeWishlistLine(int wishlistLineId) {

		WishlistLine wishlistLine = wishlistLineDAO.get(wishlistLineId);
		Wishlist wishlist = this.getWishlist();
		wishlist.setWishlistLines(wishlist.getWishlistLines() - 1);
		wishlistLineDAO.updateWishlist(wishlist);

		// remove the cartLine
		wishlistLineDAO.remove(wishlistLine);

		return "result=deleted";
	}

	public String validateWishlistLine() {
		Wishlist wishlist = this.getWishlist();
		List<WishlistLine> wishlistLines = wishlistLineDAO.list(wishlist.getId());
		int lineCount = 0;
		String response = "result=success";
		boolean changed = false;
		Product product;
		for (WishlistLine wishlistLine : wishlistLines) {
			product = wishlistLine.getProduct();
			changed = false;
			

			// changes has happened
			if (changed) {
				// update the cartLine
				wishlistLineDAO.update(wishlistLine);
				// set the result as modified
				response = "result=modified";
			}

			lineCount++;
		}

		wishlist.setWishlistLines(lineCount++);
		wishlistLineDAO.updateWishlist(wishlist);

		return response;
	}

	public String updateWishlistLine(int wishlistLineId, int count) {
		WishlistLine wishlistLine = wishlistLineDAO.get(wishlistLineId);
		if (wishlistLine == null) {
			return "result=error";
		} else {
			Product product = wishlistLine.getProduct();
			if (product.getQuantity() <= count) {
				count = product.getQuantity();
			}
			wishlistLine.setProductCount(count);
			wishlistLine.setBuyingPrice(product.getUnitPrice());
			wishlistLine.setTotal(product.getUnitPrice() * count);
			wishlistLineDAO.update(wishlistLine);
			Wishlist wishlist = this.getWishlist();
			wishlistLineDAO.updateWishlist(wishlist);
			return "result=updated";
		}
	}
}