package day1030.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
/* Stream 이란? 현실에서는 흐르는 물줄기를 의미
 * 					   전산에서는 흐름의 대상이 데이터이다.
 *                    but 전산에선 흐름의 방향에 따라 다음과 같이 분류
 *                    1) 입력(Input): 실행중인 프로그램으로 데이터가 흘러 들어가는 것
 *                    2) 출력(Output): 실행중인 프로그램에서 데이터가 흘러나오는 것
 *자바에서는 입출력과 관련된 패키지명이 java.io이다. 여기에는 입출력 처리를 위한 수많은 API가 지원 된다.                    
 * */

/*예외란? 프로그램이 정상 실행되어질 수 없는 예외적인 상황을 의미(에러)
 * 에러가 발생하면? 프로그램이 비정상으로 종료된다.
*/

public class FileReadApp {
	//파일을 대상으로 데이터를 읽어들이는 FileInputStream을 학습한다.
	FileInputStream fis;
	
	public FileReadApp() {				
		File file = new File("C:/Users/tjdal/workspace/java_workspace/SeProject/res/data/memo.txt");
		
		//로컬상의 파일을 대상으로 스트링(관)을 생성
		//★★★★★예외처리의 목적은?비정상적인 프로그램 종료를 막기 위함!
		try { //이 영역은 에러가 발생할 가능성이 있는 코드임을 명시
			fis = new FileInputStream(file);
			System.out.println("스트림 생성 성공입니다.");
			
			int data;
			
			while(true) {
			data=fis.read(); //1 byte 읽어들이기
			
			if(data==-1) break;//파일의 끝에 도달하면, 반복문 빠져나
			System.out.print((char)data);
			}
			
			
		}catch(FileNotFoundException e){ //혹여나 우려했던 에러가 발생하면, 비정상 종료말고 이 catch문 블럭을 수행하라
			
			System.out.println("지정한 파일을 찾을 수 없습니다.");
			e.printStackTrace(); //stack의 구조로, 에러의 원인을 출력
		}catch(IOException e) {
			
			System.out.println("파일 입출력 중, 파일을 읽을 수 업습니다.");
			e.printStackTrace();
		}finally {
			//이 영역은 실행부가 try문, catch문을 수행하던 무조건 거쳐서 가야 하는
			//영역이므로, 이 영역에 자원을 닫는 코드를 작성해야 한다.
			//주로 DB닫기, 스트림 연결 끊기
			
			//★DB,STREAM 닫을떄 반드시 null여부를 따져보는 습관을 갖자
			if(fis != null) {				
			try {
				//null이 아닐때만
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}
	public static void main(String[] args) {
		new FileReadApp();
	}
}
