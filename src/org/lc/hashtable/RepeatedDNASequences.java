package org.lc.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 *  for example: "ACGAATTCCG".
 *   When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) 
that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 * @author Reacher
 *
 */
public class RepeatedDNASequences {
	//Memory Limit Exceeded
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		Map<Integer,Integer> subs = new HashMap<Integer,Integer>();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		for (int i = 0; i <= s.length()-10; i++) {
			String sub = s.substring(i, i+10);
			int key = getKey(sub,map);
			if( !subs.containsKey(key) ) {
				subs.put(key, 1);
			} else {
				if (!res.contains(sub)) {
					res.add(sub);
				}
			}
		}
		return res;
	}
	private int getKey(String substring, Map<Character, Integer> map) {
		int bit = 0;
		for (int i = 0; i < substring.length(); i++) {
			bit = (bit << 2) + map.get(substring.charAt(i));
		}
		return bit;
	}
	
	public List<String> findRepeatedDnaSequencesII(String s) {  
		List<String> result=new ArrayList<String>();  
		HashMap<Integer,Integer> computed=new HashMap<Integer,Integer>();  
		for(int i=0;i<=s.length()-10;i++)  
		{  
			String sub=s.substring(i,i+10);  
			int key=getKeyII(sub);  
			if(computed.containsKey(key))  
			{  
				computed.put(key,computed.get(key)+1);  
				if(computed.get(key)==2)  
					result.add(sub);  
			}  
			else  
				computed.put(key,1);  
		}  
		return result;  
	}  
	public int getKeyII(String s)  
	{  
		int result=0;  
		for(int i=s.length()-1;i>=0;i--)  
		{  
			int b=0;  
			switch(s.charAt(i))  
			{  
			case 'A':  
				b|=0;  
				break;  
			case 'T':  
				b|=1;  
				break;  
			case 'G':  
				b|=2;  
				break;  
			case 'C':  
				b|=3;  
				break;  
			}  
			result=b|result;  
			result=result<<2;  
		}  
		return result;  
	}  
	public static void main(String[] args) {
		RepeatedDNASequences ins = new RepeatedDNASequences();
		System.out.println(ins.findRepeatedDnaSequences("AAAAAAAAAAA"));
	}
}
