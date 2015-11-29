package org.lc.bit;
/**
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
 * @author Reacher
 *
 */
public class ReverseBits {
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
        	res <<= 1;
			res =  res | (n & 1);
			n >>= 1;
		}
        return res;
    }
    public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
	}
}
