package day1029.graphic.image;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ImagePanel extends Canvas implements MouseListener{
	Toolkit kit;
	Image img;
	DetailPanel p_center;
	
	public ImagePanel(String path, DetailPanel p_center) {
		kit = Toolkit.getDefaultToolkit();//static 메서드 호출
		img = kit.getImage(path);
		this.setPreferredSize(new Dimension(100,100));
		this.p_center=p_center;
		
		this.addMouseListener(this);
	}
		
	public void paint(Graphics g) {
		g.drawImage(img,0,0,this);
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//p_center패널에 이미지를 그리되, 현재 나의 이미지를 가지고
		//p_center에게 img를 넘겨줘야함
		p_center.setImg(img);
		p_center.repaint(); //다시 그려라--> update()화면 지우기-> paint()
	}
}
