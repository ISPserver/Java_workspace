package gui;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Image;
import java.awt.Toolkit;

public class App1 {
	public static void main(String[] args) {
		/* 윈도우 생성 */
		/*처음보는 클래스 봤을때 대처법
		대응,대처0) "사용하려는 클래스가 대충 어떤 목적으로 지원되는것인지 용도 파악"
		대응,대처1) "자바의 모든 객체는 결국 3가지 유형밖에 없다"
		대응,대처2) "클래스는 쓰라고 만든것, 따라서 메모리에 올리는 법을 알면 된다.
		1) 일반클래스: new 하면 된다!new 뒤의 생성자 조사(API.doc 통해서) 
		2) 추상클래스 :new 불가, 자식 정의해서 new하거나 이미 구현한 인스턴스 이용(API.doc 통해)
		3) 인터페이스:new 불가, 자식 정의해서 new하거나 이미 구현한 인스턴스 이용(API.doc 통해)
		*/
		//처음보지만, 일반이기 때문에, new 다음에 오는 생성자 조사해서 사용
		Frame frame=new Frame();
		frame.setVisible(true);//Window 객체로부터 상속받은 메서드
		//매개변수로는 논리값을 사용할 수 있다.
		//윈도우의 너비,높이를 지정할 수 있는 메서드 찾기
		frame.setSize(300, 400);
		
		//윈도우가 생성되었으므로, 윈도우 안에 배치할 각종 컴포넌트 등록
		Button bt=new Button("버튼");
		//버튼을 부착하기 전에 레이아웃 스타일을 지정해야함. 일단 FlowLayout을 사용해보자
		FlowLayout flow= new FlowLayout();
		frame.setLayout(flow);
		frame.add(bt); //add 메서드의 매개변수는 Component형이므로,
		//Button도 Component의 자식이기 때문에 같은 자료형에 해당하여, add()의 인수로 올 수 있다.
		
		//html에서의 input type="text"는 자바에서는 TextField라 한다.
		TextField t = new TextField("회원정보",10);
		frame.add(t);
		//CheckBox
		Checkbox ch1 = new Checkbox("독서");
		Checkbox ch2 = new Checkbox("수영");
		Checkbox ch3 = new Checkbox("컴퓨터");
		frame.add(ch1); frame.add(ch2); frame.add(ch3);
		//TextArea
		TextArea text_area = new TextArea(5,20);
		frame.add(text_area);
		
		//그냥 텍스트
		Label la = new Label("회원가입양식입니다.");
		frame.add(la);
		
		//이미지 넣기
		//Image는 추상클래스이며, 플랫폼(win,mac,linux)이 지정한 방식으로 얻을 수 있다.
		//플랫폼에 맞게 가져오려면, DefaultToolkit 클래스로부터 자원을 얻어야 한다.
		Toolkit kit=Toolkit.getDefaultToolkit();//static 메서드! 따라서 클래스명으로 접근할 수 있다.

		//툴킷은 이미지를 로컬상의 경로로부터 얻어올 수 있다.
		//경로 주의: 역슬래시는 윈도우에서만 사용하는 표기이므로, 중립적인 경로로 가야한다.
		Image img= kit.getImage("C:/Users/tjdal/workspace/java_workspace/project1026/src/main/java/res/4.png");
		//화면에 출력하는 것은 자바와 같은 일반적인 컴파일 기반의 프로그래밍 언어에서는
		//렌더잉(그리는 작업)을 해야 하기 때문이다.
		System.out.println("이미지 주소는"+img);
	}
}
