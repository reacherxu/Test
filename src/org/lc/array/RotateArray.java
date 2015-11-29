package org.lc.array;
/**
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, 
there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
 * @author Reacher
 *
 */
public class RotateArray {
	public static void rotateI(int[] nums, int k) {
		k = k % nums.length;
		
		for(int i=0;i<k;i++) {
			int tmp = nums[nums.length-1];
			for(int j=nums.length-2;j>=0;j--) {
				nums[j+1] = nums[j];
			}
			nums[0] = tmp;
		}
		for(int i = 0;i<nums.length;i++) {
			System.out.print(nums[i]);
		}
	}
	public static void rotateII(int[] nums, int k) {
		k = k % nums.length;
		
		int rotate[] = new int[2*nums.length];
		for(int i=0;i<2;i++) {
			for(int j=0;j<nums.length;j++) {
				rotate[i*nums.length+j] = nums[j];
			}
		}
		
		int start = nums.length - k;
		for(int j=0;j<nums.length;j++) {
			nums[j] = rotate[start];
			start ++;
		}
		for(int i = 0;i<nums.length;i++) {
			System.out.print(nums[i]);
		}
	}
	
	public static void rotateIII(int[] nums, int k) {
		
		k = k % nums.length;
		reverse(nums,0,nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
	}
	private static void reverse(int[] nums, int i, int j) {
		while( i <= j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}
	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6,7};
		rotateIII(nums,3);
	}
}
