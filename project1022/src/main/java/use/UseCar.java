package use;

import Car.Car;
import Car.Taxi;
import Car.Bus;
import Car.Truck;

public class UseCar {
	public static void main(String[] args) {
		//택시 인스턴스 생성,But 부모인 Car가 존재해야 택시도 존재 가능함으로,
		//Car 인스턴스도 자동 생성된다.
		Car c=new Car("ben");
		System.out.println(c.brand);
		Taxi t = new Taxi();
		t.pass();
		t.move(); //car는 부모라서 인스턴스화 하지 않아도 자동 인스턴스 된 것 증명
		System.out.println(c.brand);
	}

}
