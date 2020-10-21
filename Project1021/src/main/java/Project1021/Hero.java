package Project1021;

public class Hero {
	int hp=10;
	boolean fly= false;
	String name="메가맨";//has a관계 맞지만(객체),빈도수 높으니 제외
	Bullet bullet;
	
	public void  setHp(int hp) {
		this.hp=hp;
	}
	public void  setFly(boolean fly) {
		this.fly=fly;
	}
	public void  setName(String name) {
		this.name=name;
	}
	public void  fire(Bullet bullet) {
		this.bullet=bullet;
	}

	public static void main(String[] args) {
		Hero hero=new Hero();
		hero.setHp(300);		
		hero.setFly(true);
		hero.setName("부기맨");
		hero.fire(new Bullet());
		
		System.out.println(hero.hp);

	}

}
