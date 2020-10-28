package day1028.graphic.line;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LineMaker extends JFrame {
	MyButton bt;
	JLabel l_x1,l_y1,l_x2,l_y2;
	JTextField x1,y1,x2,y2;	
	JPanel p;
	LineCanvas can;
	int x11,y11,x22,y22;
	
	public LineMaker() {
		super("선 그리기 어플리케이션");
		//생성
		p=new JPanel();		
		bt= new MyButton("커스텀버튼");
		l_x1=new JLabel("x1");
		l_y1=new JLabel("y1");
		l_x2=new JLabel("x2");
		l_y2=new JLabel("y2");
		
		x1=new JTextField("0",10);
		y1=new JTextField("0",10);
		x2=new JTextField("0",10);
		y2=new JTextField("0",10);
		can=new LineCanvas();
		can.setLineMaker(this);//캔버스에게 나의 주소값 넘기기
		//스타일
		can.setBackground(Color.yellow);
		
		//조립
		p.add(l_x1);
		p.add(x1);
		p.add(l_y1);
		p.add(y1);
		p.add(l_x2);
		p.add(x2);
		p.add(l_y2);
		p.add(y2);
		p.add(bt);				
					
		add(p, BorderLayout.NORTH);
		add(can, BorderLayout.CENTER);			
		
		//버튼과 리스너 연결
		bt.addActionListener(new MyListener(can));
		
		//윈도우와 관련된 속성 지정
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	
	public static void main(String[] args) {
		new LineMaker();
	}

}
