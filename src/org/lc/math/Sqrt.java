package org.lc.math;
/**
 * 
 * @author Reacher
 *
 */
public class Sqrt {
	public static int sqrt(int x) {
		if(x < 0 )
			return 0;
		
		int left = 0,right =  x / 2 + 1;
//		if(left * left == x)
//			return left;
//		else if( right * right == x)
//			return right;
//		else {
			while( left <= right  ) {
				long mid = (left + right) / 2;
//				System.out.print("mid:"+mid+"\t");
				long sq = mid * mid ;
				if( sq == x)
					return (int) mid ;
				else if ( sq > x)
					right = (int) (mid - 1);
				else
					left = (int) (mid + 1) ;
				
			}
			return right;
//		}
		
	
//		return Math.abs(left*left-x) > Math.abs(right*right-x) ? right : left;

	}
	
	public static int sqrtI(int x) {
	    long  i = 0;
	    long  j = x / 2 + 1;
	    while (i <= j)
	    {
	        long  mid = (i + j) / 2;
//	    	System.out.print("mid:"+mid+"\t");
	        long  sq = mid * mid;
	        if (sq == x) return (int) mid;
	        else if (sq < x) i = mid + 1;
	        else j = mid - 1;
	    }
	    return (int) j;
	}
	
	public static void main(String[] args) {
		int n = 1579205274;
		System.out.println(Math.sqrt(n));
		System.out.println(sqrt(n));
		System.out.println(sqrtI(n));
	}
}
