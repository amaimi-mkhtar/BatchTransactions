package com.example.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entities.Compte;
import com.example.entities.Transaction;
@Repository
public class Dao implements Idao {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addTransaction(Transaction tr) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(tr.toString());
		session.saveOrUpdate(tr);
	}

	public Compte getCompteById(int idCompte) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Compte.class, idCompte);
	}

	public void updateCompte(Compte compte) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(compte);
		
		
	}

}
