package day1028.graphic.color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ThumbPanel extends JPanel implements MouseListener{
	JPanel p_center;
	Color color;
	public ThumbPanel(JPanel p_center, Color color) {
		this.p_center=p_center;
		this.color=color;
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(color);
		this.addMouseListener(this);//나와 리스너 연결
	}
	
	public void mouseClicked(MouseEvent e) {
				
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("클릭했다");
		p_center.setBackground(this.color);		
	}
}
