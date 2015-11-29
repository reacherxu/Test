package org.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, 
print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * @author Reacher
 *
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		
		if( n == 0) {
			List<Integer> res = new ArrayList<Integer>();
			res.add(0);
			return res;
		}
		
		List<Integer> list = grayCode(n-1);
		List<Integer> res = new ArrayList<Integer>(list);
		int increment = 1<<(n-1);
		for (int i = list.size()-1; i >= 0; i--) {
			res.add(list.get(i)+increment);
		}
		return res;
	}

	public List<Integer> grayCodeII(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if( n < 0)
			return res;
		
		res.add(0);
		for (int i = 1; i <= n; i++) {
			int increment = 1<<(i-1);
			int size = res.size();
			for (int j = size-1; j >= 0; j--) {
				res.add(res.get(j)+increment);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		GrayCode ins = new GrayCode();
		System.out.println(ins.grayCodeII(3));
	}
}
