package day1102.inner;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class foo{
	static void a() { }
	void beta() { }
}
public class TestApp extends JFrame{
	Canvas can;
	JButton bt;
	JTextField t;
	public TestApp() {
		//캔버스를 현재 클래스에서만 사용하고, 추후 재사용성이 없을경우
		//굳이 거푸집 즉, (.java)로 정의할 이유가 있을까??
		//이럴땐, 일회성의 객체사용인 경우 내부익명 클래스로 사용할 수 있다.
		//★★★inner Anonymous Class '내부익명클래스'라고 함
		//주로 이벤트를 구현한 클래스는 해당 어플리케이션에서만 사용되므로, 재사용성 없다.
		//따라서 내부익명클래스로 많이 사용된다.
		can = new Canvas() {
			public void paint(Graphics g) {
				g.drawLine(0, 0, 100, 100);
			}
		};
		
		setLayout(new FlowLayout());
		
		add(bt = new JButton() {
			@Override
			public void paint(Graphics g) {
				g.setColor(Color.RED);
				g.fillRect(0, 0, 100, 40);
			}
		});
		
		add(can);
		add(t = new JTextField(20));
		
		//내부익명클래스는 자신을 포함하고 있는 바깥쪽 클래스의 멤버변수를
		//접근할 수 있다.
		t.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				System.out.println("키 누름");
			}
		});
		
		//내부익명클래스는 지연변수가 final로 된것만 접근 가능
		final int x=0;
		
		bt.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				System.out.println(x+"나 눌렀어?");				
			}
		});
		
		//윈도우 이벤트 연결
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		can.setPreferredSize(new Dimension(300,300));
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TestApp();		
	}
}
