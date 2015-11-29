package org.xzt.testcase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestReadby {
	public static void main(String[] args) throws IOException {
		String file = "d:\\我的酷盘\\study.txt";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		while(reader.ready()) {
			System.out.println(reader.readLine());
		}
		reader.close();
	}
}
