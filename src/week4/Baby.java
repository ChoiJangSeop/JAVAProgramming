package week4;

public class Baby {
		
		//Baby field
		private String name; //private valuable
		boolean gender;
		double weight = 5.0;
		int numPooops = 0;
		Baby[] siblings;
		
		//constructor
		Baby(String myName, boolean myGender) {
			name = myName;
			gender = myGender;
		}
		void SetName(String name) {
			name = name; //Self reference;
		}
		
		//Baby methods
		void sayHi() {
			System.out.println("Hi my name is..." + name);
		}
		
		void eat(double foodWeight) {
			if (foodWeight >= 0 && foodWeight < weight) {
				weight += foodWeight;
			}
		}
		
}
