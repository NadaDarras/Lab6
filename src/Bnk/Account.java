package Bnk;

public class Account {
	int id ; 
	float balance ; 

	public Account(int id, float balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public float getBalance() {
		return balance;
	}
	Logger logger;
	public void setBalance(float balance) {
		this.balance = balance;
		Log log =new Log(System.currentTimeMillis(), this.id, "accaount with id " +id +" balance ", balance);

		Logger.log(log); 
		//System.out.print(log.getData());	
	}
	/*	public void  log(Log log ){
	System.out.print(log.getData());	
	}*/

	@Override
	public boolean equals( Object obj ) {

		if( this == obj) {

			return true; 
		}  
		return false;
	}






}
