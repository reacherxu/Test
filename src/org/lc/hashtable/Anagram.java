package org.lc.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 * @author Reacher
 *
 */
public class Anagram {
	public static List<String> anagrams(String[] strs) {
		List<String> res = new ArrayList<String>();
		Map<String,List<String>> anagrams = new HashMap<String,List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char []array = strs[i].toCharArray();
			Arrays.sort(array);
			String anagram = Arrays.toString(array);
			if( !anagrams.containsKey(anagram)) {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				anagrams.put(anagram, list);
			} else {
				List<String> list = anagrams.get(anagram);
				list.add(strs[i]);
				anagrams.put(anagram, list);
			}
		}
		for (Iterator<Entry<String, List<String>>> iterator = anagrams.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String,List<String>> entry = (Map.Entry<String,List<String>>) iterator.next();
			if(entry.getValue().size() > 1) {
				res.addAll(entry.getValue());
			}
			
		}
		return res;
	}

	public static void main(String[] args) {
		String []a = {"tea","and","ate","eat","dan"};
		System.out.println(anagrams(a));
	}
}
