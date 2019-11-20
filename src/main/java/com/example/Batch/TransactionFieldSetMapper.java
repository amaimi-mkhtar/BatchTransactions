package com.example.Batch;



import java.util.Date;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;

import com.example.Dao.Idao;
import com.example.entities.Compte;
import com.example.entities.Transaction;

public class TransactionFieldSetMapper implements FieldSetMapper<Transaction> {
	@Autowired
	private Idao dao;
	public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {
		Transaction tr= new Transaction(fieldSet.readInt(0), fieldSet.readDouble(2), new Date(fieldSet.readString(3))) ;
		System.out.println(tr.toString());
		int idCompte =fieldSet.readInt(1);
		dao.updateCompte(new Compte(idCompte,(double) 0));
		tr.setCompte(dao.getCompteById(idCompte));
		return tr;
	}

}
