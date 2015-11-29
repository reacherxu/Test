package org.xzt.testcase;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TestClient {

	public static void main(String[] args) {
		//127.0.0.1�Ǳ����൱��host
		Socket s;
		try {
			s = new Socket("127.0.0.1",6666);
			//��˳��  
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("IP:"+s.getInetAddress()+";port:"+s.getPort());
			dos.flush();
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
