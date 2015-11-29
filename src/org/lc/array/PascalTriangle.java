package org.lc.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		
		if( rowIndex < 0 )
			return result;
		else if( rowIndex == 0 ) {
			result.add(1);
		} else { //>=2
			result.add(1);
			result.add(1);
			for( int i=1;i<rowIndex;i++) { //generate row by row
				for(int j=result.size()-2;j>=0;j--)  { //override from last to first
					result.set(j+1, result.get(j)+result.get(j+1));
				}
				result.add(1);
			}
		}
		System.out.println(result);
		return result;
	}
	public static void main(String[] args) {
		getRow(3);
	}
}

