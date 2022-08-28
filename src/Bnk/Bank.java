package Bnk;



public class Bank {
	private static Bank singleBank= null;// for singelton
	private static	Clinet[] clients;
	private static Logger logService;
	private static 	Account updater;

	private static float totalCommission ;

	private Bank() {

		Bank.clients =new Clinet [100];
	} 

	// create one object of bank 
	public static Bank getBank () {
		if (singleBank== null) {
			singleBank=new Bank() ;
		}
		return singleBank;
	} 



	public  static float getBalance() {
		float bankBalance = 0;
		for ( int i=0;i<clients.length;i++) {
			bankBalance+= clients[i].balance+clients[i].getFortune();;
		}

		return  bankBalance;
	}

	public  static void  addClient(Clinet client ) {	

		//Account where the first null value is found.   
		for(int i =0 ;i <clients.length;++i){
			Log log =new Log(System.currentTimeMillis(), client.id, "added client with id " + client.id +" added", client.balance);

			Clinet cli =clients[i];
			if (cli== null) {
				cli=client;
				Logger.log(log); 
			}}



		//System.out.print(log.getData());
	}



	public static  Clinet[] getClients() {

		return  clients;

	} 

	//prints all logs that are stored in the logger
	public  static void viewLogs () {

		Log []log = logService.getLogs();


	}

	public static void startAccountUpdater() {

	}




	public  static void printClientList() {

	}



	public static void removeClient(Clinet clin) {
		for(int i =0 ;i <clients.length;++i){ 

			if (clients[i].equals(clin)) {
				Log log =new Log(System.currentTimeMillis(),clients[i].getId() , "remove client with id " + clients[i].getId() +" added", clients[i].getBalance());

				clients[i]=null; 
				Logger.log(log);
				break;
			}

		}
	}

	//update comm. from clint class 
	public static void updateTotalCommission( float comision) {

		totalCommission= totalCommission+ comision;

	}



}

