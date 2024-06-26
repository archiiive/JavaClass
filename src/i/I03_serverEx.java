package i;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class I03_serverEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(9999);
			//무한반복( 클라이언트 접속 대기)
			while(true) {
				System.out.println("클라이언트 접속 대기");
				Socket client = server.accept();//연결 성공시 소켓 객체 반환;
				System.out.println("쓰레드 생성");		//클라이언트와 서버간의 개별 세션 생성하기 위해서 쓰레드를 만듭니다
				HttpThread ht = new HttpThread(client);
				ht.start();
				
			}
		} catch (Exception e) {
			
		}

	}

}


//Http통신을 위한 스레드 생성
class HttpThread extends Thread{
	private Socket client;
	BufferedReader br;
	PrintWriter pw; //web 에서 사용할 데이터 
	public HttpThread(Socket client) {
		this.client = client;
		try {
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));//클라이언트가보낸 데이터 처리
			//버퍼리더로
			pw = new PrintWriter(client.getOutputStream());	//응답데이터 처리 서버가 보낼내용
		}catch(Exception e) {
			System.out.println(e.getMessage()); 
		}
	}
	@Override
	public void run() {
		BufferedReader fbr = null;
		BufferedOutputStream outToClient = null;
		try {
			String line = br.readLine();
			//line : GET / HTTP / 1. 1  -http 요청 헤더의 첫번째줄 내용
			System.out.println("HTTP Header : "+line);
			int start = line.indexOf("/")+1;
			int end = line.lastIndexOf("HTTP")-1;
			String fileName = line.substring(start, end);
			if(fileName.equals("")){
				fileName="index.html";
			}
			System.out.println("사용자 요청 파일 : "+fileName);
			fbr = new BufferedReader(new FileReader(fileName));
			String fileLine = null;
			pw.println("HTTP/1.0 200 Document Follows \r\n");
			while((fileLine = fbr.readLine()) != null) {
				pw.println(fileLine);
				pw.flush();
			}
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				if(br != null) br.close();
				if(br != null) pw.close();
				if(client != null) client.close();
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
				// TODO: handle exception
			}
		}
		
	}
}
