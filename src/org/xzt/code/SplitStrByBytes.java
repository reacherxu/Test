package org.xzt.code;


public class SplitStrByBytes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//		String srcStr1 = "我ABC";  
		String srcStr2 = "我ABC汉DEF";  

		System.out.println(splitString(srcStr2,9));
	}

	//技术难点：知道汉字截半的话对应字节的ASC码为小于0的数值
	private static String splitString(String src, int len) {
		if(src == null || len < 0)
			return null;
		
		String res = "";
		int count = 0;
		for (int i = 0; i < src.length(); i++) {
			String sub = src.substring(i,i+1);
			count += sub.getBytes().length;
			if(count > len)
				break;
			else {
				res += sub;
			}
		}

		return res;
	}

}
