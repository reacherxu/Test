package org.xzt.test.socket_thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient_2 {
	private Socket client = null;
	private String host = "127.0.0.1";
	private int port = 9999;
	public SocketClient_2() {
		try {
			client = new Socket(InetAddress.getByName(host),this.port);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			writer.write("hello server "+client.getClass().getName());
			writer.write("\r\n");
			writer.flush();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println("client say:" + reader.readLine());
			
			client.close();
			reader.close();
			writer.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SocketClient_2();
	}
}
