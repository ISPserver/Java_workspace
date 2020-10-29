package day1029.gallary;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ThumbnailPanel extends JPanel implements MouseListener{
	Toolkit kit;
	Image img;	
//	DetailPanel p_center;
	public ThumbnailPanel(String path) {
		kit = Toolkit.getDefaultToolkit();
		img= kit.createImage(path);
		this.setPreferredSize(new Dimension(100,100));
//		this.p_center=p_center;
		
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
		
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

	public void mouseReleased(MouseEvent e) {
		//p_center.setImg(img);
		//p_center.repaint();
	}
}
