package org.lc.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character
while preserving the order of characters.
No two characters may map to the same character 
but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
 * @author Reacher
 *
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if(s==null && t==null)
			return true;
		if(s.length() != t.length())
			return false;
		
		s = s.trim();
		t = t.trim();
		Map<Character,Character> mapS = new HashMap<Character,Character>(); //字符进行一一对应即可
		Map<Character,Character> mapT = new HashMap<Character,Character>();
		boolean flag = true;
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i); 
			if( !mapS.containsKey(sc) && !mapT.containsKey(tc)) {
				mapS.put(sc, tc);
				mapT.put(tc, sc);
			} else {
				if(mapS.containsKey(sc) && mapT.containsKey(tc)) {
					if(mapS.get(sc) == tc && mapT.get(tc) == sc)
						flag = true;
					else 
						return false;
				} else 
					return false;
			}
		}
		
		return flag;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsomorphicStrings ins = new IsomorphicStrings();
		System.out.println(ins.isIsomorphic("egg", "fof"));
	}

}
