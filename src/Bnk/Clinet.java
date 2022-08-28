package Bnk;

import java.security.Timestamp;
import java.util.Arrays;

public  abstract class Clinet {

	int id ; 
	String name;
	float balance ;
	final protected float commission_rate =0;
	final protected float interest_rate=0;
	Account accounts[]=new Account[5];
	Logger	logger ;


	public Clinet(int id, String name, float balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	//constructs a new client with zero accounts. Constructor also instantiates the Logger.

	public Clinet(Account[] accounts, Logger logger) {
		for (int i =0 ; i< accounts.length;i++) {
			accounts[i]=null;
		}
		this.accounts = accounts;
		this.logger = logger;
	}

	//get and set method
	public int getId() {
		return id;}

	public String getName() {
		return name;}

	public float getBalance() {
		return balance;}

	public Account[] getAccounts() {
		return accounts;}

	public void setName(String name) { 
		this.name = name;}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	//  add the account to the array and log the operation.


	public void addAccount(Account account ) {	

		//Account where the first null value is found.   
		for(int i =0 ;i <accounts.length;++i){

			Account acco =accounts[i];
			if (acco == null) {
				acco= account;
			}}
		//can not be able to add Accounts 
		for(int i =0 ;i <accounts.length;i++){

			Account acco =accounts[i];
			if (acco != null) {
				if (acco.id ==account.id ) {
					System.out.println("already exist");
				}}}


		//System.out.print(log1.getData());
		Log log =new Log(System.currentTimeMillis(), this.id, "accaount with id " +id +" added", balance);
		Logger.log(log); 

	}
	//Account – returns the account with the specified id or null if does not exist
	
	public Account getAccount(int id) {
		for(int i =0 ;i <accounts.length;++i){
		if( accounts[i].id== id) {
		
			return accounts[i];
		}	
		}
		return null;
	}

	//remove the account with the same id from the array

	public void remove_account (int id) {
      
		for(int i =0 ;i <accounts.length;++i){ 

			if (accounts[i].id ==id) {
		
				Log log =new Log(System.currentTimeMillis(), this.id, "accaount with id " +id +"  removed", balance);
				balance= balance+accounts[i].balance;
				accounts[i]=null; 
				Logger.log(log); 
				
			}
		}

	
		//System.out.print(log.getData());
		

	}



	public void deposit(float depositAmount) {

		if ( depositAmount>0.0  ) {
			float commisionAmount=commission_rate*depositAmount;
			Bank.updateTotalCommission(commisionAmount);
			balance +=depositAmount-(commisionAmount);
		}
	} 

	public void withDraw(float withDrawAmount) {

		if ( withDrawAmount>0.0 && balance>= withDrawAmount+commission_rate) {
			//clc com amount
			float commisionAmount=commission_rate*withDrawAmount;
			//add comm amount to bank balnace 
			Bank.updateTotalCommission(commisionAmount);
			//update clinlt balance and discount the comm amount 
			balance -= withDrawAmount+(commisionAmount );

		}
	}
	
	public void autoUpdateAccounts() {

		for(int i =0 ;i <accounts.length;++i){ 
			Log log =new Log(System.currentTimeMillis(), this.id, "accaount with id " +id +" updated ", balance);
			Account accoun =accounts[i];
			accounts[i].balance+= accounts[i].balance*interest_rate;
			Logger.log(log); 
			} 
		
		

		
	}

	//sum of client balance + total accounts balance.
	
	public float getFortune(){
		float sum=balance;
		for(int i =0 ;i <accounts.length;++i){ 
		sum+= balance+accounts[i].balance;
	 
	}
		return sum;	}


	@Override
	public boolean equals( Object obj ) {
		Clinet client = (Clinet)obj;//casting class (specific subclass)
  
		if( this.id == client.id ) {

			return true; 
		}  
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//String print = "";
		//print += "Clinet ID" + this.id +
		
		return super.toString();
	}




}












