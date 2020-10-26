package gui;
/* 각종 컴포넌트를 올려놓기 전에, 어떤 방식으로 올려놓을지를 결정하는 것을 '배치'라고 하며,
 AWT에서 지원하는 배치는 다음과 같이 5가지 유형이 있다.
 1)FlowLayout: 행 방향으로 늘어서는 배치방식, 만일 공간이 부족하면 다음 행으로 내려감.
 			    컨테이너의 크기에 따라 흐르듯 배치되서 Flow라는 뜻.
 2)BorderLayout: 북,동,서,남,중앙 이라는 방위를 갖는 배치방법
 3)GridLayout: 격자 즉 바둑판 모양의 배치방법
 4)CardLayout: 카드처럼 하나의 카드가 보일때는 다른 카드가 안보이는 방식의 배치
 5)GridBagLayout: GridLayout을 보다 상세하게 제어할 수 있는 배치방식
  
 사실상 1,2,3번만으로도 충분히 개발 가능함 			    
 */
import java.awt.Frame;
import java.awt.Button;
import java.awt.BorderLayout;
public class BorderTest {
	public static void main(String[] args) {
		//Frame생성
		Frame frame = new Frame();
		//BorderLayout 학습
		Button bt_north=new Button("North");
		Button bt_south=new Button("South");
		Button bt_west=new Button("West");
		Button bt_east=new Button("East");
		Button bt_center=new Button("Center");
		
		//배치방법 결정
		
		//1.BorderLayout 적용
		frame.setLayout(new BorderLayout());
		
		//버튼을 프레임에 붙이기
		//frame.add(bt_north, BorderLayout.NORTH);
		frame.add(bt_south, BorderLayout.SOUTH);
		frame.add(bt_west, BorderLayout.WEST);
		frame.add(bt_east, BorderLayout.EAST);
		//센터는 명시하지 않아도 디폴트이기 때문에 적용된다.
		frame.add(bt_center, BorderLayout.CENTER);
		
		//프레임 setting
		frame.setSize(250,200);
		frame.setVisible(true);
	}
}
