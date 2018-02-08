package com.tsaki.marketplace.dao;

import com.tsaki.marketplace.dto.BankAccount;
import com.tsaki.marketplace.dto.User;

public interface BankAccountDAO {

	BankAccount get(int id);
	boolean addBankAccount(BankAccount bankAccount);
	BankAccount getByEmail(String email);
	double getAmount(User user);
	boolean updateAmount(double amount);
}
