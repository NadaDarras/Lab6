package Bnk;

public class Logger  {
	
	private static final Log[]log = null;
	
	String driverName;// will be empty string by now
	
	public Logger(String driverName) {
		super();
		this.driverName = driverName;
	}

	public  static void  log( Log log){
	System.out.print(log.toString());	
	}


    public Log[] getLogs() {
    return log;
    }



	
}
