package day1117.db;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProductTree extends JFrame{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="user1104";
	String password = "user1104";	
	Connection con;
	
	JTree tree;
	JScrollPane scroll;
	
	//배열만 있다면 트리 생성은 메서드가 알아서 해주는 코드
	//String[] category= {"상의","하의","액세서리","신발"}; //상위카테고리 배열
//	String[][] product = {
//			{"티셔츠","점퍼","니트","가디건"},
//			{"청바지","반바지","면바지","핫바지"},
//			{"귀걸이","목걸이","반지","팔찌"},
//			{"구두","운동화","스니커즈","선물"}
//	};
	
	ArrayList<String> topCategory= new ArrayList<String>();//상위 카테고리
	ArrayList<ArrayList> subCategory = new ArrayList<ArrayList>();//하위 카테고리
	
	public ProductTree() {
		connect();//접속
		
		//DB연동해 배열들의 데이터를 실제 DB 데이터로 가져오기
		getTopCategory();
		
		for(int i=0; i<topCategory.size(); i++) {
			String name = topCategory.get(i);//top, down, accessary, shoes
			ArrayList subList = (ArrayList)getSubCategory(name);			
			subCategory.add(subList);
		}
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("상품정보");
		/*for(int i=0; i<category.length; i++) {
			top.add(getCreateNode(category[i], product[i]));			
		}*/
		
		for(int i=0; i<topCategory.size(); i++) {
			String name = topCategory.get(i);
			top.add(getCreateNode(name, subCategory.get(i)));				
		}
		
		tree= new JTree(top);
		scroll = new JScrollPane(tree);
		
		add(scroll);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disConnect(); //연결 끊기
				System.exit(0);//프로세스 종료
			}
		});//프레임과 리스너 연결
				
		
		setSize(400,500);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			if(con==null) {
				JOptionPane.showMessageDialog(this, user+"로 접속에 실패하였습니다");
				System.exit(0);
			}else {
				this.setTitle(user+"로 로그인 중");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disConnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//탑 카테고리 가져오기
	public void getTopCategory() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from topcategory";		
		try {
			pstmt=con.prepareStatement(sql);//쿼리문 준비
			rs=pstmt.executeQuery();//쿼리 수행
			
			while(rs.next()) {
				topCategory.add(rs.getString("name"));
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
	//서브 카테고리 가져오기
	public List getSubCategory(String name) {//top,down,accessary,shoes
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList subList = new ArrayList();
		
		String sql = "select * from subcategory where topcategory_id=(select topcategory_id from topcategory where name=?)";		
		try {
			pstmt=con.prepareStatement(sql);//쿼리문 준비
			pstmt.setString(1, name);//바인드 변수 지정
		
			rs=pstmt.executeQuery();//쿼리 수행
			
			while(rs.next()) {
				subList.add(rs.getString("name"));
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
		return subList;//호출하는 자가 하위 카테고리 목록 가져갈 수 있다.
	}
	
	//이 메서드를 호출하는 자가, 배열 넘기면 배열 길이만큼 노드 구성해 반환해줌
	public DefaultMutableTreeNode getCreateNode(String parentName, String[] childName) {
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName); //부모 생성
		//자식 수 만큼 노드 만들어 부모에 부착
		if(childName!=null) {
		for(int i=0; i<childName.length; i++) {
			parent.add(new DefaultMutableTreeNode(childName[i]));
			}
		}
		
		return parent;
	}
	
	//위의 메서드는 배열을 처리하는 용이지만, 이 메서드는 이름은 같지만 List용으로 처리
	public DefaultMutableTreeNode getCreateNode(String parentName, ArrayList childName) {
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName); //부모 생성
		//자식 수 만큼 노드 만들어 부모에 부착
		if(childName!=null) {
		for(int i=0; i<childName.size(); i++) {
			parent.add(new DefaultMutableTreeNode(childName.get(i)));
			}
		}
		
		return parent;
	}
	public static void main(String[] args) {
		new ProductTree();
	}

}
