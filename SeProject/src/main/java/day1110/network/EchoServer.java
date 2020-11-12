/*
 * 소켓이란?
 * -일상 생활에서는 친구 등에 꼽는 접점도구이다.
 * 역할?
 * -프로그래밍 언어에서 개발자가 제어하는 대상은 '스트림'인 것 뿐, 네트워크 지식 없어도 가능한 것
 * */
package day1110.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {	
	int port=8989; //클라이언트를 받아들일 포트번호, 이 포트번호에 의해 다른 네트워크 프로세스와 구분가능
				 //예) 오라클1521, mysql 3306
	ServerSocket server; //대화용 소켓이 아니라, 접속자를 감지하고, 접속자가 발견되면 대화용 소켓을 반환
								   //해주는 객체 (마치 전화기의 벨이 울리면 그 이후부터 전화를 받고 대화하는것과 비슷)
								   //전화 받는용 소켓
	public EchoServer() {
		try {
			server = new ServerSocket(port);//서버소켓 생성
			Socket socket = server.accept(); //서버 가동 및 클라이언트 접속 대기(접속전까지 무한대기)
			System.out.println("접속자 발견");
			//개발자는 반환받은 소켓으로부터 통신에 필요한 입출력 스트림을 얻을 수 있다
			//이때, 개발자는 네트워크 하부에 대한 아무 지식 없이 그냥 스트림 처리만 하면 알아서
			//원격지의 대화상대와 통신이 가능하며 이 모든것들을 소켓이 알아서 해주는 것이다.
			InputStream is = socket.getInputStream(); //바이트 기반 스트림
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			String data=null;
			while(true) {				
			data = br.readLine(); // 1byte읽기
			System.out.println(data);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void main(String[] args) {
		new EchoServer();
	}
}
