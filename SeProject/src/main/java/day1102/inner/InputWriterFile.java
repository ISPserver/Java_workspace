package day1102.inner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class InputWriterFile {
	FileReader reader;
	FileWriter writer;
		
	public InputWriterFile(String str) {
		URL url = this.getClass().getClassLoader().getResource("res/");		
		//File file = new File(uri); 이 방법도 가능
		//String[] pathArr = url.toString().split("file:");
		//String path= pathArr[1];		
		//File fe = new File(path);
		//"C:/Users/tjdal/workspace/java_workspace/SeProject/target/classes/res/memoNote.txt"
		try {
			URL url2 = new URL(url, "memoNote.txt");
			URI uri = url2.toURI();
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(uri)));
			bw.write(str);
			//for(int i=0; i<str.length(); i++) {
				//bw.append(str.charAt(i));
			//}
			bw.close();
			bw.flush();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}
	}
	public static void saveFile() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		try {
			String str = br.readLine();
			new InputWriterFile(str);
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {		
		saveFile();		
		
	}
}
