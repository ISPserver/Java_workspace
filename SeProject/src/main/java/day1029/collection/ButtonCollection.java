package day1029.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCollection extends JFrame implements ActionListener{
	JButton bt_create,bt_bg;
	JPanel p_north,p_center;	
	//배열의 가장 큰 특징, 배열은 생성시 반드시 크기를 명시해야한다.
	//JButton[] btn = new JButton[10000]; 따라서 불가능
	ArrayList<JButton> btn = new ArrayList<JButton>();
	public ButtonCollection() {
		//초기화
		p_north = new JPanel();
		p_center = new JPanel();
		bt_create = new JButton("버튼생성");
		bt_bg = new JButton("배경색");
				
		p_north.add(bt_create);
		p_north.add(bt_bg);
		
		//프레임에 부착
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		p_center.setLayout(new FlowLayout());
		
		//버튼과 리스너 연결
		bt_create.addActionListener(this);
		bt_bg.addActionListener(this);
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {		
		Object obj = e.getSource();//이벤트 일으킨 컴포넌트 반환
		if(obj==bt_create) {
			create();
		}else if(obj==bt_bg) {
			setBg();
		}		
	}
	
	public void create() {
		//버튼 생성하여 p_center에 부착
		JButton bt = new CustomButton();
		p_center.add(bt);
		
		//리스트에 추가한다. 
		btn.add(bt);
		bt.setText("버튼"+Integer.toString(btn.size()));
		//p_center에 버튼을 그린게 아니라, 추가한 것이다
		//따라서 이때는 p_center를 갱신하면 된다. updateUI()
		p_center.updateUI();		
	}	
	
	public void setBg() {
		//btn리스트에 들어있는 모든 요소를 대상으로 배경색 바꾸기
		for(int i=0; i<btn.size(); i++) {
			JButton bt=btn.get(i); //리스트에서 끌어내기
			bt.setBackground(Color.yellow);
		}
	}
	
	public static void main(String[] args) {
		new ButtonCollection();
	}
}
