package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Sort a linked list using insertion sort.
 * @author Reacher
 *
 */
public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode h = new ListNode(-1);
		ListNode tmp = new ListNode(head.val);
		h.next = tmp; //initial insertion sort
		head = head.next;
		
		while(  head != null ) {
			ListNode p = h;
			while( p.next != null && head.val > p.next.val ) 
				p = p.next;
			
			tmp = head;
			head = head.next;
			tmp.next = p.next;
			p.next = tmp;
		}
		return h.next;
	}
	public static void main(String[] args) {
		int a[] = {1,25,43,47,15};
		ListNode head = ListNode.init(a);
		head.print();
		
		System.out.print("after the process, the list is : ");
		insertionSortList(head).print();
	}
}

