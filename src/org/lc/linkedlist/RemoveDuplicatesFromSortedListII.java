package org.lc.linkedlist;

import org.lc.util.ListNode;



/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 * @author Reacher
 *
 */
public class RemoveDuplicatesFromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null ) 
			return head;

		ListNode h = new ListNode(-1);
		h.next = head;
		
		ListNode pre = h, p = h.next;
		boolean delFlag = false;
		while( p.next != null ) {
			if( p.val == p.next.val ) {
				p = p.next;
				delFlag = true;
			} else {
				if( delFlag == true ) {
					pre.next = p.next;
					p = p.next;
					delFlag = false;
				} else {
					pre = p;
					p = p.next;
				}
			}
		}
		if( p.next == null && delFlag == true)
			pre.next = p.next;
		return h.next;
	}
	
	public static void main(String[] args) {
		int a[] = {1,1};
		ListNode head = ListNode.init(a);
		System.out.println("original list is ");
		head.print();
		
		System.out.println("after process,the list is ");
		deleteDuplicates(head).print();
		
		
	}
}
