package i;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class I04_udpServerEx {

	public static void main(String[] args) {
		//UDP서버 
	   //
		try {
			//멀티캐스트
			String multicastAddr = "230.0.0.1";
			InetAddress multicastgroup = InetAddress.getByName(multicastAddr);
			MulticastSocket socket = new MulticastSocket(9000);
			socket.joinGroup(multicastgroup);//멀티캐스트 그룹 가입!!!!!!!!!!!
			//	leaveGroup()을 사요와면 멀티캐스트 그룹 해제!
			
			
			
			
			
			
			//DatagramSocket 객체 생성
			// DatagramSocket socket = new DatagramSocket(9500);
			
		//브로드 캐스트임 socket.setBroadcast(true);
			
			
			DatagramPacket inPacket;
			byte[] inMsg = null;
			while(true) {
				//데이터를 받기위한 바이트 배열을 생성
				inMsg = new byte[1024]; //512 or 1024 -(2048 xx안됨)
				//DatahramPacket 객체 생성
				inPacket = new DatagramPacket(inMsg, inMsg.length);
				//패킷데이터 수신
			socket.receive(inPacket);
			//문자열로 저장
			String msg = new String(inMsg,0,inPacket.getLength());
			System.out.println("Client Message : "+msg);
			
			//클라이언트 IP
			InetAddress address = inPacket.getAddress();
			//클라이언트 port
			int port = inPacket.getPort();//	/간단하게 메세지를 주고받는 서버
			System.out.println("클라이언트 주소 : "+address);
			System.out.println("클라이언트 포트번호 :" +port);
			
			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
