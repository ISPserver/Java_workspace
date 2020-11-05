package day1103.game;

import java.awt.Graphics;
import java.awt.Image;

public class Enemy extends GameObject{
	
	public Enemy(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);	
	}
	@Override
	public void tick() {
		//우측끝에서, 좌측으로 이동
		this.x += this.velX;
		//변경된 좌표는 즉시 사각형에 반영되어야, 총알과 적군이 충돌검사 가능
		rect.x=x; //상속
		rect.y=y;
	}
	@Override
	public void render(Graphics g2) {
		g2.drawRect(rect.x, rect.y, rect.width, rect.height);				
		//이미 가지고 있는 사각형을 시각화
		g2.drawImage(img, x, y, null);
		
	}
}
