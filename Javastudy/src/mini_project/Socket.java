package mini_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.Socket;

public class Socket {

	public static void main(String[] args) {

	}

}

class TcpServerTest {
	TcpServerTest() {
		ServerSocket serverSocket = null;

		try {
			// 서버소켓을 생성하고 5000번 포트와 결합(bind) 시킨다.
			serverSocket = new ServerSocket(5000);
			System.out.println(getTime() + " 서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} // try - catch

		while (true) {
			try {
				System.out.println(getTime() + " 연결요청을 기다립니다.");
				// 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
				// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");

				// 소켓의 출력스트림을 얻는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out); // 기본형 단위로 처리하는 보조스트림

				// 원격 소켓(remote socket)에 데이터를 보낸다.
				dos.writeUTF("서버로부터의 메세지입니다.");
				System.out.println(getTime() + " 데이터를 전송했습니다.");

				// 스트림과 소켓을 달아준다.
				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // try - catch
		} // while
	} // main

	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	} // getTime
} // TcpServerTest

class TcpClientTest {
	TcpClientTest() {
		try {
			String serverIP = "127.0.0.1"; // 127.0.0.1 & localhost 본인
			System.out.println("서버에 연결중입니다. 서버 IP : " + serverIP);

			// 소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIP, 5000);

			// 소켓의 입력스트림을 얻는다.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in); // 기본형 단위로 처리하는 보조스트림

			// 소켓으로 부터 받은 데이터를 출력한다.
			System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");

			// 스트림과 소켓을 닫는다.
			dis.close();
			socket.close();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} // try - catch
	} // main
} // TcpClientTest
