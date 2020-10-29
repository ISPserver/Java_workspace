/* 多 다형성에 대해 다시 공부 */
package day1029.poly;

public class Bird {
	String name="난새";	
	String local="한국";
	
	public void fly() {
		System.out.println("새가 날아요");
	}
	
	public static void main(String[] args) {
		Bird b1 = new Bird();
		Bird b2 = new Duck();
		Bird b3 = new Sparrow();
	}
}
