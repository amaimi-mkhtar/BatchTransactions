package com.example.entities;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class Transaction {

	@Id
	private int id;
	private Double montant;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTransaction;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebit;
	
	@ManyToOne
	@JoinColumn(name = "compteId")
	private Compte compte;

	public Transaction(int id, Double montant, Date dateTransaction) {
		super();
		this.id = id;
		this.montant = montant;
		this.dateTransaction = dateTransaction;
		
	}

	public Transaction(Double montant, Date dateTransaction) {
		super();
		this.montant = montant;
		this.dateTransaction = dateTransaction;
		this.dateDebit = dateDebit;
		this.compte = compte;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDateDebit() {
		return dateDebit;
	}

	public void setDateDebit(Date dateDebit) {
		this.dateDebit = dateDebit;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	
	
		
	
}
