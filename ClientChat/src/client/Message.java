package client;

import java.io.InputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.net.Socket;


import org.omg.CORBA.portable.OutputStream;


public class Message{

	Socket socket;

	
	public void startClient() {
		Thread thread = new Thread() {
			public void run() {
				try {
					socket = new Socket("15.165.53.89",21258);
					receive();
				}catch(Exception e) {
					if(!socket.isClosed()) {
						stopClient();
						System.out.println("[서버 접속 실패]");
						Platform.exit();
					}
			
				}
							};
		
		};
	}
	public void receive() {
		while(true) {
			try {
				InputStream in = socket.getInputStream();
				byte[] buffer = new byte[512];
				int length = in.read(buffer);
				String message = new String(buffer, 0, length, "UTF-8");

			
			
		}catch (Exception e) {
			
		}
		}
		
	}
	public void send(String msg) {
		Thread thread = new Thread() {
			public void run() {
				try {
					OutputStream out = (OutputStream) socket.getOutputStream();
					byte[] buffer = msg.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
					
				}catch (Exception e) {
				
			}
			};
		};
		
	}
	
	public void main(String[] args) {
		
	}
	public void stopClient() {
		try {
			if(socket !=null && !socket.isClosed()) {
				socket.close();
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


