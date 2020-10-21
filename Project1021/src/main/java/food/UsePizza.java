package food;

class Pizza{
	String brand; //브랜드
	int slice=6; //피자 조각 수
	
	//이 생성자를 호출하는 자는, 브랜드를 넘겨서 결정지으면 된다!!
	public Pizza(String brand){
		this.brand=brand;
	}
}


public class UsePizza {
	
	//피자를 먹는다
	public void eat(Pizza p) {
		p.slice=3;
	}
	
	//갯수를 조정한다
	public void setSlice(int slice) {
		
	}
	
	public static void main(String[] args) {
		Pizza p2=new Pizza("핏자헛");
		Pizza p1=new Pizza("도미노");
		
		UsePizza up = new UsePizza();
		up.setSlice(5);
		up.setSlice(p1.slice);
		up.eat(p2);
	}

}
