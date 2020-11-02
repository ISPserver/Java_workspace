package day1102.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardInputApp {
	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader reader = new InputStreamReader(is); //표준 입력스트림(키보드 or 기타 입력도구)
		int data;
		try {							
			data = reader.read(); //.read의 특징: 입력없으면 무한대기상태
			System.out.println((char)data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 1byte 읽기
		
		
		
	}
}
