/*
 * Collection Framework(전제조건은 객체만을 대상으로 한다)
 * 자바언어에서는 객체를 모아서 처리할 떄 유용한 api를 제공하는데,
 * 이를 컬렉션 프레임웤이라고 한다. Java.utill에서 지원한다.
 * 1)순서있는 유형 List형: 
 * -배열과 거의 같다. 하지만 생성할때 크기를 명시해야함.따라서 동적늘림x
 * -자료형을 섞어 사용할 수 없다. ex) int[]arr = new int[5]; 오직int형만 넣을 수 있음.
 *- But 리스트는 크기가 자유롭고,객체 섞어서 넣을 수 있음 
 * 
 * 2)순서없는 유형 Set형:
 * 3)key-value의 유형 Map형:
 * */
package day1029.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;

public class CollectionApp {
	public void showList() {
		//List형의 최상위 객체인 List는 인터페이스이며, 기본적으로 가져야할 추상메서드가 명시되어 있다.
		//<>는 Generic Type!! 컬렉션 프레임웤케 넣을 수 있는 자료형 제한!
		ArrayList<JButton> list = new ArrayList<JButton>(); //리스트 구조들은 배열과 거의 같다.
		//js의 배열과 동일) 동작방식
		list.add(new JButton("첫번째 버튼"));
//		list.add("사과");
//		list.add("복숭아");
//		list.add("멜론");
		list.add(new JButton("라스트 버튼"));
		//★★★배열은 length지만, 컬렉션 프레임웤은 모두 size()이용
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			JButton bt1= list.get(i); //섞어서 들어가므로, 반환형은 예측할 수 없기때매 Object형이 반환
			System.out.println(bt1.getText());
		}
		
		//★★★리스트는 중복 데이터 허용
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("apple");
		list2.add("apple");
		System.out.println(list2.size());
		
	}
	public void showSet() {
		//★★★순서 없는것이 Set
		//★★★중복 허용 안함
		HashSet<String> set = new HashSet<String>();
		set.add("banana");
		set.add("banana");
		System.out.println("HashSet 크기"+set.size());
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("바나나");
		set2.add("포도");
		set2.add("블루베리");
		//반복문으로 set2 모든 데이터를 출력
		Iterator<String> it = set2.iterator();
		while(it.hasNext()) {//다음 요소가 존재하는지 판단
			String e = it.next();//다음 요소를 반환
			System.out.println(e);
		}
		
	}
	public void showMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("k1", "장미");
		map.put("k2", "튤립");
		map.put("k3", "안개꽃");
		map.put("k3", "할미꽃");
		System.out.println("map크기"+map.size());
		//결론: key 값은 중복을 허용하지 않는다. 따라서 대체된다.
		//출력하기
		Set<String> keyset = map.keySet();
		//Set은 Iterator를 지원하므로, key를 일렬로 늘어뜰이기
		Iterator<String> keyIter =keyset.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String value=map.get(key);
			System.out.println(value);
		}
		
	}
	
	public static void main(String[] args) {
		CollectionApp app = new CollectionApp();
		app.showList();
		app.showSet();
		app.showMap();
	}
}
