package event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MultiActionListener implements ActionListener{
	//이 메서드로 , 눌러진 모든 버튼의 정보가 넘어온다!
	public void actionPerformed(ActionEvent e) {
		//유저가 발생시킨 이벤트에 대해 모든 정보가 Event인스턴스로 전달되어 지므로
		//어떤 버튼이 눌렸는지도 알 수 있다.
		System.out.println(e);
		
		//이벤트 객체의 메서드 중에, 이벤트를 일으킨 컴포넌트(이벤트 소스)를 추출하는 메서드
		if(e.getSource()== this){
			
		}
	}
}
