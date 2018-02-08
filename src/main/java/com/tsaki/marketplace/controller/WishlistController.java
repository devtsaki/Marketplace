package com.tsaki.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tsaki.marketplace.service.WishlistService;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	@RequestMapping("/show")
	public ModelAndView showWishlist(@RequestParam(name = "result", required = false) String result) {
		ModelAndView mv = new ModelAndView("page");
		if (result != null) {
			switch (result) {
			case "added":
				mv.addObject("message", "Product has been successfully added inside wishlist!");
				wishlistService.validateWishlistLine();
				break;
			case "unavailable":
				mv.addObject("message", "Product quantity is not available!");
				break;
			case "updated":
				mv.addObject("message", "Wishlist has been updated successfully!");
				wishlistService.validateWishlistLine();
				break;
			case "modified":
				mv.addObject("message", "One or more items inside wishlist has been modified!");
				break;
			case "maximum":
				mv.addObject("message", "Maximum limit for the item has been reached!");
				break;
			case "deleted":
				mv.addObject("message", "WishlistLine has been successfully removed!");
				break;

			}
		} else {
			String response = wishlistService.validateWishlistLine();
			if (response.equals("result=modified")) {
				mv.addObject("message", "One or more items inside cart has been modified!");
			}
		}
		mv.addObject("title", "User Wishlist");
		mv.addObject("userClickShowWishlist", true);
		mv.addObject("wishlistLines", wishlistService.getWishlistLines());
		return mv;
	}

	@RequestMapping("/{wishlistLineId}/update")
	public String updateWishlist(@PathVariable int wishlistLineId, @RequestParam int count) {
		String response = wishlistService.updateWishlistLine(wishlistLineId, count);
		return "redirect:/wishlist/show?" + response;
	}

	@RequestMapping("/{wishlistLineId}/remove")
	public String removeWishlistLine(@PathVariable int wishlistLineId) {
		String response = wishlistService.removeWishlistLine(wishlistLineId);
		return "redirect:/wishlist/show?" + response;
	}

	@RequestMapping("/add/{productId}/product")
	public String addWishlistLine(@PathVariable int productId) {
		String response = wishlistService.addWishlistLine(productId);
		return "redirect:/wishlist/show?" + response;
	}

	@RequestMapping("/validate")
	public String validateWishlist() {
		String response = wishlistService.validateWishlistLine();
		if (!response.equals("result=success")) {
			return "redirect:/wishlist/show?" + response;
		} else {
			return "redirect:/wishlist/show";
		}
	}
}
