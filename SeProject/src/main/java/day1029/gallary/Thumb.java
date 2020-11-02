package day1029.gallary;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Thumb extends JPanel implements MouseListener{
	Toolkit kit;//플랫폼에 의존적인 경로를 이용할떄 툴킷이 필요
	Image img;			
	public static final int WIDTH=75;
	public static final int HEIGHT=55;	
	GallaryApp galleryApp;
	
	public Thumb(String src, GallaryApp galleryApp) {
		this.galleryApp = galleryApp; //injection 주입 받는다고 한다.
		kit = Toolkit.getDefaultToolkit();
		img= kit.createImage(src);
		img=img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));			
		
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);		
	}

	public void mouseReleased(MouseEvent e) {
		galleryApp.n=galleryApp.list.indexOf(this);
		galleryApp.updateData();
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	
}
