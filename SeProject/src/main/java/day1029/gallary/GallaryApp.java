package day1029.gallary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GallaryApp extends JFrame{ 
	JLabel title;
	JPanel p_north;	
	//DetailPanel p_center;	
	JPanel p_center;
	JPanel p_south;
	JPanel p_west;
	JButton b_prev;
	JButton b_next;
	ThumbnailPanel p_thumb;
	String dir="C:/Users/tjdal/workspace/java_workspace/SeProject/res/travel2/";
	String[] path= {
			"aa.jpg","ab.jpg","ax.jpg","bm.jpg","et.jpg",
			"kg.jpg","mx.jpg","pk.jpg","ub.jpg","ya.jpg"};
	
	ThumbnailPanel[] can = new ThumbnailPanel[path.length];
	
	public GallaryApp() {
		//초기화
		title = new JLabel(path[0]);
		p_north = new JPanel();		
		p_south = new JPanel();
		p_west = new JPanel();		
		b_prev = new JButton("이전");
		b_next = new JButton("다음"); 
		p_center = new JPanel();
		
		p_west.setLayout(new FlowLayout());
		//조립
		for(int i=0; i<path.length; i++) {
			can[i] = new ThumbnailPanel(dir+path[i]);
			p_west.add(can[i]);
		}
		
		
		//패널에 부착
		p_north.add(title);
		p_south.add(b_prev);
		p_south.add(b_next);
		
		//프레임에 부착
		add(p_west, BorderLayout.WEST);
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);
		
		//설정
		setSize(1100,1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
	}
	
	
	public static void main(String[] args) {
		new GallaryApp();
	}	
	
}
