package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Given a list, rotate the list to the right by k places, 
 * where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL
 * @author Reacher
 *
 */
public class RorateList {
	public static ListNode rotateRight(ListNode head, int n) {
		if(head == null || head.next == null)
			return head;
		
		ListNode p = head;
		ListNode tail = null;
		int len = 0;
		ListNode copy = new ListNode(-1);
		ListNode q = copy;
		
		//copy a list
		while( p != null ) {
			ListNode tmp = new ListNode(p.val);
			q.next = tmp;
			q = tmp;
			if( p.next == null)
				tail = p;
			p = p.next;
			len ++;
		}
		tail.next = copy.next;
		
		n = n % len;
		int pace = len - n;
		int i = 1;
		p = head;
		while( i < 2 * len ) {
			if( i == pace)
				head = p.next;
			if( i == len + pace ) {
				p.next = null;
				break;
			}
			p = p.next ;
			i ++;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		ListNode head = ListNode.init(a);
		head.print();
		
		System.out.print("after the process, the list is : ");
		rotateRight(head,6).print();
	}
}
