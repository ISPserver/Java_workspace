/*게임에 등장하는 모든 요소는 이 객체의 자식
 * 따라서 이 클래스에는 보편적인 특징만 보유해야 한다.
 */
package day1103.game;

import java.awt.Graphics;

public abstract class GameObject {
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	
	public GameObject(int x, int y, int width, int height, int velX, int velY) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.velX=velX;
		this.velY=velY;
	}
	public abstract void tick(); //하위 객체가 어떤 내용으로 물리량을 변화시킬지 부모인 현재 시점에선
											  //알수도 없고, 알아서도 안된다. 그래서 추상화
											  //자신의 상황에 맞게 재정의할 수 있다(오버라이딩)
	public abstract void render(Graphics g2);
}
