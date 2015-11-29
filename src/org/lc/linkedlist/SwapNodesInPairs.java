package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. 
You may not modify the values in the list, only nodes itself can be changed
 * @author Reacher
 *
 */
public class SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {
		ListNode h = new ListNode(Integer.MAX_VALUE);
		if(head == null)
			return head;
		
		h.next = head;// start from h
		ListNode p = h, q = head;
		while( q != null && q.next != null ) {
			ListNode r = q.next;
			q.next = q.next.next;
			p.next = r;
			r.next = q;
			
			p = p.next.next;
			q = p.next;
		}
		
		return h.next;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
//		node3.next = node4;
		
		node1.print();
		System.out.println("after process,the list is ");
		swapPairs(node1).print();
	}
}
