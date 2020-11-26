package week5;

public class main {
	public static void main(String[] args) {
		
		Cat cat_1 = new Cat("cat1", 1.1f);
		Cat cat_2 = new Cat("cat2", 1.3f);
		Dog dog_1 = new Dog("dog1", 2.4f);
		Dog dog_2 = new Dog("dog2", 11.5f);
		Crocodile coroco_1 = new Crocodile("croco1", 23.4f);
		
		dog_1.bread();
		cat_2.meow();
		cat_1.sleep();
		dog_2.bark();
		
		System.out.println("the number of mammals is... " + Mammal.getNumMammals() );
		System.out.println("the number of reptile is... " + Reptile.getNumReptile());
		System.out.println("the name of cat_1 is..." + cat_1.getName());
		
	}
}
