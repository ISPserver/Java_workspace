package day1103.game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends GameObject{

	public Bullet(int x, int y, int width, int height, int velX, int velY) {
		super(x, y, width, height, velX, velY);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		this.x += this.velX;
		
	}

	public void render(Graphics g2) {
		g2.setColor(Color.BLACK);
		g2.fillOval(x, y, width, height);
		
	}
	
}
