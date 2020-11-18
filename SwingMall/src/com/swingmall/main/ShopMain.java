package com.swingmall.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.swingmall.board.QnA;
import com.swingmall.home.Home;
import com.swingmall.member.Login;
import com.swingmall.member.MyPage;
import com.swingmall.product.Product;
import com.swingmall.util.db.DBManager;

public class ShopMain extends JFrame{
	public static final int HOME = 0;
	public static final int PRODUCT = 1;
	public static final int QNA = 2;
	public static final int MYPAGE = 3;
	public static final int LOGIN = 4;
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	
	JPanel usetype_container;//관리자,사용자 화면을 구분지을 수 있는 컨테이너
	
	JPanel p_navi; //웹사이트의 주 메뉴를 포함할 컨테이너 패널
	String[] navi_title = {"Home","Product","QnA","MyPage","Login"};
	JButton[] navi = new JButton[navi_title.length];// [][][][][]배열 생성
	//페이지 구성
	Page[] page = new Page[5];	
	
	JLabel la_footer;//윈도우 하단의 카피라이트 영역
	DBManager dbManager;
	Connection con;		
	
	public ShopMain() {
		dbManager = new DBManager();
		usetype_container = new JPanel();
		p_navi = new JPanel();		
		la_footer = new JLabel("SwingMall All rights reserved",SwingConstants.CENTER);
		
		con=dbManager.connect();
		if(con==null) {
			JOptionPane.showMessageDialog(this, "데이터베이스에 접속할 수 없습니다.");
			System.exit(0);
		}else {
			this.setTitle("SwingShop에 오신걸 환영합니다.");
		}
		
		//메인 내비게이션 생성
		for(int i=0; i<navi.length; i++) {
			navi[i] = new JButton(navi_title[i]);
			p_navi.add(navi[i]);//패널에 네비게이션 부착
		}
		
		//페이지 구성
		page[0] = new Home(this);
		page[1] = new Product(this);
		page[2] = new QnA(this);
		page[3] = new MyPage(this);
		page[4] = new Login(this);
		
		//스타일 적용
		usetype_container.setPreferredSize(new Dimension(WIDTH, HEIGHT-50));
		usetype_container.setBackground(Color.white);
		la_footer.setPreferredSize(new Dimension(WIDTH,50));		
		la_footer.setFont(new Font("Arial Black", Font.BOLD, 19));
		
		//조립
		usetype_container.setLayout(new BorderLayout());
		usetype_container.add(p_navi,BorderLayout.NORTH);
		usetype_container.add(page[ShopMain.HOME]);
		
		this.add(usetype_container);
		this.add(la_footer, BorderLayout.SOUTH);
		
		
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		
		//프레임과 리스너 연결
		this.addWindowListener(new WindowAdapter() {			
			public void windowClosing(WindowEvent e) {
				dbManager.disConnect(con);
			}
		});
		
	}
	
	public void connect() {
		
	}
	
	public void  disConnect() {
		
	}
	
	public static void main(String[] args) {
		new ShopMain();
	}
}
