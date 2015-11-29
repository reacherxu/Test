package org.xzt.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import org.lc.util.Util;

public class TestAllCases {


	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(3);queue.add(13);queue.add(8);queue.add(26);
		queue.add(1);queue.add(15);queue.add(25);queue.add(3);
		queue.add(89);queue.add(2);queue.add(6);
		while( !queue.isEmpty() ) {
			int tmp = queue.poll();
			System.out.print(tmp+"\t");
		}
		System.out.println();
		/*Random r = new Random();
		for (int i = 0; i < 20; i++) {
			System.out.print(r.nextInt(10)+"  ");
		}*/
		
	}

	@SuppressWarnings("unused")
	private static void testGeneric()  {
		ArrayList<String> arrayList1=new ArrayList<String>();  
        arrayList1.add("abc");  
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();  
        arrayList2.add(123);  
//        arrayList1.getClass().getMethod("add", Object.class).invoke(arrayList1, "fds");
//        System.out.println(arrayList1);
        System.out.println(arrayList1.getClass()==arrayList2.getClass()); 
        
		
	}

	@SuppressWarnings("unused")
	private static void testScanner() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input 2 nums:");
		String s = scanner.nextLine();
		System.out.println(s);
		
		System.out.println("input an array:");
		scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine());
		
	}

	//<< >>的优先级比+ - 低
	@SuppressWarnings("unused")
	private static void testBit() {
		//左移右移
		/*int hash = 3;
		System.out.println((hash<<2) + 1);*/
		//计算1的个数
		/*int x = 255;
		int count = 0;
		while( x != 0) {
			count ++;
			x = x & (x-1);
		}
		System.out.println(count);*/
		//43261596 , return 964176192 

		System.out.println(41);
	}

	@SuppressWarnings("unused")
	private static void testString() {
		String s0 = "abc"; 
		String s1 = "abc"; 
		System.out.println(s0==s1);

		String a0 =new String ("abc"); 
		String a1 =new String ("abc"); 
		System.out.println(a0==a1); 

		//		StringBuffer
		StringBuffer s = new StringBuffer("0123");
		s.insert(2, "xzt");
		System.out.println(s);
	}

	@SuppressWarnings("unused")
	private static void stringToCharSet() {
		String s = "reacher";
		char[] c = s.toCharArray();
		Arrays.sort(c);
		String s1  = Arrays.toString(c);
		System.out.println(s1);

	}

	@SuppressWarnings("unused")
	private static int testFinally(int x) {

		try {
			return x;
		} finally {
			x = 8;
		}
	}

	@SuppressWarnings("unused")
	private static void space() {
		String str = "the sky  is blue";
		String tmp[] = str.split("\\s+");
		for( int i=0;i<tmp.length;i++) {
			System.out.print(tmp[i]+"\t");
		}
	}



	@SuppressWarnings("unused")
	private static void swap() {
		int a = 1,b = 2;
		a = a + b;
		b =  a - b;
		a = a - b;
		System.out.println("a"+a+"\t"+"   b:"+b);
	}



	@SuppressWarnings("unused")
	private static void testTreeMap() {
		Map<Double,String> tree = new TreeMap<Double,String>();
		tree.put(3.0, "reacher");
		tree.put(2.0, "angus");
		tree.put(8.0, "lucien");
		tree.put(1.0, "bill");
		tree.put(2.8, "xzt");
		tree.put(6.0, "xuzhentao");
		for(Map.Entry<Double,String> entry : tree.entrySet())
			System.out.println(entry.getValue());

	}



	@SuppressWarnings("unused")
	private static void convertToSpecifiedField() {
		// TODO Auto-generated method stub
		double max=0.8;
		double min=0.5;
		for(int i=0;i<20;i++)
			System.out.println( Math.random()*(max-min)+min);
	}



	@SuppressWarnings("unused")
	private static void testArraySort() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);list.add(1);list.add(3);list.add(4);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);

		System.out.println(list.indexOf(3));

	}

	@SuppressWarnings("unused")
	private static void testOverFlow(int i) {
		long comparison = i;
		System.out.println(i);
		if(comparison > Integer.MAX_VALUE || comparison < Integer.MIN_VALUE)
			System.out.println("overflow");


	}

	@SuppressWarnings("unused")
	private static int test1(String str) {
		int INT_MAX = 2147483647;  
		int INT_MIN = -2147483648;  
		if (str == null || str.length() == 0) {  
			return 0;  
		}  
		char[] ch = str.trim().toCharArray();  
		if (ch.length == 0) {  
			return 0;  
		}  
		int head = 0;  
		long value = 0, signal = 1;  
		if (ch[head] == '+' || ch[head] == '-') {  
			signal = ch[head++] == '+' ? 1 : -1;  
		}  
		while (head < ch.length && ch[head] >= '0' && ch[head] <= '9') {  
			value = value * 10 + (ch[head++] - '0');  
			if (value * signal < INT_MIN || value * signal > INT_MAX) {  
				return value *signal < INT_MIN ? INT_MIN : INT_MAX;  
			}  
		}  
		return (int) (value * signal);  

	}

	@SuppressWarnings("unused")
	private static void testChar(String str) {
		for(int i=0;i<str.length();i++)
			if( '0' <= str.charAt(i) && str.charAt(i) <='9') 
				System.out.print(str.charAt(i)+"\t");
			else
				System.out.print("not a number"+"\t");
	}

	@SuppressWarnings("unused")
	private static void charAt() {
		String str = "reacher";
		for(int i=0;i<str.length();i++)
			System.out.println(str.charAt(i));
	}

	@SuppressWarnings("unused")
	private static void arrayCopy() {
		int arr1[] = { 0, 1, 2, 3, 4, 5 };
		int arr2[] = { 0, 10, 20, 30, 40, 50 };

		// copies an array from the specified source array
		System.arraycopy(arr1, 0, arr2, 3, 2);
		Util.print(arr1);
		Util.print(arr2);
	}

	@SuppressWarnings("unused")
	private static void integerOverflow() {
		System.out.println((int)9.646324351E9);
	}

}
