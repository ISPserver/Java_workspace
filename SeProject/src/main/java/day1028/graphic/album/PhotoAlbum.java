package day1028.graphic.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame implements ActionListener{
	AlbumPanel p;//paint메서드를 재정의하려면, 클래스로 정의해야 한다.
	
	JPanel p_south;//버튼 2개 얹힌 패널
	JButton bt_prev, bt_next; //이전,다음 버튼
	
	public PhotoAlbum() {
		//생성
		p = new AlbumPanel();
		p.setBackground(Color.yellow);
		p_south = new JPanel();
		bt_prev = new JButton("이전 사진");
		bt_next = new JButton("다음 사진");
		
		//조립
		add(p);//중앙에 앨범패널 넣기
		p_south.add(bt_prev);//패널에 이전 버튼 넣기
		p_south.add(bt_next);//패널에 다음 버튼 넣기
		add(p_south,BorderLayout.SOUTH);//남쪽에 버튼패널 넣기
		
		//이전버튼과 리스너연결
		bt_prev.addActionListener(this);
		
		//다음버튼과 리스너연결
		bt_next.addActionListener(this);
		
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//이전 버튼이면 n을 감소(AlbumPanel.n)
		if(obj == bt_prev) {
			p.n--;
		}
		//다음 버튼이면 n을 증가(AlbumPanel.n)
		else if(obj == bt_next) {
			p.n++;
		}
		//화면 갱신 (직접 AlbumPanel의 paint()호출 불가
		//갱신 요청!
		p.repaint();
		
	}
	
	public static void main(String[] args) {
		new PhotoAlbum();
	}
}
