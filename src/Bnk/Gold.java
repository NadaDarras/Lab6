package Bnk;

public class Gold extends Clinet{
	final  float   commisionRate=(float)0.02;
	final  float	interstRate=(float)0.03;

	public Gold(int id, String name, float balance) {
		super(id, name, balance);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "client type: gold \n  client id : "+id;
	}


}
