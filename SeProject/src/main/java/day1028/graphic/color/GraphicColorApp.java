package day1028.graphic.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicColorApp extends JFrame{	
	JPanel p_north;
	JPanel p_center;
	ThumbPanel[] thumb = new ThumbPanel[7];
	//7가지 색상을 배열로 보유하자(반복문마다 틀린 색을 사용해야 하기 때문)
	Color[] colorArray= {
			Color.RED,Color.ORANGE,Color.YELLOW,Color.green,Color.blue,Color.cyan,Color.pink
	};
	
	public GraphicColorApp() {
		//생성
		p_north=new JPanel();
		p_center = new JPanel();
		
		for(int i=0; i<thumb.length; i++) {
			thumb[i]= new ThumbPanel(p_center,colorArray[i]);
			p_north.add(thumb[i]);
		}
		p_center.setBackground(Color.white);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	
	public static void main(String[] args) {
		new GraphicColorApp();
	}
}
