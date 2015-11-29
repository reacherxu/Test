package org.lc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * @author Reacher
 * 
 */
public class MedianOfTwoSortedArrays {
	//统一 定为数组下标
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length+nums2.length;
		if( (len>>1) == 1 )
			return findMedian(nums1,0,nums1.length-1,nums2,0,nums2.length-1,len>>1);
		else 
			return findMedian(nums1,0,nums1.length-1,nums2,0,nums2.length-1,(len>>1)-1)
					+ findMedian(nums1,0,nums1.length-1,nums2,0,nums2.length-1,len>>1);
	}
	
	private double findMedian(int[] a,int aStart,int aEnd, int[] b, int bStart,int bEnd,int k) {
		int la = aEnd - aStart;
		int lb = bEnd - bStart;
		if( la > lb )  //ensure a's length < b's length to simplify the case
			return findMedian(b,bStart,bEnd,a,aStart,aEnd,k);
		
		int offset = Math.min(k>>1, la);
		if( a[offset] < b[offset] ) 
			return findMedian(a,aStart+offset,aEnd,b,bStart,bEnd,k-offset);
		else
			return findMedian(a,aStart,aEnd,b,bStart+offset,bEnd,k-offset);
	}

	//really bad    每次排除一个
	//第一：找两个不好找
	//第二：过程比较复杂
	public double findMedianSortedArrays_kick1(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		if(len1==0 && len2==0 )
			return 0.0;
		if(len1==0 && len2==1 )
			return nums2[0];
		if(len1==1 && len2==0 )
			return nums1[0];
		
		double res = 0;

		if (((len1 + len2) & 1) == 1)
			res = find(nums1, nums2, ((len1 + len2) >> 1) + 1 , false);
		else
			res = find(nums1, nums2, (len1 + len2) >> 1, true);
		return res;
	}

	private double find(int[] nums1, int[] nums2, int pos, boolean flag) {
		double res = 0;
		List<Integer> mid = new ArrayList<Integer>();
		int index1 = 0, index2 = 0;
		while (true) {
			if(index1 > nums1.length-1) {
				
				if(index1 + index2 >= pos-1) {
					mid.add(nums2[index2]);
					if(mid.size() == 2)
						break;
				}
				index2 ++;
				continue;
			}
			if(index2 > nums2.length-1) {
				
				if(index1 + index2 >= pos-1) {
					mid.add(nums1[index1]);
					if(mid.size() == 2)
						break;
				}
				index1 ++;
				continue;
			}
			
			if ( nums1[index1] < nums2[index2]) {
				if(index1 + index2 >= pos-1) {
					mid.add(nums1[index1]);
					if(mid.size() == 2)
						break;
				}
				index1++;
			} else {
				if(index1 + index2 >= pos-1) {
					mid.add(nums2[index2]);
					if(mid.size() == 2)
						break;
				}
				index2++;
			}
		}
		if( flag) 
			res =( mid.get(0) + mid.get(1) ) / 2.0;
		else
			res = mid.get(0);
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums1[] = {1,2,3,4};
		int nums2[] = {5,6,7};
		MedianOfTwoSortedArrays ins = new MedianOfTwoSortedArrays();
		System.out.println(ins.findMedianSortedArrays(nums1, nums2));

	}

}
