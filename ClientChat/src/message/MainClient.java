package message;


import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;



public class MainClient {

   public static String UserID;
   private static final String ServerIP = "15.165.53.89";
   private static final int ServerPort = 21257;
   
   public MainClient(String Message) {
		System.setProperty("file.encoding","UTF-8");
		try {
			Socket c_socket = new Socket(ServerIP, ServerPort);

			SendThread send_thread = new SendThread(Message);
			send_thread.setSocket(c_socket);
			
			ReceiveThread rec_thread = new ReceiveThread();
			rec_thread.setSocket(c_socket);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
   public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
   
}

