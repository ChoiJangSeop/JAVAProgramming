package week8;

import java.io.*;
import java.util.Scanner;

class OutOfRangeException extends Exception {
	OutOfRangeException() {}
	
}

class AddZeroException extends Exception {
	AddZeroException() {}
}

class SubstractZeroException extends Exception {
	SubstractZeroException() {}
}

public class SimpleCalculator {

	int result;		//range of result : 0~1000
	
	SimpleCalculator() { this.result = 0; }
	
	void add(int a, int b) throws OutOfRangeException, AddZeroException  { 
			
		if (a==0 || b==0) { throw new AddZeroException(); }
		
		else if (a+b >= 0 && a+b <= 1000)
			this.result = a + b;
	
		else { throw new OutOfRangeException(); }
	}
	
	void subtract(int a, int b) throws OutOfRangeException, SubstractZeroException { 
				
		if (a==0 || b==0) { throw new SubstractZeroException(); }
			
		else if (a-b >= 0 && a-b <= 1000)
			this.result = a - b;
	
		else { throw new OutOfRangeException(); }		
	}
	
	void print() { System.out.println(this.result); } 
	void reset() { this.result = 0; }
	int getResult() { return result; }
	
	void setResult() throws OutOfRangeException, IOException { 

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		if (a >= 0 && a<= 1000)
			this.result = a;

		else { throw new OutOfRangeException(); }
	}
	
	public static void main(String[] args) {
		
		try {
			SimpleCalculator Casio = new SimpleCalculator();
		
			Scanner sc1 = new Scanner(System.in);
			int a = sc1.nextInt();
			
			Scanner sc2 = new Scanner(System.in);
			int b = sc2.nextInt();
			
			Scanner sc3 = new Scanner(System.in);
			int c = sc3.nextInt();
			
			Scanner sc4 = new Scanner(System.in);
			int d = sc4.nextInt();
			
			Casio.add(a, b);
			Casio.print();
	
			
			Casio.subtract(c, d);
			Casio.print();
			
			Casio.setResult();
			Casio.print();
			
		} 
		catch (OutOfRangeException e1) {
			System.out.println("Out of Range! The range of result is from 0 to 1000!");
			e1.printStackTrace();
		}
		catch (IOException e2) {
			e2.printStackTrace();
		}
		catch (SubstractZeroException e3) {
			System.out.println("You cannot substract to 0!!!");
			e3.printStackTrace();
		}
		catch (AddZeroException e4) {
			System.out.println("You cannot add to 0!!!");
			e4.printStackTrace();
		}
	}
}
