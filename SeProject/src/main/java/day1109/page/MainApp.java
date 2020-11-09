package day1109.page;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainApp extends JFrame implements ActionListener{
	JPanel p_north;
	JPanel p_center; //여기에 페이지들이 위치함
	
	JButton[] btn = new JButton[4];
	String[] title = {"Home","게시판","로그인","회원가입"};
	
	//4개의 준비된 페이지
	Home home;
	Board board;
	Login login;
	Member member;
	
	//패널들을 반복문으로 처리하려면, index를 위해 배열이 필요
	JPanel[] pages = new JPanel[4];
	
	public MainApp() {
		p_north = new JPanel();
		p_center = new JPanel();
		
		for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton("Page "+i);
			p_north.add(btn[i]); //북쪽 패널에 버튼 부착
			
			btn[i].addActionListener(this);
		}
		
		add(p_north, BorderLayout.NORTH);
		add(p_center); //페이지 컨테이너를 센터에 부착
		
		//페이지 생성		
		pages[0] = new Home();
		pages[1] = new Board();
		pages[2] = new Login();
		pages[3] = new Member();
		
		//페이지 스타일 설정
		pages[0].setPreferredSize(new Dimension(580,480));			
		pages[1].setPreferredSize(new Dimension(580,480));				
		pages[2].setPreferredSize(new Dimension(580,480));
		pages[3].setPreferredSize(new Dimension(580,480));
		
		//센터영역에 4개의 준비된 페이지를 붙여넣기		
		p_center.add(pages[0]);
		p_center.add(pages[1]);
		p_center.add(pages[2]);
		p_center.add(pages[3]);
		
		setVisible(true);
		pack(); //내용물의 크기만큼 수축		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); //이벤트 일으킨 소스 구하기
		if(obj == btn[0]) {//Home
			setPage(0);
		}else if(obj == btn[1]){//Board
			setPage(1);
		}else if(obj == btn[2]){//Login
			setPage(2);
		}else if(obj == btn[3]){//Member
			setPage(3);
		}
		
	}
	//모든 페이지를 대상으로 반복문 실행하되, 보여질 페이지만, true로 나머지는 false
	public void setPage(int index) {
		for(int i=0; i<pages.length; i++) {
			if(index==i) {
				pages[i].setVisible(true);	//보여질 페이지				
			}else {
			pages[i].setVisible(false); //가려질 페이지
			}
		}
	}
	public static void main(String[] args) {
		new MainApp();
	}
}