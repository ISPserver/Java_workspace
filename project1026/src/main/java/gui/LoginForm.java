package gui;
import java.awt.*;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Label;
public class LoginForm extends Frame {
	/*has a 관계는 맴버변수가 객체형일때를 의미한다. */
	Label la_id;
	Label la_pass;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_regist;
	Panel p_center;//센터에 붙일 패널(그리드 적용)
	Panel p_south; //남쪽에 붙일 패널(버튼 2개)
	public LoginForm() {
		//부품관계로 보유한 변수들을 모두 초기화 하자
		//특히 부품은, 이 객체가 태어날 때 같이 태어나야 하므로,생성자의 타이팅을 놓치지 말자 
		la_id = new Label("ID");
		la_pass = new Label("Password");
		t_id= new TextField(15);
		t_pass= new TextField(15);
		bt_login= new Button("Login");
		bt_regist= new Button("가입");
		p_center = new Panel();
		p_south = new Panel();
		/*this의 정확한 의미: 레퍼런스 변수이다. 단 나 자신의 인스턴스의 주소값*/
		//Frame은 디폴트가 BorderLayout이다.
		//처음보는 Color형 객체 대응법  --> 1)뭐하는 객체인지 파악 2)메모리에 올리는법(일반,추상,인터페이스)
		p_center.setBackground(new Color(153,255,0));
		this.add(p_center, BorderLayout.CENTER);		
		p_south.setBackground(Color.YELLOW);//상수
		this.add(p_south, BorderLayout.SOUTH);		
		//센터패널을 윈도우의 BorderLayout 센터에 넣자.
		//this.setLayout(new BorderLayout());필요없다.디폴트가 border라서
		//p_center에 그리드 적용
		p_center.setLayout(new GridLayout(2,2));
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		
		//Panel은 아무런 배치관리자를 적용하지 않으면 디폴트가 FlowLayout임
		p_south.add(bt_login);
		p_south.add(bt_regist);
		this.setSize(400,150);
		this.setVisible(true);
	}
	public static void main(String[] args) {		
		
		new LoginForm(); //Frame을 상속받았기 때문에 Login이 Frame임
	}
}
