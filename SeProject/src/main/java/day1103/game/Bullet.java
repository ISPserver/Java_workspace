package day1103.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject{
	GamePanel gamePanel;
	
	public Bullet(GamePanel gamePanel, Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img,x, y, width, height, velX, velY);
		this.gamePanel= gamePanel;
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		this.x += this.velX;
		
		rect.x=x;
		rect.y=y;
		//화면밖으로 총알이 나가면, 화살을 BulletArray에서 제거해야,그려질 대상이 되지 않음
		//BulletArray의 크기를 줄여놔야, 충돌검사시 반복문 횟수 줄일 수 있음
		if(this.x > GamePanel.WIDTH) {
			gamePanel.bulletList.remove(this);
		}
		
		//충돌과 기타 오브젝트와의 충돌검사
		collisionCheck();
	}
	public void collisionCheck() {
		//총알인 나와 다수의 적군과 교차여부를 판단, 교차했다면 (총알,적군)삭제 , 점수+10
		for(int i=0; i<gamePanel.enemyList.size(); i++) {
			Enemy enemy = gamePanel.enemyList.get(i);
			if(this.rect.intersects(enemy.rect)) {
				//나 죽고(List에서 제거하면, 더이상 tick(), render()호출이 일어나지 않아 화면에서 사라짐)
				gamePanel.bulletList.remove(this);
				
				//적군 사망
				gamePanel.enemyList.remove(enemy);
				
				//점수 증가
				gamePanel.score += 10;
				break;
			}			
		}		
		
		for(int i=0; i<gamePanel.blockList.size(); i++) {
			Block block = gamePanel.blockList.get(i);
			if(this.rect.intersects(block.rect)) {
				//나 죽고(List에서 제거하면, 더이상 tick(), render()호출이 일어나지 않아 화면에서 사라짐)
				gamePanel.bulletList.remove(this);
				
				//적군 사망
				gamePanel.blockList.remove(block);
				break;
			}
			
		}		
		
	}
	

	public void render(Graphics g2) {		
		g2.drawRect(rect.x, rect.y, rect.width, rect.height);				
		g2.drawImage(img, x, y, null);		
		
	}
	
}
