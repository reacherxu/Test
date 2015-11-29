package org.xzt.testcase;

import java.io.*;

public class TestDataStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			DataInputStream dis = new DataInputStream(bais);
			System.out.println("["+dis.readDouble()+","+dis.readBoolean()+"]");
			dos.close();
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
