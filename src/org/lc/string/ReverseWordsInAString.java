package org.lc.string;
/**
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
1.What constitutes a word?
A sequence of non-space characters constitutes a word.
2.Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
3.How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 * @author Reacher
 *
 */
public class ReverseWordsInAString {
	public static String reverseWords(String s) {
		if(s == null)
			return null;
		
		String res = "";
		s = s.trim();
		String tmp[] = s.split("\\s+");
		for(int i=tmp.length-1;i>=0;i--) {
			if(i == 0)
				res += tmp[i];
			else
				res += tmp[i]+" ";
		}
		return res;
	}
	public static void main(String[] args) {
		String str = "the sky   is 	 blue	";
		System.out.println(reverseWords(str));
	}
}
