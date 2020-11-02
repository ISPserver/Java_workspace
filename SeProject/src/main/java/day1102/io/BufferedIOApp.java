package day1102.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * 실행중인 프로그램으로 데이터를 읽거나 쓸때, 한 바이트, 한 문자씩 입출력을 수행하면,
 * 데이터양이 많을때 너무 많은 입출력을 수행/속도 저하 * 
 * */
public class BufferedIOApp {
	public static void main(String[] args) {
		//keyboard에 연결된 스트림은 개발자가 원하는 타임에 new 할 수 없다.
		//왜? OS가 이미 얻어놨으므로
		InputStream is = System.in;
		InputStreamReader reader = new InputStreamReader(is);//바이트 기반을 문자기반 스트림으로 변경
		BufferedReader br = new BufferedReader(reader);	
		String data="";
		
		try {
			while(true) {
				data = br.readLine();
				System.out.print(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
