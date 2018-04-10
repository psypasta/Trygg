package bank.transfer;

import bank.accounts.Account;

import java.util.Calendar;

public abstract class Transfer {

	protected Account to;
	protected Account from;
	protected double amount;
	protected Calendar transactionDate;
	protected String transferId;

	public abstract void commit();
	public abstract String toString();
} 
