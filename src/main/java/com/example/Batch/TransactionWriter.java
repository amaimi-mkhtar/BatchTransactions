package com.example.Batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.Idao;
import com.example.entities.Transaction;

@Service("transactionWriter")
public class TransactionWriter implements ItemWriter<Transaction>{
	@Autowired
	private Idao dao;
	
	public void write(List<? extends Transaction> transactions) throws Exception {
		for(Transaction tr : transactions){
			dao.addTransaction(tr);
		}
		
	}

}
