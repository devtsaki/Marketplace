package com.tsaki.marketplace.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsaki.marketplace.model.UserModel;

@Service("stockService")
public class StockService {
	
//	@Autowired
//	private HttpSession session;
//	
//	public int getUserId() {
//		return ((UserModel) session.getAttribute("userModel")).getId();
//	}
}
