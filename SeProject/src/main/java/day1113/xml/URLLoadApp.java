/*
 * 지금까지는 url상의 자원을 가져올 때, 그 대상을 이미지로 하였었다.
 * ex)ImageIO.read() 등 실습
 * 지금 이 실습에서는 이미지 뿐만이 아니라 원격지의 모든 종류의 자원을 대상으로 연결하여
 * 스트림으로 데이터를 읽어보는 실습을 진행해본다.
 * */
package day1113.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLLoadApp {
	//웹상의 모든 자원을 대상으로, 연결 및 데이터를 읽어올 수 있는 객체
	URLConnection con; //추상클래스 이므로, URL 객체로 부터 인스턴스를 얻는다.
	HttpURLConnection http;
	URL url;
	FileOutputStream fos;
	int cnt=0;
	public URLLoadApp() {
		try {
			url = new URL("https://img.lovepik.com/photo/40022/5900.jpg_wh860.jpg");
			
			//지정한 원격자의 자원과 연결을 시도
			con = url.openConnection();
			http = (HttpURLConnection)con;
			// http의 자원을 GET 방식으로 자원을 요청
			http.setRequestMethod("GET");
			
			//연결 객체로부터 스트림을 얻어와서 데이터를 읽기
			InputStream is =  http.getInputStream();
			
			//파일로 저장하기
			File file = new File("C:/Users/tjdal/workspace/java_workspace/SeProject/res/copy.jpg");
			fos = new FileOutputStream(file);
			
			//한바이트씩 읽어와서 출력스트림을 이용해 파일에 쓰기
			int data= -1;
			while(true) {
				data = is.read();				
				if(data==-1)break;
				fos.write(data);
				cnt++;
			}			
			System.out.println("파일을 로컬에 저장 완료");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new URLLoadApp();

	}

}
