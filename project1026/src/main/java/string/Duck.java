package string;
/*자바의 모든~~~객체는 절대 피할 수 없는 최상위 객체를 상속받는다.
*/
public class Duck {
	String name="오리";
	
	
	public String toString() {
		System.out.println("toString() 동작");
		return "";
	}	
	
	public static void main(String[] args) {
		Duck d = new Duck();
		//System.out.println(d);//오리 자체가 아니라 주소값
		System.out.println(new Duck());//오리 자체 출력
	}
}
