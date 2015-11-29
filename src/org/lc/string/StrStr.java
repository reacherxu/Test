package org.lc.string;
/**
 * Implement strStr().

Returns the index of the first occurrence of needle in haystack,
 or -1 if needle is not part of haystack.
 * @author Reacher
 *
 */
public class StrStr {
	public static int strStr(String haystack, String needle) {
		if(haystack.length()==0 && needle.length()!=0)
			return -1;
		if(haystack.length()!=0 && needle.length()==0)
			return 0;

		int pos = 0;
		if(haystack.contains(needle)) {
			for(int i=0;i<haystack.length();i++) {
				if( haystack.substring(i).startsWith(needle))
					pos = i;
			}
		} else {
			pos = -1;
		}
		return pos;
	}

	public static void main(String[] args) {
		System.out.println(strStr("",""));
	}
}
