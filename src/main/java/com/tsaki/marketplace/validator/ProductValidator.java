package com.tsaki.marketplace.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tsaki.marketplace.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> class1) {
		return Product.class.equals(class1);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select an image file!");
			return;
		}
		
		if (! (product.getFile().getContentType().equals("image/jpeg") || 
				product.getFile().getContentType().equals("image/png") || 
				product.getFile().getContentType().equals("image/gif")) ) {
			errors.rejectValue("file", null, "Please enter valid image file!");
			return;
		}
		
	}

}
