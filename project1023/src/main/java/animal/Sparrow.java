package animal;

public class Sparrow extends Bird {
	String name="난 참새";
	
	public void jjack() {
		System.out.println("짹짹");
	}
	//자식클래스에서 부모와 100% 동일한 메서드를 정의하는 기법을
	//오버라이딩 이라고 한다.
	//부모의 메서드를 자식에서 기능 변경,추가 하는등의 업그레이드
	
	/*주의
	 오버로딩 vs 오버라이딩
	 !!오버로딩은 같은 클래스내 기능이 비슷한 메서드명을 같이만들되,
	매개변수 갯수와 자료형으로 구분하면 중복 정의 인정해주는 것.
	 !!오버라이딩은 상속관계에서 자식이 부모의 메서드를 재정의하는 기법
	*/
	public void fly() {		
		System.out.println("자유롭게 저 하늘을2");		
	}
	
	public static void main(String[] args) {
		Sparrow sp = new Sparrow();		
		sp.fly(); // 참새의 메서드 호출
		
		Bird bird = new Bird();
		bird.fly(); //부모인 새의 메서드 호출
		
		Bird bird2 = new Sparrow();
		bird2.fly();
	}
}
