package org.lc.linkedlist;

import java.util.HashMap;
import java.util.Map;

import org.lc.util.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list
 * @author Reacher
 *
 */
public class ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if( head == null || head.next == null)
			return head;
		
		ListNode p = head;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int pace = 1;
		ListNode start = null;
		boolean flag = false;
		
		while( pace <= n ) {  //record the values from m to n
			if( pace == m ) {
				start = p;
				flag = true;
			}
			if( flag == true ) {
				map.put(pace, p.val);
			}
			
			p = p.next;
			pace ++;
		}
		
		pace = m;
		int sum = m + n;
		while( pace <= n) {
			start.val = map.get(sum-pace);
			pace ++;
			start = start.next;
		}
		
		return head;
	}

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		ListNode head = ListNode.init(a);
		head.print();
		
		System.out.print("after the process, the list is : ");
		reverseBetween(head,2,5).print();
	}
}
