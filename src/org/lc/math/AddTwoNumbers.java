package org.lc.math;

import org.lc.util.ListNode;

/**
 * Add Two Numbers 
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * @author Reacher
 *
 */
public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 != null)
			return l2;
		if(l1 != null && l2 == null)
			return l1;
		if(l1 == null && l2 == null)
			return null;
		
		ListNode head = null;
		
		int carry = 0;
		ListNode p = l1;
		ListNode q = l2;
		ListNode tail = head;
		
		while( (p != null || q != null) || (p==null && q==null && carry!=0)) {
			int pVal = p == null ? 0 : p.val;
			int qVal = q == null ? 0 : q.val;
			int val = pVal + qVal + carry;
			if( val >= 10) {
				val = val -10;
				carry = 1;
			} else {
				carry = 0;
			}
			
			ListNode tmp = new ListNode(val);
			
			if(head == null  ) { //only one element
				head = tail = tmp;
			} else {
				tail.next = tmp;
				tail = tmp;
			}
			
			if( p == null)
				p = null;
			else 
				p = p.next;
			if( q == null )
				q = null;
			else
				q = q.next;
		}
		return head ;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode p = new ListNode(8);
		l1.next = p;
		ListNode l2 = new ListNode(0);
		ListNode q = new ListNode(8);
		l2.next = q;
		l1.print();
		l2.print();
		
		ListNode head = addTwoNumbers(l1,l2);
		head.print();
	}
}
