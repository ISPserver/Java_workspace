package day1029.graphic.image;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePickerApp extends JFrame{
	JPanel p_north;	
	DetailPanel p_center;
		
	String dir="C:/Users/tjdal/workspace/java_workspace/SeProject/res/travel2/";
	String[] path= {
			"aa.jpg",
			"ab.jpg",
			"ax.jpg",
			"bm.jpg",
			"et.jpg",
			"kg.jpg",
			"mx.jpg",
			"pk.jpg",
			"ub.jpg",
			"ya.jpg"
	};	
	ImagePanel[] can = new ImagePanel[path.length];
	
	public ImagePickerApp() {
		p_north = new JPanel();		
		p_center = new DetailPanel();
		
		//조립
		for(int i=0; i<path.length; i++) {
			can[i] = new ImagePanel(dir+path[i],p_center);
			p_north.add(can[i]);
		}
		
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		setSize(770,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	
	public static void main(String[] args) {
		new ImagePickerApp();
	}
}
