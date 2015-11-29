package org.lc.util;

import java.util.List;

public class Util {
	public static void print(int []numbers) {
		System.out.print("[");
		for(int i=0;i<numbers.length;i++) {
			if( i == numbers.length-1)
				System.out.print(numbers[i]);
			else
				System.out.print(numbers[i]+",");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static void print(int [][]numbers) {
		System.out.println("[");
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[0].length; j++) {
				System.out.print(numbers[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static void print(List<List<Integer>> list) { // function as System.out.print,this is not necessary
		System.out.println("{");
		for(int i=0;i<list.size();i++) {
			System.out.print("[");
			List<Integer> tmpList = list.get(i);
			for(int j=0;j<tmpList.size();j++) {
				if(j == tmpList.size()-1)
					System.out.print(tmpList.get(j));
				else
					System.out.print(tmpList.get(j)+",");
			}
			System.out.print("]"+"\n");
		}
		System.out.println("}");
	}
}
