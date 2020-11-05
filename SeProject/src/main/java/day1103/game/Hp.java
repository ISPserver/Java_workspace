package day1103.game;

import java.awt.Graphics;
import java.awt.Image;

public class Hp extends GameObject{

	public Hp(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g2) {
		g2.drawImage(img, x, y, null);
	}
	
}
