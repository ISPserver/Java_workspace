package gui;
import java.awt.Frame;
import java.awt.Button;
public class AppTest {
	public static void main(String[] args) {
		//자바에서는 윈도우의 역할을 해주는 클래스로 Frame을 지원한다.
		Frame frame;//sun에서 제작한 클래스라서, 원본도 없다.
		//따라서 sun 에서 제공하는 공식문서를 보고 위치를
		frame = new Frame();//윈도우 생성
		frame.setSize(300,400);//윈도우에 너비,높이 초기화
		frame.setVisible(true);//프레임의 속성을 보이게 처리
		
		//버튼 생성해 프레임에 붙이기
		Button bt= new Button();
		frame.add(bt);
	}
}
