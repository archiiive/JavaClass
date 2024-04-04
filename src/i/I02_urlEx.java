package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;

public class I02_urlEx {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      /*
       * url 객체 생성
       * URL url =  new URL("전체주소");
       * URL url =  new URL("호스트명","경로/파일명");
       * URL url =  new URL("호스트명","포트번호","경로/파일명"));
       */
      try {
         URL url = null;
         url = new URL("https://search.naver.com/search.naver?sm=tab_hty.top&ssc=tab.blog.all&query=url&oquery=java&tqi=ilgl0sqo1SossnxYCClssssstxV-450961");
         System.out.println("authority : "+url.getAuthority());
         System.out.println("content : "+url.getContent());
         System.out.println("protocol : "+url.getProtocol());
         System.out.println("host : "+url.getHost());
         System.out.println("port : "+url.getPort()); //현제 저 주소에 포트번호가 없어서 -1
         System.out.println("path : "+url.getPath());
         System.out.println("file : "+url.getFile());
         System.out.println("Query : "+url.getQuery());
         //
         //url을 통해서 정보 읽기
         //
         int data =0;
         
         try {
            Reader is = new InputStreamReader(url.openStream());
            while((data = is.read()) != -1) {
               System.out.print((char)data);
            }
            System.out.println();
         } catch (IOException e) {
            System.out.println(e.getMessage());      }
         //URLConnection
         //추상 클래스로 URL간의 연결을 담당하는 역할
         //URLConnection을 상속받아 구현한 클래스 HTTPURLConnection ,JARURLConnection
         url = null;
         String address = "https://www.egovframe.go.kr/home/sub.do?menuNo=9";
         try {
            url = new URL(address);
            URLConnection conn = url.openConnection();
            System.out.println("conn.toString(): " + conn);
            System.out.println("getAllowUserInteraction()" + conn.getAllowUserInteraction());
            System.out.println("getConnectTimeout() : " + conn.getConnectTimeout());
            System.out.println("getContent() : " + conn.getContent());
            System.out.println("getContentEncoding() :" + conn.getContentEncoding());
            System.out.println("getContentLength() : " + conn.getContentLength());
            System.out.println("getContentType() : " + conn.getContentType());
            System.out.println("getDate() : " + conn.getDate());
            System.out.println("getDefaultAllowUserInteraction() : "+ conn.getDefaultAllowUserInteraction());
            System.out.println("getDefaultUseCaches() : "+conn.getDefaultUseCaches());
            System.out.println("getDoInput() : " + conn.getDoInput());
            System.out.println("getDoOutput() : " + conn.getDoOutput());
            System.out.println(("getExpiration() :")+conn.getExpiration());
            System.out.println("getHeaderFields() :" +conn.getHeaderFields());
            System.out.println(("getIfModifiedSince():") +conn.getIfModifiedSince());
            System.out.println("getLastModified() :"+conn.getLastModified());
            System.out.println(" getReadTimeout() : " + conn.getReadTimeout());
//            System.out.println(" : " + conn.);
            System.out.println("getURL() : " + conn.getURL());
            System.out.println("getUseCaches() : " + conn.getUseCaches());      
            
            BufferedReader br = null; 
            String readline = "";
            try {
               url = new URL(address);
               br = new BufferedReader(new InputStreamReader(url.openStream()));
               
               while ((readline =  br.readLine())!=null) {
                  System.err.println(readline);
               }
            } catch (IOException e) {
               // TODO: handle exception
               e.printStackTrace();
               
            } finally {
               try { if(br!=null) br.close(); 
               } catch (Exception e) {
                  // TODO: handle exception
               }
            }
            
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
      }catch(Exception e) {
         System.out.println(e.getMessage());   
      }
   
   }
}

