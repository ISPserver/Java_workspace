/*
 * MVC패턴이 적용된 JTable에서 사용되는 TableModel은 명칭으론
 * 마치 모델인 것처럼 보이지만 그 역할로 본다면 컨트롤러이다.
 * */

package day1106.db;
import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	//데이터 준비
	String[][] flower = {
			{"장미","50000","RED","Korea"},
			{"튤립","70000","purple","France"},
			{"장미","35000","white","Korea"},
	};
	String[][] car = {
			{"BMW","7000","white"},
			{"Benz","9500","silver"},
			{"Audi","8000","black"},
	};
	//행의 갯수를 반환하는 메서드
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return flower[0].length;
	}

	//열의 갯수를 반환하는 메서드
	public int getRowCount() {		
		return flower.length;
	}

	//지정한 좌표의 값을 반환
	public Object getValueAt(int row, int col) {
		System.out.println("row :"+row+"col "+col);
		return flower[row][col];
		//return car[row][col];
	}
	
}
