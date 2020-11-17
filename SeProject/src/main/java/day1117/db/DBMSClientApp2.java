/*
 * DBeaver 수준은 아니여도, 딕셔너리를 학습하기 위해 데이터베이스 접속 클라이언트를 자바로 만들어 본다.
 * 실무에서는, SQLPlus를 잘 사용하지 않음..이유( 업무효율성 떨어지기 때문 )
 * 실무현장에선 개발자의 pc에는 각종 개발툴이 있지만, 실제 운영 서버에는 보안상 아무것도 설치해서는 안된다.
 * 따라서 서버엔 툴들이 없기 때문에 만일 오라클을 유지보수하러 파견을 나간 경우, 콘솔창 기반으로 쿼리를 다뤄야할 경우가 종종 있다.
 * */
package day1117.db;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import com.mysql.cj.protocol.x.ResultMessageListener;


/*day1116차에 구현했던 dbclient에서 JTable 생성자의 vector방식을 이용하면 동적인
 * 테이블 선택시 유지보수성이 거의 불가, 이를 개선해본다.
 * 즉, 유저가 어떤 테이블 선택할지 알 수 없으므로, 선택한 테이블 컬럼수,구성들 예측할 수 없는 상황에
 * 대처해본다.*/
public class DBMSClientApp2 extends JFrame {
	JPanel p_west; //서쪽 영역 패널
	Choice ch_users; //유저명이 출력될 초이스 컴포넌트
	JPasswordField t_pass;//비밀번호 텍스트 필드
	JButton bt_login; //접속 버튼
	
	JPanel p_center;//그리드가 적용될 센터패널
	JPanel p_upper;//테이블과 시퀀스를 포함할 패널(그리드 레이아웃 예정)
	JPanel p_middle;//SQL편집기가 위치할 미들패널
	JPanel p_footer;
	JTextArea area;// 쿼리 편집기
	JButton bt_execute;//쿼리문 실행버튼
	JTable t_tables; //유저의 테이블 정보를 출력할 JTable
	JTable t_seq; //유저의 시퀀스 정보를 출력할 JTable
	JTable t_record;//유저가 선택한 테이블의 레코드를 출력할 JTable
	JTable t_column;
	
	JScrollPane s1,s2,s3,s4,s5;///스크롤 2개 준비
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system";
	String password="1234";
	Connection con;
	
	//이차원 벡터로 진행
	Vector tableList = new Vector(); // 이 안엔 또다른 벡터가 들어감==이차원 배열
	Vector<String> tableColumn = new Vector<String>();//컬렴명은 당연히 String
	
	Vector seqList = new Vector(); // 이 안엔 또다른 벡터가 들어감==이차원 배열
	Vector<String> seqColumn = new Vector<String>();//컬렴명은 당연히 String
	
	//테이블 컬럼정보에 필요한 백터들
	Vector columnList = new Vector();
	Vector<String> columnType = new Vector<String>();
	
	//선택된 테이블에 대한 레코드 출력에 필요한 백터들
	Vector recordList = new Vector();//레코드를 담게될 백터
	MyTableModel model;
	public DBMSClientApp2() {
		//생성
		p_west = new JPanel();
		ch_users = new Choice();
		t_pass = new JPasswordField();
		bt_login = new JButton("접속");
		
		p_center = new JPanel();
		p_upper = new JPanel();
		p_middle = new JPanel();
		p_footer = new JPanel();
		area = new JTextArea();
		bt_execute = new JButton("SQL문 실행");
		
		p_center.setLayout(new GridLayout(3,1));//2층에 1호수
		p_upper.setLayout(new GridLayout(1,2));//2층에 1호수
		p_middle.setLayout(new BorderLayout());
		p_footer.setLayout(new GridLayout(1,2));
		
		//컬럼정보 초기화 하기
		tableColumn.add("table_name");
		tableColumn.add("tablespace_name");
		t_tables = new JTable(tableList,tableColumn);//사이즈가 0이지만 추후 변경,업데이트
		
		
		seqColumn.add("sequence_name");
		seqColumn.add("last_number");
		t_seq = new JTable(seqList,seqColumn);//사이즈가 0이지만 추후 변경,업데이트
		s1 = new JScrollPane(t_tables);
		s2 = new JScrollPane(t_seq);
		s3 = new JScrollPane(area); //추후, 컬럼 정보 보여줄 스크롤
		
		//선택한 테이블의 레코드 보여줄 JTable 생성
		t_record = new JTable(null); //MyTableModel을 대입할 예정
		s4 = new JScrollPane(t_record); 
		
		columnType.add("컬럼명");
		columnType.add("자료형");
		t_column = new JTable(columnList,columnType);
		s5 = new JScrollPane(t_column);
		
		//스타일
		p_west.setPreferredSize(new Dimension(150,350));
		ch_users.setPreferredSize(new Dimension(145,30));
		t_pass.setPreferredSize(new Dimension(145,30));
		bt_login.setPreferredSize(new Dimension(145,30));
		area.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		//조립
		p_west.add(ch_users);
		p_west.add(t_pass);
		p_west.add(bt_login);
		p_upper.add(s1);
		p_upper.add(s2);		
		p_middle.add(s3);		
		p_middle.add(bt_execute,BorderLayout.SOUTH);
		p_footer.add(s4);
		p_footer.add(s5);
		p_center.add(p_upper);//그리드의 1층
		p_center.add(p_middle);//그리드의 2층
		p_center.add(p_footer);//그리드의 3층
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		setSize(900,750);
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
		
		//테이블과 리스너 연결
		t_tables.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				//선택한 좌표의 테이블명 얻기
				int row = t_tables.getSelectedRow();// 선택row
				int col = t_tables.getSelectedColumn();//선택 col
				String tableName = (String)t_tables.getValueAt(row, col);
				tableName = tableName.toLowerCase();//소문자로 변환
				select(tableName); 
				System.out.println(tableName);
				t_record.updateUI();
			}
		});
		
		bt_execute.addActionListener((e)->{
			select(null);
		});
		
		setLocationRelativeTo(null);
		
		connect();//호출
		getUserList();//유저목록 가져오기
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
	
	//시퀀스 가져오기
	public void getSeqList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select sequence_name, last_number from user_sequences";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vec = new Vector();
				vec.add(rs.getString("sequence_name"));
				vec.add(rs.getString("last_number"));
				
				seqList.add(vec);
			}
			t_seq.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//유저가 선택한 테이블의 레코드 가져오기
	//이 메서드를 호출하는 사람은 select 문의 매개변수로 테이블명을 넘겨야 함
	//매개변수가 넘어오면, 테이블명만 사용하고, 안넘어오면 전체 Sql문 대체
	public void select(String tableName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql=null;
		if(tableName!=null) {
			sql="select * from "+tableName;
		}else {
			sql=area.getText();
		}
				
		try {
			pstmt = con.prepareStatement(sql);//쿼리문 준비
			rs = pstmt.executeQuery();//쿼리문 실행
			
			/*----------------------------------------------
			컬럼 정보 만들기 위한 코드
			 ------------------------------------------------*/
			Vector column = new Vector(); //이 벡터는 새로운 TableModel객체의 인스턴스가 가진 컬럼백터에 대입될 예정
			
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount(); // 총 컬럼수
			
			//컬럼 정보 출력
			for(int i=1; i<=columnCount; i++) {				
				column.add(meta.getColumnName(i));				
			}
			
			Vector record = new Vector();
			while(rs.next()) {				
				Vector vec = new Vector(); //비어있는 일차원 백터
				//컬럼 갯수를 모름 --> 이럴땐 테이블에 대한 메타정보를 가져오면 된다.				
				//컬럼 정보 출력
				for(int i=1; i<=columnCount; i++) {
					vec.add(rs.getString(i));
				}
				record.add(vec); //My Table Model 보유한 벡터에 추가
				//데이터를 담은 이차원 벡터와, 컬럼을 담은 일차원 벡터를 새로운 모델객체를 생성하면서 전달하자
				model = new MyTableModel(record,column);
				t_record.setModel(model);
			}
			columnList.removeAllElements();
			getColumnType(meta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void getColumnType(ResultSetMetaData meta) {
		try {
			int total = meta.getColumnCount();
			for(int i=1; i<=total; i++) {
				Vector vec = new Vector();
				meta.getColumnName(i);
				meta.getColumnTypeName(i);
				vec.add(meta.getColumnName(i));
				vec.add(meta.getColumnTypeName(i));				
				columnList.add(vec);				
			}
			t_column.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
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
		getSeqList();
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
			//테이블의 레코드와 컬럼갯수 확인(여전히 0인지 체크)
			System.out.println(t_tables.getColumnCount());
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
		new DBMSClientApp2();
	}
}
