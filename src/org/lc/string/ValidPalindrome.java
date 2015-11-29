package org.lc.string;
/**
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? 
This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 * @author Reacher
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase().trim();
		if(s.length() == 0)
			return true;
		
		int i = 0,j = s.length()-1;
		while( i <= j) {
			char left = s.charAt(i);
			char right = s.charAt(j);
			if( !judge(left)) {
				i++;
				continue;
			}
			if( !judge(right)) {
				j--;
				continue;
			}
			if( left == right ) {
				i++;
				j--;
			} else {
				return false;
			}
			
		}
		return true;
	}

	private boolean judge(char c) {
		if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c<= '9'))
			return true;
		return false;
	}

	public static void main(String[] args) {
		ValidPalindrome ins = new ValidPalindrome();
		System.out.println(ins.isPalindrome("1k1"));
	}
}
