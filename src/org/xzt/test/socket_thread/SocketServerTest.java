package org.xzt.test.socket_thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {   
	private ServerSocket server = null;   
	private int port = 9999;   
	
	public SocketServerTest() throws IOException  {   
		server = new ServerSocket(this.port);
		int count = 0;
		while ( true ) {
			Socket serverClient = server.accept();
			count ++;
			System.out.println("this is the -"+count+"th clients");
			new ServerThread(serverClient).start();
//			ServerThread st = new ServerThread(serverClient);
//			new Thread(st).start();
		}
		
	}   
	
	public static void main(String[] args) throws Exception {   
		new SocketServerTest();   
	}   

}   