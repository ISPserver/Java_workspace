/*-쓰레드란? Thread-
 * 하나의 프로세스 내에서 비동기적으로 동작할 수 있는 또 하나의 세부실행 단위
 * 
 * */

package day1103.thread;

public class ThreadTest1 {
	public static void main(String[] args) {
		//시간 쓰레드 생성하고, 동작
		TimeThread tt = new TimeThread();
		tt.start(); //runnable 상태로 진입
		
		//0.5초마다 별을 출력하는 쓰레드 구현하되, 현재 클래스내에서 구현(내부익명클래스)
		Thread startThread = new Thread() {
			@Override
			public void run() {
				while(true) {
					System.out.println("★");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} //0.5초
				}
			}
		};
		startThread.start(); //Runnable 상태로 진입
		//개발자가 정의한 쓰레드를 이용해 무한루프 실행
		MyThread t1 = new MyThread();//분신 생성		
		//t1.start();//쓰레드의 수행은 시스템에게 맡겨야 한다.
		
		//쓰레드가 보유한 run 메서드는 JVM에 의해 호출된다.
//		while(true) {
//			System.out.println("Hi");		
//		}
	}
}
