package machine;

public class Car {
	String name="Benz";
	int price=500;
	String color="red";
	Wheel wheel=null;
	
	//클래스명과 동일한 이름의 메서드를 가리켜 생성자라고 한다.
	//생성자는 이름에서 알 수 있듯이, 객체 생성타임에,무언가 초기화
	//작업이 있을때, 작업을 수행하는 용도의 메서드이다.
	public Car() {
		wheel=new Wheel();
	}
	
	public static void main(String[] args) {
		Car car= new Car();
		System.out.println(car.name);
		System.out.println(car.wheel.brand);
	}
}
