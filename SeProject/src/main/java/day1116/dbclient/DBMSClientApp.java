/*
 * DBeaver 수준은 아니여도, 딕셔너리를 학습하기 위해 데이터베이스 접속 클라이언트를 자바로 만들어 본다.
 * 실무에서는, SQLPlus를 잘 사용하지 않음..이유( 업무효율성 떨어지기 때문 )
 * 실무현장에선 개발자의 pc에는 각종 개발툴이 있지만, 실제 운영 서버에는 보안상 아무것도 설치해서는 안된다.
 * 따라서 서버엔 툴들이 없기 때문에 만일 오라클을 유지보수하러 파견을 나간 경우, 콘솔창 기반으로 쿼리를 다뤄야할 경우가 종종 있다.
 * */
package day1116.dbclient;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DBMSClientApp extends JFrame {
	JPanel p_west; //서쪽 영역 패널
	Choice ch_users; //유저명이 출력될 초이스 컴포넌트
	JPasswordField t_pass;//비밀번호 텍스트 필드
	JButton bt_login; //접속 버튼
	
	JPanel p_center;//그리드가 적용될 센터패널
	JTable t_tables; //유저의 테이블 정보를 출력할 JTable
	JTable t_seq; //유저의 시퀀스 정보를 출력할 JTable
	JScrollPane s1,s2;///스크롤 2개 준비
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system";
	String password="1234";
	Connection con;
	
	//이차원 벡터로 진행
	Vector tableList = new Vector(); // 이 안엔 또다른 벡터가 들어감==이차원 배열
	Vector<String> columnList = new Vector<String>();//컬렴명은 당연히 String
	
	public DBMSClientApp() {
		//생성
		p_west = new JPanel();
		ch_users = new Choice();
		t_pass = new JPasswordField();
		bt_login = new JButton("접속");
		
		p_center = new JPanel();
		p_center.setLayout(new GridLayout(2,1));//2층에 1호수
		t_tables = new JTable(tableList,columnList);//사이즈가 0이지만 추후 변경,업데이트
		
		t_seq = new JTable();
		s1 = new JScrollPane(t_tables);
		s2 = new JScrollPane(t_seq);
		
		//스타일
		p_west.setPreferredSize(new Dimension(150,350));
		ch_users.setPreferredSize(new Dimension(145,30));
		t_pass.setPreferredSize(new Dimension(145,30));
		bt_login.setPreferredSize(new Dimension(145,30));
		
		//조립
		p_west.add(ch_users);
		p_west.add(t_pass);
		p_west.add(bt_login);
		p_center.add(s1);
		p_center.add(s2);
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		setSize(700,350);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disConnect();//시스템 종료전 닫을 자원이 있을때 먼저 닫으려고 호출
				System.exit(0);
			}
		});
		
		bt_login.addActionListener((e)->{
			login(); //선택 유저로 로그인하기
		});
		
		setLocationRelativeTo(null);
		
		connect();//호출
		getUserList();//유저목록 가져오기
		
		//컬럼정보 초기화 하기
		columnList.add("table_name");
		columnList.add("tablespace_name");
	};
	
	//오라클에 접속하기
	public void connect() {
		try {
			Class.forName(driver); //드라이버 로드
			con = DriverManager.getConnection(url,user,password);//접속시도
			if(con==null) {
				JOptionPane.showMessageDialog(this, user+"계정의 접속에 실패했습니다.");
			}else {
				this.setTitle(user+" 계정으로 접속 중...");//프레임 제목에 성공 출력
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//유저목록 가져오기
	public void getUserList() {
		//pstmt와 result는 소모품이므로 쿼리문마다 1개씩 대응
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String sql="select username from dba_users order by username asc";
		
		try {
			pstmt=con.prepareStatement(sql);//쿼리문 준비
			rs = pstmt.executeQuery();//반환형 먼저 적으면 이클립스가 알맞는 메서드 찾아줌
			
			//rs에 있는 유저정보를 Choice에 출력
			while(rs.next()) {
				ch_users.add(rs.getString("username"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//로그인
	public void login() {
		//현재 유지되고 있는 접속 객체인 Connection을 끊고, 다른 유저로 접속을 시도
		disConnect();//접속 끊기
		user = ch_users.getSelectedItem();//현재 초이스 컴포넌트에 선택된 아이템값
		password=new String(t_pass.getPassword());//비밀번호 설정
		connect();
		getTableList();//이 시점에 로그인 하자마자, 이 사람의 테이블 정보 보이기
		System.out.println("보유테이블: "+tableList.size());		
	}
	
	public void getTableList() {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql="select table_name, tablespace_name from user_tables";
		try {
			pstmt = con.prepareStatement(sql);//쿼리준비
			rs = pstmt.executeQuery();//쿼리실행 및 결과집합 받기
			//평소같았으면 이차원 배열 선언 후 last(), getRow(),스크롤 옵션 등 사용
			
			while(rs.next()) {
				Vector vec = new Vector();//백터에 담겨질 백터
				vec.add(rs.getString("table_name"));
				vec.add(rs.getString("tablespace_name"));
				
				tableList.add(vec);//멤버변수 백터에 백터를 담으니, 멤버변수 백터는 2차원백터가 됨				
			}
			//완성된 이차원 백터를 JTable에 반영해야 함, 생성자의 인수로
			t_tables.updateUI();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//오라클에 접속끊기
	public void disConnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static void main(String[] args) {
		new DBMSClientApp();
	}
}
