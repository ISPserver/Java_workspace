package project1019.Project1019;

public class UseCat {

	public static void main(String[] args) {
		Cat cat= new Cat();
		System.out.println(cat.name);
		System.out.println(cat.age);
		System.out.println(cat.married);
		
		cat.walking();
		cat.crying();

	}

}
