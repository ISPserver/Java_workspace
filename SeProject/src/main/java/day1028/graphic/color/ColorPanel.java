package day1028.graphic.color;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ColorPanel extends JPanel{
	Color bg;
	public void paint(Graphics g) {		
		this.setBackground(bg);
	}
}
