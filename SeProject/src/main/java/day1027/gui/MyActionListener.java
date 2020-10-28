package day1027.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* 버튼에는 클릭, 텍스트박스엔 엔터 등 Action 이벤트 구현*/
public class MyActionListener implements ActionListener{
	JButton bt;
	JTextField t_input;
	JTextArea area;
	
	public MyActionListener(JButton bt,JTextField t_input,JTextArea area) {
		this.bt=bt;
		this.t_input=t_input;
		this.area=area;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bt) {
			String msg=t_input.getText();
			area.append(msg+"\n");
			t_input.setText("");						
		}
	}
	
}
