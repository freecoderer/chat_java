package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ReceiveThread{

	private static Socket m_Socket;
	
	public boolean receiveResult() {
		boolean res = false;
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream(), "utf-8"));
			String receiveString = tmpbuf.readLine();
			res = getLoginResult(receiveString);
			tmpbuf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean getLoginResult(String msg) {
		if (msg.equals("Good"))
			return true;
		else
			return false;
	}
	
	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}

}
