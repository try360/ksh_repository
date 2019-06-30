package mini_project;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MainServer();
		new MainClient();
		
	}

}

class MainServer {

	MainServer() {

		try {
			ServerSocket s_socket = new ServerSocket(8888);

			Socket c_socket = s_socket.accept();

			OutputStream output_data = c_socket.getOutputStream();

			String sendDataString = "Welcome to My Server";
			output_data.write(sendDataString.getBytes());

			s_socket.close();
			c_socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class MainClient{
	
	MainClient(){
		
		try {
			Socket c_socket = new Socket("192.168.0.2",8080);
			InputStream iput_data = c_socket.getInputStream();
			
			byte[] receiveBuffer = new byte[100];
			iput_data.read(receiveBuffer);
			
			System.out.println(new String(receiveBuffer));
			
			c_socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}