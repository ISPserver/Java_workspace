package day1028.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient2 extends JFrame implements KeyListener{
											// 	 is a							is a
		JTextArea area;
		JScrollPane scroll;
		JPanel p_south;
		JTextField t_input;
		JButton bt;
		ChatClient ch;
		public ChatClient2(ChatClient ch) {		
			//생성
			this.ch=ch;
			area = new JTextArea();
			scroll= new JScrollPane(area);
			p_south=new JPanel();
			t_input = new JTextField(15);		
			bt=new JButton("SEND");			
			//패널 조립(패널은 Default가 FLowLayout)
			//p_south.setLayout(new FlowLayout());
			p_south.add(t_input);
			p_south.add(bt);
			
			add(scroll);//센터에 스크롤 부착
			add(p_south,BorderLayout.SOUTH);//남쪽에 패널부착
			
			//스타일 적용
			area.setBackground(Color.GREEN);
			t_input.setBackground(Color.blue);
			t_input.setForeground(Color.WHITE);
			bt.setBackground(Color.BLACK);
			bt.setForeground(Color.WHITE);
			
			t_input.setPreferredSize(new Dimension(285,30));
			
			//보여주기 전에 미리 연결하자(컴포넌트와 리스너 연결)
			t_input.addKeyListener(this);
			
			//setSize(300,400);
			setBounds(500, 150, 300, 400);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public void keyPressed(KeyEvent e) {			
			
		}
		public void keyTyped(KeyEvent e) {
						
		}
		public void keyReleased(KeyEvent e) {
			//엔터키를 누르면, area에 입력데이터를 반영하자.
			int key= e.getKeyCode();//Key 코드값 반환
			if(key==10) {
				send();
			}
		}
		
		public void send() {
			//나에 대한 처리
			String msg= t_input.getText();
			area.append(msg+"\n");
			t_input.setText("");//빈텍스트로 초기화
			
			//너에 대한 처리
			ch.area.append(msg+"\n");
			ch.t_input.setText("");//빈텍스트로 초기화
		}			
		
}
