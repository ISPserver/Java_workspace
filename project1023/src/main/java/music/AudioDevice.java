/*32명의 개발자가  아직 개발코드를 작성하지도 않은 시점이기 때문에
 * 현재 클래스에는 반드시 구현해야할 기능을 명시*/
package music;

abstract public class AudioDevice {
	//볼륨 조절 기능
	//static과 같이 수정자로 불리는 또 한가지 = abstract(추상화)
	//메서드에 abstract 할 경우 {}없는 불완전한 메서드
	//불완전한 메서드를 단 1개라도 갖고 있다면, 그 클래스는 불완전한
	//클래스이며, 추상클래스 라고 한다.
	abstract public void setVolume(); //추상메서드라 한다.
	abstract public void playMP3();	
	//MP실행 기능
}
