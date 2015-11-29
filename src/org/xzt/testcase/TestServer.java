package org.xzt.testcase;
import java.net.*;
import java.io.*;
public class TestServer {

	public static void main(String[] args) {
		int count = 0; 
		ServerSocket ss;
		try {
			ss = new ServerSocket(6666);
			while(true) {
				count++;
				Socket s = ss.accept();
				DataOutputStream dos = new DataOutputStream(
						s.getOutputStream());
				dos.writeUTF("IP��"+s.getInetAddress()+";port:"+s.getPort());
				
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println(dis.readUTF());
				
				dos.flush();
				dos.close();
				dis.close();
				System.out.println(count+" client has connected!!");
				s.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
