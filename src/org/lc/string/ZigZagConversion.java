package org.lc.string;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author Reacher
 *
 */
public class ZigZagConversion {
	/**
	 *  Problem:Time Limit Exceeded
	 * @param s
	 * @param nRows
	 * @return
	 */
	public static String convert(String s, int nRows) {
		String result = null;
		/**
		 * Input:	"", 1
			Output:	null
			Expected:	""
		 */
		if(  s==null)
			return null;
		else if(s.length()==0 )
			return "";
		if(nRows >= s.length() || nRows == 1)  //nRows==1的时候除数为0
			return s;
		
		result = "";
		for(int i=0;i<nRows;i++) {
			for(int index=0;index<s.length();index++) {
				if(index%(2*nRows-2) == i || index%(2*nRows-2) == 2*nRows-2-i)
					result += s.charAt(index);
			}
		}
		
		return result;
	}
	
	
	public static String convertII(String s, int nRows) {
		
		/**
		 * Input:	"", 1
			Output:	null
			Expected:	""
		 */
		if(  s==null)
			return null;
		else if(s.length()==0 )
			return "";
		if(nRows >= s.length() || nRows == 1)  //nRows==1的时候除数为0
			return s;
		
		String result = "";
		String strLine[] = new String[nRows];
		for(int i=0;i<nRows;i++) {
			strLine[i] = "";
		}
		
		for(int index=0;index<s.length();index++) {
			if(index%(2*nRows-2) >= nRows)
				strLine[2*nRows-2-index%(2*nRows-2)] += s.charAt(index);
			else 
				strLine[index%(2*nRows-2)] += s.charAt(index);
		}
		for(int j=0;j<nRows;j++) {
			result += strLine[j];
		}
		
		return result;
	}
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
//		System.out.println(s);
		System.out.println(convertII(s,3));
	}
}
