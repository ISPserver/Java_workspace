package day1029.wrapper;

public class WrapperApp {
	public static void main(String[] args) {
		String x="6";
		int y=4;
		int z=Integer.parseInt(x);
		System.out.println(x+y); //모두 String 여기 +는 연결자
		System.out.println(z+y);//int형
		
		Integer i = 5;//자바클래스원칙으론 불가능함. 하지만 기본자료형과 관련된 객체여서
		//마치 기본자료형처럼 데이터를 대입 할 수 있다.
		//사실상 내부적으로는 5라는 기본자료형이 객체화 된것.(Boxing:기본데이터를 박스로 감쌌다)
		//Wrapper 클래스는 box로 감싸다(wrapper)에서 근거한 말임
		
		int k=i;//기본자료형과 관련된 객체이므로, 내부적으로 inBoxing에 의해 기본자료형으로 변환이 된것
		//결론: 기본자료형을 --> 객체화 (Boxing),  객체자료형을--> 기본자료형(unBoxing)
		//box로 감싸고, 다시 꺼내는 객체를 가리켜 Wrapper 클래스라 부른다.
	}
}
