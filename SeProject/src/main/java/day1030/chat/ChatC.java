package day1030.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import day1028.chat.ChatClient2;
public class ChatC extends JFrame implements KeyListener, ActionListener{
											// 	 is a							is a
		JTextArea area;
		JScrollPane scroll;
		JPanel p_south;
		JTextField t_input;
		JButton bt;
		JButton bt_open; //대화상대방을 띄우는 버튼
		private ChatA chatA;
		private ChatB chatB;
		
		
		public ChatC() {		
			//생성
			super("부모");
			area = new JTextArea();
			scroll= new JScrollPane(area);
			p_south=new JPanel();
			t_input = new JTextField(10);		
			bt=new JButton("SEND");
			bt_open= new JButton("open");
			//패널 조립(패널은 Default가 FLowLayout)
			//p_south.setLayout(new FlowLayout());
			p_south.add(t_input);
			p_south.add(bt);
			p_south.add(bt_open);
			
			add(scroll);//센터에 스크롤 부착
			add(p_south,BorderLayout.SOUTH);//남쪽에 패널부착
			
			//스타일 적용
			area.setBackground(Color.YELLOW);
			t_input.setBackground(Color.blue);
			t_input.setForeground(Color.WHITE);
			bt.setBackground(Color.BLACK);
			bt.setForeground(Color.WHITE);
			
			t_input.setPreferredSize(new Dimension(250,30));
			
			//보여주기 전에 미리 연결하자(컴포넌트와 리스너 연결)
			t_input.addKeyListener(this);
			
			//send버튼에 리스너 연결
			bt.addActionListener(this);
			//open버튼에 리스너 연결
			bt_open.addActionListener(this);
			

			setBounds(500, 550, 300, 400);
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
		
		public void actionPerformed(ActionEvent e) {
			Object  obj=e.getSource();
			JButton btn = (JButton)obj; //하위 자료형으로 down casting
			if(btn==bt) { //주소값이 같다면
				System.out.println("send 클릭");	
				send();
			}else if(btn.equals(bt_open)) {//같은 내용의 버튼이라면
				System.out.println("open 클릭");
				open();
			}	
		}
		//메세지창에 대화내용 누적하기
		public void send() {
			//나에 대한 채팅 처리
			String msg= t_input.getText();
			area.append(msg+"\n");
			t_input.setText("");//빈텍스트로 초기화
			
			//chatA에 대한 채팅 처리						
			chatA.area.append(msg+"\n");						
			//chatB에 대한 채팅 처리						
			chatB.area.append(msg+"\n");
		}
		//대화할 상대방 윈도우 창 띄우기
		public void open() {
			//ChatClient2를 화면에 띄우기
			
		}
		
		//세터추가
		public void setChatA(ChatA chatA) {
			this.chatA = chatA;
		}
		
		public void setChatB(ChatB chatB) {
			this.chatB = chatB;
		}
							
}
