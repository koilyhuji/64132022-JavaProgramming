 
public class App {

	public static void main(String[] args) {
		Cat c= new Cat("yellow", false);
		Dog d = new Dog("bukker", true);
		System.out.println(c.toString());
		System.out.println(d.toString());
		
		// ?
		IAnimal c1= new Cat("yellow I", false);
		IAnimal d1 = new Dog("bukker I", true);
		System.out.println(c1.toString());
		System.out.println(d1.toString());
		
	}

}
