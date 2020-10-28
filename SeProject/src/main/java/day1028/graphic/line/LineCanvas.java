package day1028.graphic.line;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class LineCanvas extends Canvas{
	//default 접근제한자는 같은 패키지 존재하는 클래스에서 접근가능
	LineMaker lineMaker;// null
	int x1,y1,x2,y2;
	public void setLineMaker(LineMaker lineMaker) {
		this.lineMaker=lineMaker;
	}	
	
	public void paint(Graphics g) {
		x1=Integer.parseInt(lineMaker.x1.getText());
		y1=Integer.parseInt(lineMaker.y1.getText());
		x2=Integer.parseInt(lineMaker.x2.getText());
		y2=Integer.parseInt(lineMaker.y2.getText());
		
		g.drawLine(x1, y1, x2, y2);		
	}

	
}
