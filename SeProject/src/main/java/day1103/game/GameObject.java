/*게임에 등장하는 모든 요소는 이 객체의 자식
 * 따라서 이 클래스에는 보편적인 특징만 보유해야 한다.
 */
package day1103.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {
	Image img;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	//충돌검사를 위해서는 모든 객체가 사각형을 보유해야 한다.
	//Rectangle 객체에서 자체 충돌검사 메서드를 제공해주기 때문이다.
	Rectangle rect;
	
	public GameObject(Image img, int x, int y, int width, int height, int velX, int velY) {
		this.img=img;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.velX=velX;
		this.velY=velY;
		rect = new Rectangle(x,y,width,height); //사각형 생성(충돌검사 위해)
	}
	public abstract void tick(); //하위 객체가 어떤 내용으로 물리량을 변화시킬지 부모인 현재 시점에선
											  //알수도 없고, 알아서도 안된다. 그래서 추상화
											  //자신의 상황에 맞게 재정의할 수 있다(오버라이딩)
	public abstract void render(Graphics g2);
}
