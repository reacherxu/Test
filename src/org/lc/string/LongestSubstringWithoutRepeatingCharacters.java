package org.lc.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the length of the longest substring 
 * without repeating characters. For example, 
 * the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * abcad
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if( s == null )
			return 0;
		
		int maxLen = 0,curLen = 0;
		int start = 0;
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < s.length(); i++) {
			String c = s.substring(i,i+1);
			if(!map.containsKey(c) || (map.containsKey(c) && map.get(c) < start)) {
				map.put(c, i);
				curLen = i - start + 1;
				if(i == s.length()-1)
					if( maxLen < curLen)
						maxLen = curLen;
			} else {
				if( maxLen < curLen)
					maxLen = curLen;
				start = map.get(c) + 1;
				
				map.put(c, i);
			}
		}
		
		return maxLen;
	}
		
	public static void main(String[] args) {
		//  abcabcd
		System.out.println(lengthOfLongestSubstring("b"));
	}
}
