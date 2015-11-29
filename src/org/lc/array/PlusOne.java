package org.lc.array;


/*Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list*/


/*//The complexity is O(1)
// f(n) = 9/10 + 1/10 * O(n-1)
//  ==>  O(n) =  10 / 9 = 1.1111 = O(1)

public int[] plusOne(int[] digits) {
    int carries = 1;
    for(int i = digits.length-1; i>=0 && carries > 0; i--){  // fast break when carries equals zero
        int sum = digits[i] + carries;
        digits[i] = sum % 10;
        carries = sum / 10;
    }
    if(carries == 0)
        return digits;
        
    int[] rst = new int[digits.length+1];
    rst[0] = 1;
    for(int i=1; i< rst.length; i++){
        rst[i] = digits[i-1];
    }
    return rst;
}*/
public class PlusOne { 
	//最高位放最低位
	public static int[] plusOne_ST(int[] digits) {
		int currentLength = digits.length;
		boolean flag = false;  //carry
		
		int i = currentLength-1;
		do {
			if(i == 0 && digits[i] == 9) {
				digits[i] = 0;
				flag = true;
				break;
			}
				
			if(digits[i] == 9) {
				digits[i--] = 0;
				flag = true;
			} else {
				digits[i] += 1;
				flag = false;
			}
				
		}while(flag == true);
	    if(flag == false)
	        return digits;
	        
	    int[] rst = new int[digits.length+1];
	    rst[0] = 1;
	    for(int j=1; j< rst.length; j++){
	        rst[j] = digits[j-1];
	    }
	    return rst;
	}
	
	public static int[] plusOne(int[] digits) {
		int currentLength = digits.length;
		boolean flag = false;  //carry
		
		int i = currentLength-1;
		do {
			if(i == 0 && digits[i] == 9) {
				digits[i] = 0;
				flag = true;
				break;
			}
				
			if(digits[i] == 9) {
				digits[i--] = 0;
				flag = true;
			} else {
				digits[i] += 1;
				flag = false;
			}
				
		}while(flag == true);
		
		if(flag == false)
			return digits;
		
		int newDigits[] = new int[digits.length+1];
		newDigits[0] = 1;
		System.out.println(newDigits[0]);

		//////这里出错了！！！！！！！  数组高位反而是低位
		for(int j=1;j<newDigits.length;j++) {
			newDigits[j] = digits[j-1];
		}
		return newDigits;
			
		
		
	}
	
	public static void main(String[] args) {
		int digits[] = {9};
//		plusOne_ST(digits);
		plusOne(digits);
	}
}
