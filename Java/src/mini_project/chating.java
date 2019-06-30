package mini_project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class chating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Server server = new Server();

	}

}

class Server {

	public Server() {
		// 접속한 Client와 통신하기 위한 Socket
		Socket socket = null;
		// 채팅방에 접속해 있는 Client 관리 객체
		User user = new User();
		// Client 접속을 받기 위한 ServerSocket
		ServerSocket server_socket = null;

		int count = 0;
		Thread thread[] = new Thread[10];

		try {
			server_socket = new ServerSocket(0305); // 서버포트 입력해줌
			// Server의 메인쓰레드는 게속해서 사용자의 접속을 받음
			while (true) {
				socket = server_socket.accept();

				thread[count] = new Thread(new Receiver(user, socket));
				thread[count].start();
				count++;
			}
		} catch (Exception e) {
		}
		;
	}

}

class Receiver implements Runnable {

	Socket socket;
	DataInputStream in;
	String name;
	User user = new User();

	public Receiver(User user, Socket socket) throws Exception {
		this.user = user;
		this.socket = socket;
		// 접속한 Client로부터 데이터를 읽어들이기 위한 DataInputStream 생성
		in = new DataInputStream(socket.getInputStream());
		// 최초 사용자로부터 닉네임을 읽어들임
		this.name = in.readUTF();
		// 사용자 추가해줍니다.
		user.AddClient(name, socket);
	}

	public void run() {
		try {

			while (true) {
				String msg = in.readUTF();
				user.sendMsg(msg, name);
			}
		} catch (Exception e) {

			user.RemoveClient(this.name);
		}
	}
}

class User {

	HashMap<String, DataOutputStream> clientmap = new HashMap<String, DataOutputStream>();

	public synchronized void AddClient(String name, Socket socket) {
		try {
			sendMsg(name + " 입장하셨습니다.", "Server");
			clientmap.put(name, new DataOutputStream(socket.getOutputStream()));
			System.out.println("채팅 참여 인원 : " + clientmap.size());
		} catch (Exception e) {
		}

	}

	public synchronized void RemoveClient(String name) {
		try {
			clientmap.remove(name);
			sendMsg(name + " 퇴장하셨습니다.", "Server");
			System.out.println("채팅 참여 인원 : " + clientmap.size());
		} catch (Exception e) {
		}
	}

	public synchronized void sendMsg(String msg, String name) throws Exception {
		Iterator iterator = clientmap.keySet().iterator();
		while (iterator.hasNext()) {
			String clientname = (String) iterator.next();
			clientmap.get(clientname).writeUTF(name + ":" + msg);
		}
	}
}

class Client {
	public static void main(String[] arg) {
		Socket socket = null; // Server와 통신하기 위한 Socket
		DataInputStream in = null; // Server로부터 데이터를 읽어들이기 위한 입력스트림
		BufferedReader in2 = null; // 키보드로부터 읽어들이기 위한 입력스트림

		DataOutputStream out = null;

		try {

			socket = new Socket("서버주소", 0520); // 서버로 접속

			in = new DataInputStream(socket.getInputStream());
			in2 = new BufferedReader(new InputStreamReader(System.in));
			out = new DataOutputStream(socket.getOutputStream());

			// 채팅에 사용 할 닉네임을 입력받음
			System.out.print("닉네임을 입력해주세요 : ");
			String data = in2.readLine();

			// 서버로 닉네임을 전송
			out.writeUTF(data);
			// 사용자가 채팅 내용을 입력 및 서버로 전송하기 위한 쓰레드 생성 및 시작
			Thread th = new Thread(new Send(out));
			th.start();
		} catch (IOException e) {
		}
		try {
			// 클라이언트의 메인 쓰레드는 서버로부터 데이터 읽어들이는 것만 반복.
			while (true) {
				String str2 = in.readUTF();
				System.out.println(str2);
			}
		} catch (IOException e) {
		}
	}
}

class Send implements Runnable {
	DataOutputStream out;
	BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));

	public Send(DataOutputStream out) {
		this.out = out;
	}

	public void run() {
		while (true) {

			try {
				String msg = in2.readLine(); // 키보드로부터 입력을 받음
				out.writeUTF(msg); // 서버로 전송
			} catch (Exception e) {
			}
		}
	}
}