package day1029.poly;

public class Sparrow extends Bird{
	String sound="짹짹";
	
	@Override
	public void fly() {
		System.out.println("참새 난다");
	}
	public void eat() {
		System.out.println("벌레 잇팅");
	}
}