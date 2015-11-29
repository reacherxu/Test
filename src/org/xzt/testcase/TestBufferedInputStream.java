package org.xzt.testcase;

import java.io.*;

public class TestBufferedInputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int b = 0;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String s = null;//Ϊ�˶�һ��readLine����
		try {
			br = new BufferedReader(new FileReader("e:\\aa.java"));
			bw = new BufferedWriter(new FileWriter("e:\\hello.java"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while( (s=br.readLine()) != null){
				System.out.println(s);
				/**
				 * дһ�У�Ҫ��newLine()���������зָ�
				 */
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
