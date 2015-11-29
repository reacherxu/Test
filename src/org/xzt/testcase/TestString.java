package org.xzt.testcase;

import java.io.*;

public class TestString {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = br.readLine();
			while( !(str.equals("exit")) ) {
				String[] split = str.split(" ");
				for(String ss : split) {
					String tmp = String.valueOf(ss.charAt(0));
					System.out.print(ss.replaceFirst(tmp, tmp.toUpperCase())+" ");
					
				}
				str = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String s = "reacher xu";
//		
//		String[] str = s.split(" ");
//		for(String ss : str) {
//			System.out.println(ss);
//		}

	}

}
