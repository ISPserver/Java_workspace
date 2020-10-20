package Project1020;

public class InitialBlock {
	//멤버영역안에 {지역화}시켰을때 의미는?
	{
		//이 클래스의 인스턴스가 생성될때마다 이 영역 호출
		//'인스턴스 초기화 블럭'이라고 한다.
		System.out.println("인스턴스 초기화 블럭 호출");
	}
	//static 초기화 블럭
	//main() 메서드에 의해 실행 직전에, 실행되는 초기화 블럭
	static {
		System.out.println("실행전 초기화블럭 실행 A");
	}

	public static void main(String[] args) {
		System.out.println("B");
		new InitialBlock();//호출할때마다 인스턴스초기화블럭 호출됨
		new InitialBlock();
		new InitialBlock();

	}

}
