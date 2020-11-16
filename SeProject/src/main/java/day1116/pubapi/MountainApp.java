package day1116.pubapi;

// 산 정보 조회 API (공공 데이터 포털)
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;


public class MountainApp {
    public static void main(String[] args) throws IOException {
    	String apiKey = "VXYE9AMjJU42E7Uyh3%2FE3FoQbMOqBcc7xymMzNuoI%2FglGhxUhGCmFpMBEBubDoiVh0UhjhfjeVLbBCyNvBemiw%3D%3D";
    	
    	//밑의 주소는 가끔 개발자의 실수로 인해 다르게 표기될 수가 있기 때문에 홈페이지의 End point와 비교를 해봐야 한다.
        StringBuilder urlBuilder = new StringBuilder("http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+apiKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("mntnNm","UTF-8") + "=" + URLEncoder.encode("속리산", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnHght","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnAdd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnInfoAraCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnInfoSsnCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnInfoThmCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}