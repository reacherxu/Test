package org.xzt.testcase;

import java.io.*;

public class TestInputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader in = null;
		FileWriter out = null;
		int b = 0;
		int count = 0;
		try {
			in = new FileReader("e:/aa.java");
			try {
				out = new FileWriter("E:/w.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�ļ������ڣ�");
			//e.printStackTrace();
		}
		try {
			while( (b=in.read()) != -1){
				//TODO
				//System.out.print((char)b);
				out.write((char)b);
				count++;
				
			}
			out.write(count+" ");
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
