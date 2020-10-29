package day1029.poly;

public class Duck extends Bird{
	String color="white";
	
	//부모의 메서드를 재정의
	@Override
	public void fly() {
		System.out.println("오리 난다");
	}
	
	public void quack() {
		System.out.println("빽뺵");
		
	}
}
