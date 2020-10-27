package string;

public class StringTest {
	public static void main(String[] args) {
		/*String은 클래스다. 객체이다
		 하지만 많이 사용하기 때문에 new에 의해 생성은 불편하다.
		 따라서 String에 한해서는 일반 데이터처럼 표현식 지원함
		 이 방법을 암시적,묵시적(implicit)생성법
		 묵시적 생성법에 의한 String은 상수풀에 의해 관리되어짐
		*/
		String s1="apple"; //묵시적(상수풀 이용)
		String s2="apple";
		System.out.println(s1==s2);
		//String은 레퍼런스 변수라 주소값을 비교하지만 묵시적
		//생성법은 상수풀을 이용해 중복을 방지하므로 같은 주소를 바라보게함
		String s3= new String("bbb"); //명시적
		String s4= new String("bbb");
		System.out.println(s3==s4);
		
		//주소비교가 아닌, 객체 동일성 비교하는법
		String k1="orange";
		String k2="orange";
		//System.out.println(s3==s4);//주소비교
		System.out.println(k1.equals(k2));
	}
}
