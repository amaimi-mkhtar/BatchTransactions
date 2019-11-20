package com.example.Batch;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.Idao;
import com.example.entities.Compte;
import com.example.entities.Transaction;
@Service("transactionProcessor")
public class TransactionProcessor implements ItemProcessor<Transaction, Transaction> {
	@Autowired
	private Idao dao;
	public Transaction process(Transaction item) throws Exception {
		
		Date date = new Date(new Long(System.currentTimeMillis()));
		item.setDateDebit(date);
		
		Compte cp = item.getCompte();
		cp.setSolde(cp.getSolde()+ item.getMontant() );
		dao.updateCompte(cp);
		
		return item ;		
	}

}
