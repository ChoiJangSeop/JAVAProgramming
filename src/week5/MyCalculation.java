package week5;

class Calculation {
	
	int z;
	
	public void add (int x, int y) {
		z= x + y;
		System.out.println("The sum of the given number : " + z);
	}
	
	public void subtract(int x, int y) {
		z = x - y;
		System.out.println("The difference between the given numbers : " + z);
	}
}

public class MyCalculation extends Calculation {
	
	public void add(int x, int y) {
		z = x + y;
		System.out.println("The super sum of the given number : " + z);
	}
	
	public void dispaly(int x, int y) {
		this.add(x, y);
		super.add(x, y);
	}
}
