/*
 * JTable은 디자인에 불과하므로, 이 클래스로부터 데이터에 대한 정보를 가져간다.
 * 따라서 TableModel 인터페이스를 구현한 객체인 Ab
 * */
package day1106.db;

import javax.swing.table.AbstractTableModel;

public class ProductController extends AbstractTableModel {
	String[][] data = {};
	String[]  column = {"product_id","subcategory_id","product_name","brand","price","filename"};
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return column.length;
	}
	
	//JTable이 getColumnCount()의 갯수만큼 호출하며 순서대로0,1,2,3,4,5를 넘기며 컬럼제목 가져간다.
	@Override
	public String getColumnName(int col) {
		return column[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return data[row][col];
	}
	
}
