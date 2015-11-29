package org.lc.string;


//Given a string s consists of upper/lower-case alphabets 
//and empty space characters ' ', return the length of last word in the string.
//If the last word does not exist, return 0.

public class LengthofLastWord {
	public static int lengthOfLastWord(String s) {
		s = s.trim();
		if(s==null || s.equals("") )
			return 0;
		String tmp[] = s.split(" ");
		return tmp[tmp.length-1].trim().length();
    }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" "));
	}
	
}
