package message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.net.Socket;

public class SendThread extends Thread{

   private Socket m_Socket;
   private String Msg;
   
   public SendThread(String Msg) {
		this.Msg = Msg;
	}
   
   @Override
   public void run() {
      // TODO Auto-generated method stub
      super.run();
      try {
         BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
         
         BufferedWriter sendWriter = new BufferedWriter(new OutputStreamWriter(m_Socket.getOutputStream(), "utf-8"));
         //PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
         
         String sendString;
         
         
         while(true) {
            sendString = tmpbuf.readLine();

            if(sendString.equals("exit")) {
               break;
            }
            
            sendWriter.write(sendString);
            sendWriter.newLine();
            sendWriter.flush();
         }
         
         sendWriter.close();
         tmpbuf.close();
         m_Socket.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   public void setSocket(Socket _socket) {
      m_Socket = _socket;
   }   
}