package use;
//사용하려는 클래스의 위치 알려준다
import bank.Account;

class UseAccount
{
	public static void main(String[] args) 
	{
		Account acc = new Account();//계좌 클래스 생성(public이라 여기까진 무조건 가능)
		//접근제어자별 접근
		//System.out.println(acc.bank); //public
		//System.out.println(acc.customer);//protected: 상속관계나 같은 패키지 경우만 가능
		//System.out.println(acc.num);//default: 같은 패키지내 클래스끼리만 접근허용, protected보다 한단계 더 까다롭다.
		//System.out.println(acc.balance);//private: Account 클래스 스스로만 접근가능
		//acc.balance=10; //이건 직접접근이므로 불가능
		acc.setBalance(10);//메서드를 이용한 접근방법으로 가능
		//하지만 private변수를 출력하고 싶은데 접근을 할 수가 없음-->출력 또한 메서드를 제공해주어야 한다.
		System.out.println(acc.getBalance());
	}
}
