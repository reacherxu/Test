package org.xzt.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	
	public static boolean judgeRow(String line) {
		boolean result = false;
		line = line.trim();

		if(line.startsWith("（") || line.startsWith("(")) {
			String second = line.substring(1).trim();
			if(second.substring(0, 1).matches("\\d")) {
				String third = second.substring(1).trim();
				if(third.startsWith("）") || third.startsWith(")")) {
					result = true;
				}
			}
		} else {
			result = false;
		}
		return result;
	}
	
	public static String[] seperateNum(String line) {
		String result[] = new String[2];
		result[0] = "";
		result[1] = "";
		
		String tmp[] = line.split("\\s") ;
		for(int i=0;i<tmp.length;i++) {
			tmp[i] = tmp[i].trim();
		}
		for(int i=0;i<tmp.length;i++) {
			tmp[i] = tmp[i].trim();
			if(tmp[i].matches("^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$") && i>=1 ) {
				result[1] = tmp[i];
				break; //后面的不要了
			} else {
				result[0] += tmp[i];
			}
		}
		return result;
	}
	public static void analyzePdf() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("data/pdf_page5"));
		String line = null;
		while( (line=reader.readLine()) != null ) {
			if(line.length() < 3)
				continue;
			if(line.substring(0,1).matches("[\\d一二三四合]") || judgeRow(line)  ) {
				if( !line.contains("研究经费") &&
						!line.contains("科研业务费") &&
						!line.contains("测试") &&
						!line.contains("能源") &&
						!line.contains("会议费") &&
						!line.contains("出版物") &&
						!line.contains("其他") &&
						!line.contains("实验材料费") &&
						!line.contains("原材料") &&
						!line.contains("仪器设备费") &&
						!line.contains("购置") &&
						!line.contains("试制") &&
						!line.contains("实验室改装费") &&
						!line.contains("协作费") && 
						!line.contains("国际合作与交流费") &&
						!line.contains("项目组成员出国合作交流") &&
						!line.contains("境外专家来华合作交流") &&
						!line.contains("劳务费") &&
						!line.contains("管理费") &&
						!line.contains("合") )
						continue; //不能解决的情况
				String tmp[] = seperateNum(line);
				System.out.println(tmp[0]+"\t"+tmp[1]);
			}
				
		}
		reader.close();
	}
	
	private static String mergeJson(String jsonBudget, String jsonExpenditure) {
		return jsonBudget.replace("}", ",") + jsonExpenditure.substring(1);
	}
	public static void main(String[] args) throws IOException {
		System.out.println(mergeJson("{a:b,c:d,e:f}","{1:2,2:3}"));
	}
}
