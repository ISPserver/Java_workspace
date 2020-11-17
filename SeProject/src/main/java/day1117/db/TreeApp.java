package day1117.db;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeApp extends JFrame{
	JTree tree;
	JScrollPane scroll;
	
	public TreeApp() {
		//트리에 보여질 노드를 구성해보자
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("액세서리");
		createNode(top);//반지,목걸이,귀걸이,팔찌
		
		tree = new JTree(top);//여기에 노드를 생성자 인수로 넣어줄 예정임
		scroll = new JScrollPane(tree);
		
		add(scroll);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void createNode(DefaultMutableTreeNode top) {		
		//넘겨받은 탑 노드에 원하는 하위 노드를 생성하여 자식노드로 붙이기
		DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[4];
		node[0]=new DefaultMutableTreeNode("반지");
		node[1]=new DefaultMutableTreeNode("목걸이");
		node[2]=new DefaultMutableTreeNode("귀걸이");
		node[3]=new DefaultMutableTreeNode("팔찌");
		
		//생성된 노드를 top 노드의 하위 노드로 부착
		for(DefaultMutableTreeNode obj : node) {
			top.add(obj);
		}
	}
	public static void main(String[] args) {
		new TreeApp();
	}
}
