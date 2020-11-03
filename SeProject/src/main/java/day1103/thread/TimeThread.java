/*초를 실시간 출력하는 쓰레드*/
package day1103.thread;

import java.util.Calendar;

public class TimeThread extends Thread{
	@Override
	public void run() {
		while(true) {		
			Calendar cal = Calendar.getInstance(); //추상클래스이므로 자체 메서드로 인스턴스 얻기
			System.out.println(cal.get(Calendar.YEAR)+"년 "
			+(cal.get(Calendar.MONTH)+1)+"월"+cal.get(Calendar.DATE)+"일 "
			+cal.get(Calendar.HOUR)+"시 "+cal.get(Calendar.MINUTE)+"분"
			+cal.get(Calendar.SECOND));
			try {
				//1초동안 non-runnable 상태로 있다가 다시 복귀
				Thread.sleep(1000);// (1/1000) 초까지 표현 가능
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
