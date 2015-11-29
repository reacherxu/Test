package org.lc.string;
/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author Reacher
 *
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		//special case
		if(strs.length == 0)
			return "";

		String res = "";
		int miniDist = Integer.MAX_VALUE;
		for (String string : strs) {
			if(string.length() < miniDist)
				miniDist = string.length();
		}
		for(int i=0;i<miniDist;i++) {
			String comp = strs[0].substring(i, i+1);
			int j;
			for( j=1;j<strs.length;j++) {
				if( !strs[j].substring(i, i+1).equals(comp))
					break;
			}
			if( j == strs.length)
				res += comp;
			else
				break;
		}
		return res;
	}

	public static void main(String[] args) {
		String s[] = {"reacher","reacherxzt","reachjdi"};
		System.out.println(longestCommonPrefix(s));
	}

}
