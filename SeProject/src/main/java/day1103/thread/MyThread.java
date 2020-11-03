package day1103.thread;


/*개발자는 독립적으로 수행하고 싶은 코드가 있을떄, 스레드를 상속받아
 * run() 재정의하면 된다. 즉 run()에 개발자가 작성하고자 하는 로직을 작성하면됨.*/
public class MyThread extends Thread{
	
	//jvm이 아래의 run()메서드를 수행해주며, 이때를 running상태라 함
	@Override
	public void run() {
		while(true) {
		System.out.println("*");
		}
	}
}
