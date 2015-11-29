package org.xzt.testcase;

import java.io.*;

public class TestPrintStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = args[0];
		if(fileName  != null){
			//���ļ�������ݶ�����������
			list(fileName,System.out);
		}

	}
	
	public static void list(String f,PrintStream ps){
		String s = null;
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(f));
			while( (s=br.readLine()) != null){
				System.out.println(s);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
