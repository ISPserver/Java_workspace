package Car;

//이 클래스는 모든 자동차류의 최상위 클래스
public class Car {	
	public String brand; //제조사=정해져 있으면 안되서 초기화x
	
//	public Car() {
//		System.out.println("자식의 super()로 호출됨");
//	}
	
	//개발자가 매개변수 있는 생성자만 정의함
	//개발자가 컴파일러에 의한 디폴트 생성자 자동삽입은 없어짐
	//따라서 Car 클래스는 생성자가 오직 딱 1개만 있게 됨
	public Car(String brand) {//매개변수가 있는 생성자라 new Car("벤츠")이런식으로 호출해야함
		this.brand=brand;
	}
	public Car() {//매개변수가 없는 생성자도 추가하면 자식클래스에서는 ?
		//이렇게 디폴트 생성자를 명시하면 자식클래스에서도 super()호출시, 이걸 호출해서
		//에러가 안나게 됨
	}
	public void move() {//자동차 필수 요건
		System.out.println("자동차가 갑니다");
	}	
}
