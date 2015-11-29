package xzt.gbk;

import java.util.StringTokenizer;

public class TestTokenizer {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("i have a dream"," ");
		System.out.println(st.countTokens());
		while(st.hasMoreElements()) {
			System.out.println((String)st.nextElement());
		}
		
		/*String []strs = "i have a dream".split(" ",2);
		for(int i=0;i<strs.length;i++) {
			System.out.println(strs[i]);
		}*/
	}
}
