package product;

public class HighHeel {
	String color="None Color";
	
	public HighHeel(String color) {
		this.color=color;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	
	public static void main(String[] args) {
		HighHeel h= new HighHeel("black");
		h.setColor("white");
	}
}
