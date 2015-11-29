package org.lc.math;

import java.util.LinkedList;
import java.util.List;

//Reverse digits of an integer.
public class ReverseInteger {
	//Please notice the boundry case and special cases,-2147483648,1534236469
	public static long reverse1(int x) {
		boolean sign = false;
		if(x < 0) {
			sign = true;
			x = Math.abs(x);
		}
		
		List<Integer> bits = new LinkedList<Integer>(); 
		int len = 0;
		while( x % 10 != 0 || x / 10 !=0) {
			int bit = x % 10;
			bits.add(bit);
			x = x / 10;
			len ++;
		}
		long reverse = 0;
		int i=0;
		while(len > 0) {
			len --;
//			System.out.print(bits.get(i) * Math.pow(10,len));
			reverse =(long) (reverse + bits.get(i) * Math.pow(10,len));
//			System.out.println("\t"+reverse);
			i++;
		}
		
		if( reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
			return 0;
		if(sign == true)
			return  (-1)*(int)reverse;
		else
			return (int) reverse;
	}
	public static int reverse(int x) {  
		long newNum=0,old=x;//*Notice* long,so that it can compare with MAX_Value
	    x=(x>0)?x:(0-x);
	    while(x!=0){
	        newNum*=10;
	        newNum+=x%10;
	        x/=10;
	        if(newNum>Integer.MAX_VALUE||newNum<Integer.MIN_VALUE)
	            return 0;
	    }
	    if(old>0)
	        return (int)newNum;
	    else if(old<0)
	        return (int)(0-newNum);
	    else 
	        return 0;
    }  
	public static void main(String[] args) {
		System.out.println(reverse1(1534236469));
	}
}
