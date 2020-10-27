/*1)글씨 크기 조절 Ctrl + (+,-)키
    2)폰트 window > Preferences > Appearance > Colors and Fonts > Basic > Text Font에서 Verdana 선택
    3)단축키 모두 보기 ctrl+shift+L
    4)자동 임포트: Ctrl+shift+O
    5)자동 코드 정렬: Ctrl + Shift + F
    6)해당 객체의 API 문서 바로가기: 해당 클래스 커서 올린 후, Shift+F2
    7)System.out.println ==> sout 치고 Ctrl+Space
    8)블럭 지정 후 Alt 키 누른상태에서 위 아래 누르면 이동
    9)블럭 지정 후 Ctrl+Alt+ 방향키 아래,위 --> 복사
    10)main 쓰고 컨트롤 스페이스
 * */
package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

public class RadioTest extends Frame {
	// 자바에서는 체크박스를 라디오로 사용함
	CheckboxGroup group;

	public RadioTest() {
		group = new CheckboxGroup();
		setLayout(new FlowLayout());
		this.add(new Checkbox("운동",group,false));
		this.add(new Checkbox("독서",group,false));
		this.add(new Checkbox("컴퓨터",group,false));
		this.add(new Checkbox("영화",group,false));
		this.add(new Checkbox("요리",group,false));
		this.add(new Checkbox("애견돌보기",group,true));
		
		setSize(300,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		System.out.println("커아리이");
		new RadioTest();

	}

}
