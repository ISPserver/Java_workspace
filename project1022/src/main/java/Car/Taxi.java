package Car;

public class Taxi extends Car{
	/*이미 Car를 상속받았으므로, 여기서도 마찬가지로 택시가 갖는 특징만 추가*/
	//Taxi 클래스의 디폴트 생성자에서는 무조건 super()가 들어있어서,매개변수 없는 생성자인
	//Car()를 호출하고 있는것과 같다.따라서 현재 Car에는 Car(String brand)만 존재하므로
	//생성자 호출시(super) 에러가 난다.
	
	//부모의 매개변수 있는 생성자를 직접 호출해주기 위해, 개발자가 생성자를 정의하고 있는것	
//	public Taxi() {
//		super("Benz");//Car가 매개변수를 갖고 있는 생성자를 정의했기때문
//	}
	public void pass() {
		System.out.println("승객을 태워요");
	}
}
