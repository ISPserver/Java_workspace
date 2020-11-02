package day1029.gallary;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//상세이미지가 그려질 패널, 이 패널을 클래스로 별도로 정의하는 이유는?
//paint 메서드를 재정의 하기 위함.
public class XCanvas extends Canvas{
	private Toolkit kit = Toolkit.getDefaultToolkit();
	private Image img;
	private String src;
	
	public XCanvas(String src) {		
		img=kit.getImage(src);
		img=img.getScaledInstance(660, 450, Image.SCALE_SMOOTH);
		setPreferredSize(new Dimension(660,450));
		setBackground(Color.gray);
	}
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		img=kit.getImage(src);		
		img=img.getScaledInstance(660, 450, Image.SCALE_SMOOTH);
		this.src = src;
	}


	@Override
	public void paint(Graphics g) {
		g.drawImage(img,0,0, this);
	}
}
