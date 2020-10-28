package day1028.graphic.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicColorApp extends JFrame implements ActionListener{	
	JPanel container;
	ColorPanel p;
	JPanel red_box;
	JPanel orange_box;
	JPanel yellow_box;
	JPanel green_box;
	JPanel blue_box;
	JPanel deepBlue_box;
	JPanel puple_box;
	
	public GraphicColorApp() {
		//생성
		container = new JPanel();
		p=new ColorPanel();
		red_box = new JPanel();
		orange_box = new JPanel();
		yellow_box = new JPanel();
		green_box = new JPanel();
		blue_box = new JPanel();
		deepBlue_box = new JPanel();
		puple_box = new JPanel();
		
		//스타일
		red_box.setBackground(Color.red);
		red_box.setPreferredSize(new Dimension(100,100));
		orange_box.setBackground(Color.orange);
		orange_box.setPreferredSize(new Dimension(100,100));
		yellow_box.setBackground(Color.yellow);
		yellow_box.setPreferredSize(new Dimension(100,100));
		green_box.setBackground(Color.green);
		green_box.setPreferredSize(new Dimension(100,100));
		blue_box.setBackground(Color.CYAN);
		blue_box.setPreferredSize(new Dimension(100,100));
		deepBlue_box.setBackground(Color.blue);
		deepBlue_box.setPreferredSize(new Dimension(100,100));
		puple_box.setBackground(Color.magenta);
		puple_box.setPreferredSize(new Dimension(100,100));
		
		//조립
		container.add(red_box);
		container.add(orange_box);
		container.add(yellow_box);
		container.add(green_box);
		container.add(blue_box);
		container.add(deepBlue_box);
		container.add(puple_box);
				
		add(container,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
				
		
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==red_box) p.bg=Color.red;
		else if(obj==orange_box) p.bg=Color.orange;
		else if(obj==yellow_box) p.bg=Color.yellow;
		else if(obj==green_box) p.bg=Color.green;
		else if(obj==blue_box) p.bg=Color.cyan;
		else if(obj==deepBlue_box) p.bg=Color.blue;
		else if(obj==puple_box) p.bg=Color.magenta;
		
		p.repaint();
	}
	
	public static void main(String[] args) {
		new GraphicColorApp();
	}
}
