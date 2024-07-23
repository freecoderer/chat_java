package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class SendThread {

	private static Socket m_Socket;
	private String ID;
	private String PW;
	
	public SendThread(String ID, String PW) {
		this.ID = ID;
		this.PW = PW;
	}

	public void sendInfo() {
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			
			BufferedWriter sendWriter = new BufferedWriter(new OutputStreamWriter(m_Socket.getOutputStream(), "utf-8"));
			//PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			
			String text = "!" + this.ID + ":" + this.PW;
			sendWriter.write(text);
			sendWriter.newLine();
			sendWriter.flush();
			
			tmpbuf.close();
			//m_Socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

				
	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}	
}
