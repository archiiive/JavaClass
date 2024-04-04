package i;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class I05_udpClient {

	public static void main(String[] args) {
		//UDP 클라이언트 메세지 전송~!!!
		try {
			//키보드 입력 데이터가 인풋스트림 리더에서 버퍼리더로
			BufferedReader Sysin = new BufferedReader(new InputStreamReader(System.in));
			//서버 IP
			InetAddress serverIP = InetAddress.getByName("230.0.0.1"); 
			while(true) { //데이터를 한줄씩 보내기위해 한줄읽기 실행
				String data = Sysin.readLine();
				DatagramSocket dataSocket = new DatagramSocket();
				//문자열을 바이트 배열에 저장
				byte[] msg1 = data.getBytes();
				
				//서버로 전송처리 (데이터, 데이터 길이, 서버ip, 포트번호)
				DatagramPacket outPacket=
						new DatagramPacket(msg1,msg1.length,serverIP,9000);
				dataSocket.send(outPacket);
				//소켓닫기
				dataSocket.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		
		}

	}

}
