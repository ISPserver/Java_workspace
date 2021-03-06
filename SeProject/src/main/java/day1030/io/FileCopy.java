package day1030.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
   //String ori="C:/Users/tjdal/workspace/java_workspace/SeProject/res/data/memo.txt";//원본의 위치
   //String dest="C:/Users/tjdal/workspace/java_workspace/SeProject/res/data/memo_copy.txt";//복사될 경로의 위치 
	String ori="C:/Users/tjdal/workspace/java_workspace/SeProject/res/travel2/aa.jpg";//원본의 위치	
	String dest="C:/Users/tjdal/workspace/java_workspace/SeProject/res/travel2/photo.jpg";//복사될 경로의 위치 
   FileInputStream fis;//파일을 대상으로 한 입력 스트림 
   FileOutputStream fos;//파일을 대상으로 한 출력스트림
   public FileCopy() {
      //아래의 코드는 문법상 문제는 없다, 단 실행시 파일이 없을 경우 에러가 나면서 프로그램이 비정상종료될 수 있는 우려가 있다. 
      //따라서 sun에서는 이러한 우려에 대한 처리를 예외처리로 강제하고 있다 
    try {
      fis= new FileInputStream(ori);//스트림생성
      System.out.println("스트림 생성 성공! ");
      fos = new FileOutputStream(dest); //파일 출력스트림은 ,지정한 경로로 비어있는(empty) 파일을 생성해줌 
      //스트림 생성이 성공되었으므로, 데이터를 한 바이트씩 읽어서 다른 비어 있는 파일에 출력해보자
      int data;
      
      while(true) {     
      data=fis.read();//1byte 읽기 
      if(data== -1) break;
      fos.write(data);//1byte 쓰기
      }
      System.out.println("복사처리 완료했습니다.");
      
   } catch (FileNotFoundException e) {
      System.out.println("파일을 찾을 수 없습니다. ");//어플리케어션 사용자를 위한 메시지
      e.printStackTrace(); //개발자가 원인분석을 하기 위한 출력내용 
   }catch(IOException e){
      System.out.println("파일을 읽을 수 없어영 ");
      e.printStackTrace();
   }finally {
      if(fis !=null) {
         try {
            fis.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      if(fos !=null) {
          try {
             fos.close();
          } catch (IOException e) {
             e.printStackTrace();
          }
       }
   }
}
   public static void main(String[] args) {
      new FileCopy();
   }
}