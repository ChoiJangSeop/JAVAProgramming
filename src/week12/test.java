package week12;

import java.util.Random;

public class test {
	
	public static void main(String[] args) {
		
		int num = 50;
		int a=0;
		int b=0;
		int tmp=0;
		int idx = 0;
		
		while (idx != 10 && a<6 && b<6) {
			
			Random random = new Random();
			
			tmp = random.nextInt(100);
			
			if(tmp < num)
				a++;
			else
				b++;
			++idx;
		}
		
		System.out.println(a + " " + b);
	}
}


