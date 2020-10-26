package event;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.Window;

public class MyWin extends Frame {//MyWin is a Frame
	Button bt; //MyWin Has a Button
	TextField t;
	Choice ch;//html에서의 select 박스와 동일
	
	public MyWin() {
		bt = new Button("Click");
		t = new TextField(15);
		ch = new Choice();		
		
		//ch의 아이템 채우기
		ch.add("Java Programming");
		ch.add("JSP Programming");
		ch.add("Android Programming");
		ch.add("Spring Programming");
		ch.add("Mybatis Programming");
		
		this.setLayout(new FlowLayout());		
		this.add(bt); //프레임은 디폴트가 BorderLayout, 센터영역
		this.add(t);
		this.add(ch);
		
		//★★★버튼과 리스너 연결★★★
		bt.addActionListener(new MyListener());
		t.addKeyListener(new Mykey());
		this.addMouseListener(new MyMouse());
		ch.addItemListener(new MyItem());
		addWindowListener(new MyWindowListener());
		
		this.setSize(300,400);
		this.setVisible(true);		
	}
	public static void main(String[] args) {
		new MyWin();
	}
}
