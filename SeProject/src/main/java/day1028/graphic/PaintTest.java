/* 지금까지는 sun사의 개발자가 제공해준 그대로 컴포넌트들을 봐왔지만,
 * 우리가 컴포넌트의 그려지는 방식을 간섭하며, 원하는 그림으로 컴포넌트가
 * 보여지도록 처리해보자*/
package day1028.graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PaintTest extends JFrame{
	MyCanvas can;//도화지를 표현한 컴포넌트
	
	public PaintTest() {
		can = new MyCanvas();
		can.setBackground(Color.YELLOW);
		//캔버스에 그림을 그리려면, 캔버스가 스스로 그리는 메서드인 .paint()메서드 재정의
		
		add(can);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//현재 클래스인 PaintTest가 JFrame의 paint머세드를 오버라이드하면,
	//실행시 자식이 재정의한 메서드를 우선 순위로 호출(구현력은 자신클래스에)
	//
//	public void paint(Graphics g) {
//		System.out.println("스스로 그린다.");
//	}

	public static void main(String[] args) {
			new PaintTest();
	}

}
