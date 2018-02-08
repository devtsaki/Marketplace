package com.tsaki.marketplace.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsaki.marketplace.dao.BankAccountDAO;
import com.tsaki.marketplace.dto.BankAccount;
import com.tsaki.marketplace.dto.User;

@Repository("bankAccountDAO")
@Transactional
public class BankAccountDAOImpl implements BankAccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public BankAccount get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(BankAccount.class, Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addBankAccount(BankAccount bankAccount) {
		try {
			sessionFactory.getCurrentSession().persist(bankAccount);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public BankAccount getByEmail(String email) {
		String selectQuery = "FROM BankAccount WHERE email = :email";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, BankAccount.class).setParameter("email", email)
					.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public double getAmount(User user) {
		String selectQuery = "FROM BankAccount WHERE user = :user";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, BankAccount.class)
					.setParameter("user", user).getSingleResult().getAmount();
		} catch (Exception ex) {
			ex.printStackTrace();
			return Double.NaN;
		}
	}

	@Override
	public boolean updateAmount(double amount) {
		try {
			sessionFactory.getCurrentSession().update(amount);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
