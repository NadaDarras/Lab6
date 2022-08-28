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



	@Override
	public String toString() {
		return "Log [timestamp=" + timestamp + ", client_id=" + client_id + ", description=" + description + ", amount="
				+ amount + "]";
	}




	public static void main(String[] args) {




	}

}
