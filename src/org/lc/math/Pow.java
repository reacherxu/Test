package org.lc.math;

/**
 * Implement pow(x, n).
 * @author Reacher
 *
 */
public class Pow {
	//TLE
	public static double powI(double x, int n) {
		if(x > Double.MAX_VALUE)
			return Double.MAX_VALUE;
		if(x < Double.MIN_VALUE)
			return Double.MIN_VALUE;
		
		double res = 1.0;
		if( n > 0) {
			for( int i=0;i<n;i++) {
				if( res >= Double.MAX_VALUE) 
					res  = Double.MAX_VALUE;
				else 
					res *= x;
			}
		} else if( n==0 ) {
			res = 1;
		} else {
			if( x == 0)
				res = Double.NaN;
			else 
				for( int i=0;i<(-1)*n;i++) {
					if( res <= Double.MIN_VALUE)
						return Double.MIN_VALUE;
					else 
						res /= x;
				}
		}
		return res;
	}

	//Exception in thread "main" java.lang.StackOverflowError
	public static double powII(double x, int n) {
		double res = 1.0;
		
		if( n == 0)
			res = 1;
		else if( n > 0)
			return x * powII(x,n-1);
		else {
			if( x == 0)
				return Double.NaN;
			else {
				return 1.0 / powII(x,(-1)*n);
			}
		}
		
		if( res >= Double.MAX_VALUE)
			res = Double.MAX_VALUE;
		if(res <= Double.MIN_VALUE)
			res = Double.MIN_VALUE;
		return res;
	}
	
	public static double pow(double x, int n) {
		
		if( x == 0 && n > 0)
			return 0;
		if( x== 0 && n < 0)
			return Double.NaN;
		
		if( n == 0)
			return 1.0;
		else if( n > 0 ) 
			return power(x,n);
		else 
			return 1.0 / power(x,-n);
	}
	
	private static double power(double x, int n) {
		
		if ( n == 0)
			return 1.0;

		double v = power(x, n / 2);
		if ( n % 2 == 0) 
			return v * v;
		else
			return v * v * x;
			
	}

/*	public static double  power(double x, int n)
    {
        if (n == 0)
            return 1;
            
        double v = power(x, n / 2);
            
        if (n % 2 == 0)
            return v * v;
        else
            return v * v * x;
    }
    
    public static double  pow(double x, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n < 0)
            return 1.0 / power(x, -n);
        else
            return power(x, n);       
    }*/
    
	public static void main(String[] args) {
//		System.out.println(pow(1.00001,123456));
		System.out.println(pow(3,5));
	}
}
