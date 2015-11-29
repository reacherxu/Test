package org.xzt.testcase;


public class Test1 {
	public static void main(String[] args) throws Exception {
		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		long to = df.parse("2013-4-25").getTime();
//		long from = df.parse("2013-1-20").getTime();
//		System.out.println((to - from) / (1000 * 60 * 60 * 24));
//		
//		System.out.println(Math.round(2.2));
		print("Eric Richard","reacher");
//		System.out.println("0.2316".matches("[.0-9]*"));
	}

	private static void print(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			System.out.println(i+":"+objects[i].toString());
		}
	}
}
