package product;

public class Shoes {
	String color;
	int price;
	
	public Shoes(String color, int price) {
		this.color=color;
		this.price=price;
	}
	
	//색상을 변경하는 메서드
	public void setColor(String color) {
		this.color=color;
	}
	
	//가격을 변경하는 메서드
	public void setPrice(int price) {
		this.price=price;
	}
	
	//생성자 메서드와, 일반 메서드로 초기화하는거 차이
	//결과는 같다. 
	public static void main(String[] args) {
		Shoes s=new Shoes("red",2000);
//		s.setColor("red");
//		s.setPrice(20000);
		
		System.out.println("신발색상:"+s.color+",가격은:"+s.price);
	}

}
