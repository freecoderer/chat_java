package client;

import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;


public class LoginClient {

	public static String UserID;
	public static String UserPW;
	private static final String ServerIP = "15.165.53.89";
	private static final int ServerPORT = 21258;
	private static boolean loginSuccess;
	
	public LoginClient(String ID, String PW) {
		System.setProperty("file.encoding","UTF-8");
		try {
			Socket c_socket = new Socket(ServerIP, ServerPORT);

			SendThread send_thread = new SendThread(ID, PW);
			send_thread.setSocket(c_socket);
			send_thread.sendInfo();
			
			ReceiveThread rec_thread = new ReceiveThread();
			rec_thread.setSocket(c_socket);
			
			loginSuccess = rec_thread.receiveResult();
			c_socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean getLoginResult() {
		return loginSuccess;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
