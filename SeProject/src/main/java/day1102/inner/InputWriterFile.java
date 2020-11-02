package day1102.inner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class InputWriterFile {
	FileReader reader;
	FileWriter writer;
	
	public InputWriterFile(String str) {
		URL url = this.getClass().getClassLoader().getResource("res/memo.txt");		
		String path = url.toString();
		File fe = new File(path);
		try {
			writer = new FileWriter(fe);
			writer.write(str);
		} catch (IOException e) {
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
	
	public static void main(String[] args) {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String str = br.readLine();
			new InputWriterFile(str);
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
		
	}
}
