package org.lc.string;
/**
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", 
it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 * @author Reacher
 *
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		int res = 0;
		String[] digitA = version1.split("\\.");
		String[] digitB = version2.split("\\.");
		int len = Math.min(digitA.length, digitB.length);
		int i,j;
		for ( i = 0; i < len; i++) {
			if(compare(digitA[i],digitB[i]) != 0)
				break;
		}
		if( i >= len ) {
			if(digitA.length > len) {
				for (j = len; j < digitA.length; j++) {
					if( Integer.parseInt(digitA[j]) != 0 )
						break;
				}
				if( j >= digitA.length)
					res = 0;
				else
					res = 1;
			}
			if(digitB.length > len) {
				for (j = len; j < digitB.length; j++) {
					if( Integer.parseInt(digitB[j]) != 0 )
						break;
				}
				if( j >= digitB.length)
					res = 0;
				else
					res = -1;
			}
		} else {
			res = compare(digitA[i],digitB[i]);
		}
		return res;
		
	}

	private int compare(String s1, String s2) {
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
		if( a == b)
			return 0;
		else if(a > b) 
			return 1;
		else
			return -1;
	}

	public static void main(String[] args) {
		CompareVersionNumbers ins = new CompareVersionNumbers();
		System.out.println(ins.compareVersion("01.2","1.2.0.0"));
	}
}
