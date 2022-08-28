package Bnk;

public class Log {

	long timestamp; //describes the time of action occurrence
	int client_id ;//the client-Id owning this action
	String description;//short description of the action 
	float amount;// the amount of money of this action


	public Log(long timestamp, int client_id, String description, float amount) {
		super();
		this.timestamp =0;
		this.client_id = client_id;
		this.description = description;
		this.amount = amount;
	}


	public String getData(){
		return "Log [timestamp=" + timestamp + ", client_id=" + client_id + ", description=" + description + ", amount="
				+ amount + "]";
	}
	@Override
	public String toString() {
		return "Log [timestamp=" + timestamp + ", client_id=" + client_id + ", description=" + description + ", amount="
				+ amount + "]";
	}




	public static void main(String[] args) {

		System.out.println("view info ");
		Log log = new Log(28648235, 6373, " update – opened", 120000);
		System.out.println(log.getData());

		System.out.println("view info log");
		Logger logger= new Logger("null");
		Logger.log(log);

		Account account= new Account(7835, 137889890);
		System.out.println("\n account balance");
		account.setBalance(900000, log);


	}

}
