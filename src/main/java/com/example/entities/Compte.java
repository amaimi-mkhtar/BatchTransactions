package com.example.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Compte {

	
	@Id
	private int idC;
	private Double solde;
	
	@OneToMany(mappedBy = "compte",fetch = FetchType.EAGER)
	private List<Transaction> transactions;

	public Compte(int idC) {
		super();
		this.idC = idC;
	}

	public Compte(int idC, Double solde) {
		super();
		this.idC = idC;
		this.solde = solde;
	}

	public Compte(Double solde, List<Transaction> transactions) {
		super();
		this.solde = solde;
		this.transactions = transactions;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public int getidC() {
		return idC;
	}
	
	
	

}
