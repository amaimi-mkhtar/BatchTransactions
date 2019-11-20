package com.example.Dao;

import com.example.entities.Compte;
import com.example.entities.Transaction;

public interface Idao {

	public void addTransaction(Transaction tr);
	public Compte getCompteById(int idCompte);
	public void updateCompte(Compte compte);
	
}
