package day1103.game;

import java.awt.Graphics;
import java.awt.Image;

public class GameBg extends GameObject{
	GamePanel gamePanel;
	public GameBg(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		this.x += this.velX;
		
		if(this.x <= -gamePanel.WIDTH+3){
			this.x = gamePanel.WIDTH;
		}
		
		
	}@Override
	public void render(Graphics g2) {		
		g2.drawImage(img, x, y, null);	
	}

}
