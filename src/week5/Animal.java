package week5;

//2019310036 √÷¿Âº∑(Choi Jangseop)

public class Animal {

}

abstract class Mammal extends Animal 
{
	public static int numMammal = 0;	
	public static int getNumMammals() { return numMammal; }
}

abstract class Reptile extends Animal
{
	public static int numReptile = 0;
	public static int getNumReptile() {return numReptile; }
}

final class Dog extends Mammal 
{
	private String name;
	private float weight;
	private String nameMaster;
	
	Dog(String name, float weight)
	{
		this.name = name;
		this.weight = weight;
		this.numMammal += 1;
	}
	
	String getName() { return this.name; }
	void setName(String s) { this.name = s; }
	
	float getWeight() { return this.weight; }
	void setWeight(float w) { this.weight = w; }
	
	String getNameMaster() { return this.nameMaster; }
	void setNameMaster(String s) { this.nameMaster = s; }
	
	void bark() { System.out.println(this.name + " : bowwow"); }
	void bread() { this.numMammal += 5; }
	
}

final class Cat extends Mammal 
{
	private String name;
	private float weight;
	private String nameSlave;
	
	Cat(String name, float weight)
	{
		this.name = name;
		this.weight = weight;
		this.numMammal += 1;
	}
	
	String getName() { return this.name; }
	void setName(String s) { this.name = s; }
	
	float getWeight() { return this.weight; }
	void setWeight(float w) { this.weight = w; }
	
	String getNameSlave() { return this.nameSlave; }
	void setNameSlave(String s) { this.nameSlave = s; }
	
	void bread() { this.numMammal += 3; }
	void meow() { System.out.println(this.name + " : meow"); }
	void sleep() { System.out.println(this.name+ " : Zzz"); }
	
}

final class Crocodile extends Reptile
{
	private String name;
	private float weight;
	
	Crocodile(String name, float weight)
	{
		this.name = name;
		this.weight = weight;
		this.numReptile += 1;
	}
	
	String getName() { return this.name; }
	void setName(String s) { this.name = s; }
	
	float getWeight() { return this.weight; }
	void setWeight(float w) { this.weight = w; }
	
	void spawn() { this.numReptile += 20; }
}


