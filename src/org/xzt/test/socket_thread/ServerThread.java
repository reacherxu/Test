package org.xzt.test.socket_thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread {

	BufferedReader reader = null;
	BufferedWriter writer = null;
	Socket client = null;
	
	public ServerThread(Socket client) {
		try {
			this.client = client;
			this.reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			this.writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			System.out.println("server say:" + reader.readLine());
			
			writer.write("hello server "+this.client.getClass());
			writer.write("\r\n");
			writer.flush();
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
