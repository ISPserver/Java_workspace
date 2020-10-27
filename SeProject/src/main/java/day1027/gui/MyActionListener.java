package day1027.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 버튼에는 클릭, 텍스트박스엔 엔터 등 Action 이벤트 구현*/
public class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("나 눌렀어?");
	}
	
}
