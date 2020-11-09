package practice;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class  PracticeNote extends JFrame{
	

	public static void main(String[] args) throws IOException{
		BufferedImage buffr;
		URL url = new URL("https://cdn.gamemeca.com/data_center/192/382/20191013124203.jpg");
		buffr = ImageIO.read(url);
		String uri = url.getPath();
		int start = uri.lastIndexOf("/");
		int end = uri.length();
		uri = uri.substring(start+1,end);
		System.out.println(uri);	

	}
}
