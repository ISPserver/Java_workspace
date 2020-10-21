package use;
import fashion.Pants;

public class UsePants {
	//현재 클래스와는 물리적으로 떨어져 있는, 즉 다른 패키지에 들어있는
	//클래스 사용해보기
	//j.s: <script sr.c="경로/파일명"></script>
	public static void main(String[] args) {
		Pants p = new Pants();
		p.color="blue";
		System.out.println(p.color);
	}
}
