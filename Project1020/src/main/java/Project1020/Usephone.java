package Project1020;


class Phone{	
	String color="black";
	String company="LG";
	int weight=45;
	
	public void setColor(String c) {
		color=c;
	}	
}

public class Usephone {

	public static void main(String[] args) {		
		int weight=30;
		new Phone();
		String color="blue";
		System.out.println(color);
		int w=new Phone().weight;
		System.out.println("무게는: "+w);
	}

}
//class Phone{
//	int price=200;
//	String color="white";
//	
//	public void setPrice() {
//		price=500;
//	}
//	public void setColor() {
//		color="red";
//	}
//}
//
//public class Usephone {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int price=5;
//		Phone ph=new Phone();
//		price=3;
//		ph.setPrice();
//		System.out.println(price);
//	}
//
//}
