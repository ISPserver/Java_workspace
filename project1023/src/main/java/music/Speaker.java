/* 스피커를 정의*/
package music;
import riding.Wing;
//Speaker는 AudioDevice이자 Wing 이다 == is a 관계!
//서로 같은 자료형이다 -> 서로 간 형변환 가능(★★★★★)
public class Speaker extends AudioDevice implements Wing {
	/* 상속이란? 부모의 모든 재산을 자식이 물려받는 제도
	       부모클래스가 불완전한 추상클래스인 경우, 이건 재산이
	       아니라 빚더미다. 즉 부모의 추상적인 메서드의 완성을
	       자식에게 떠넘긴 것. 즉, 자식클래스에선 부모의
	       불완전한 메서드를 완전히 재정의해야 완전클래스 된다.
	       이런 제한 사항을 '구현강제'라고 한다.*/
	boolean ooper; //우퍼 지원 여부
	String color="red";
	
	public void sound() {
		/*pm의 부탁을 실수로 까먹음. 따라서 기능 누락된 상태임*/
	}
	//브레이스가 존재만 해도, 재정의 완성한것.
	public void setVolume() {
		System.out.println("볼륨 조절해요");
	}
	
	public void playMP3() {
		System.out.println("MP3 파일 실행");
	}
	public void fly() {
		System.out.println("하늘을 날아요");
	}
	public static void main() {
		
	}
}
