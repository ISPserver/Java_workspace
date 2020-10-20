package Project1020;

public class Dog {
	String name="도그";	
	int age=5;
	static String color="white";//이 변수는,
	//클래스로부터 생성된 인스턴스에 딸려올라가지 말고 원본에 붙어있어라.
	public void bark() {
		System.out.println("윅윅");
	}
	
	public static void main(String[] args) {
		color="black";
		
		int a=8;		
		Dog d1=new Dog();
		Dog d2=new Dog();
		
		d1.age=13;
		d2.age=7;
	}
}
