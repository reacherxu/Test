package org.lc.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangleII {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascal = new LinkedList<List<Integer>>();
		if(numRows < 0)
			return null;
		
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2  = new ArrayList<Integer>();
		l1.add(1);
		l2.add(1);l2.add(1);
		
		if( numRows == 0 ) {
			return pascal; //0 Expected:	[]
		} else if( numRows == 1)
			pascal.add(l1);
		else if(numRows == 2) {
			pascal.add(l1);
			pascal.add(l2);
		} else {
			//initialize
			pascal.add(l1);
			pascal.add(l2);
			
			
			for(int numRow=0;numRow<numRows-2;numRow++) { //row of nums needed to add into pascal
				List<Integer> tmpList  = new ArrayList<Integer>();
				tmpList.add(1);
				//get the last list in pascal
				List<Integer> last = pascal.get(pascal.size()-1);
				for(int j=0;j<last.size()-1;j++) {
					tmpList.add(last.get(j)+last.get(j+1));
				}
				tmpList.add(1);
				
				pascal.add(tmpList);
			}
		}
			
		System.out.println(pascal);
		return pascal;
	}
	public static void main(String[] args) {
		generate(0);
	}
}
