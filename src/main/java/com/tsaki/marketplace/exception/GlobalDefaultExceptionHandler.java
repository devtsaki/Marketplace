package com.tsaki.marketplace.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "This page does not exist");
		mv.addObject("errorDescription", "Well, you're out of luck! This page is not available right now!");
		mv.addObject("title", "404 Error Page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "This poduct is not available");
		mv.addObject("errorDescription", "Out of all our products, you chose one that doesn't exist! Better luck next time!");
		mv.addObject("title", "Product Not Available");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Move along! Nothing to see here!");
		mv.addObject("errorDescription", ex.toString());
		mv.addObject("title", "Oh snap!");
		return mv;
	}
	
}
