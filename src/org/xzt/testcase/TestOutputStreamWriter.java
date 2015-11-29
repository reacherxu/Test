package org.xzt.testcase;

import java.io.*;

public class TestOutputStreamWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(
					new FileOutputStream("e:/welcome.txt"));
			
			osw.write("welcome �����");
			osw.write(osw.getEncoding());
			osw.close();
			System.out.println();
			
			/**
			 * ָ���������ļ�����д  ��ָ�����뷽ʽ
			 * ISO8859_1����ŷ����
			 */
			osw = new OutputStreamWriter(
					new FileOutputStream("e:\\welcome.txt",true),"ISO8859_1");
			osw.write("hello");
			osw.write(osw.getEncoding());
			osw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
