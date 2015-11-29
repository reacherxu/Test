package org.xzt.testcase;

import java.io.*;

public class TestInputStreamReader {

	/**
	 * @param args
	 */
	public static void  main(String[] args) {
		//ע�� �� System.in �������InputStream���͵�
		InputStreamReader isr = new InputStreamReader(
				System.in);
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(
					new FileOutputStream("e:/welcome.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		try {
			
			while( (s = br.readLine()) != null){
				if( s.equalsIgnoreCase("exit")){
					break;
				}
				System.out.println(s.toUpperCase());
				osw.write(s);
				s = br.readLine();
			}
			osw.close();
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
