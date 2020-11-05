/*
 * 주인공을 정의한다!!
 * */
package day1103.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JOptionPane;

public class Hero extends GameObject{
	GamePanel gamePanel;
	
	public Hero(GamePanel gamePanel, Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img,x,y,width,height,velX,velY);
		this.gamePanel= gamePanel;
	}
	//물리량 변화(데이터의 변화)
	public void tick() {
		this.x +=this.velX;
		this.y += this.velY;
		
		rect.x=x; //사각형의 위치
		rect.y=y; //사각형의 위치
		if(gamePanel.hpList.size()>=1) {
		collisionCheck();
		}else {
			gamePanel.over=true;
			gamePanel.flag=false;
		}
	}
	
	public void collisionCheck() {
		//주인공인 나와 다수의 적군과 교차여부를 판단, 교차했다면 HP삭제
		for(int i=0; i<gamePanel.enemyList.size(); i++) {			
			Enemy enemy = gamePanel.enemyList.get(i);			
			if(this.rect.intersects(enemy.rect)) {
				//나 죽고(List에서 제거하면, 더이상 tick(), render()호출이 일어나지 않아 화면에서 사라짐)
				gamePanel.hpList.remove(gamePanel.hpList.size()-1);				
				//적군 사망
				gamePanel.enemyList.remove(enemy);								
				break;
			}			
		}		
	}
	
	
	//그래픽 처리 (화면 그려질 처리)
	//모든 게임 케릭터는 패널에 그려야 하므로,  g2를 패널의  paint() 메서드
	//의 지역변수를 받아오자!!	
	public void render(Graphics g2) {		
		//g2.setColor(Color.RED);
		//g2.fillRect(rect.x, rect.y, rect.width, rect.height);		
		g2.drawRect(rect.x, rect.y, rect.width, rect.height);		
		
		//이미 가지고 있는 사각형을 시각화
		g2.drawImage(img, rect.x, rect.y, null);
		
	}
}