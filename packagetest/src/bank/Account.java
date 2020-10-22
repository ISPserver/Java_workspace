package bank;

//고객의 계좌를 정의: 신중해짐 
//패키지에 넣은 클래스를 public으로 공개하지 않으면, 다른 어떠한 클래스도 이 클래스를 사용 불가.
public class  Account 
{
	/*계좌에 들어갈 만한 속성을 정의*/
	public String bank="우리은행";//은행명
	protected String customer; //고객이름
	private int balance=1000000; //금액 > 중요한 변수
	String num="022-388-85465"; //계좌번호

	//private로 선언된 변수는 절대 외부에서 접근 할 수 없으므로,
	//변수에 접근하려면 메서드를 이용해야 한다.
	public void setBalance(int balance){
		this.balance=balance;
	}
	//이와 같이 private로 선언된 변수의 값을 리턴하는 메서드를 getter 라고 한다!
	//위의 setBalance처럼 값을 변경하는 메서드를 setter라고 한다!
	//게터와 세터는 아주 아주 유명한 메서드 정의 기법
	//잔고확인 메서드 정의	
	public int getBalance(){
		return balance;
	}
}
/*
class customer{
	private String name;
	private int age;
	private boolean isMarry;
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}

	public void setIsMarry(boolean isMarry){
		this.isMarry=isMarry;
	}
	public boolean getIsMarry(){
		return IsMarry;
	}

}

*/

