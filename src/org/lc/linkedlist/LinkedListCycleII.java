package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
 * @author Reacher
 *
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if( head == null || head.next == null)
			return null;
		
		ListNode slow = head, fast = head;
		while( fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if( slow == fast) //there's a cycle
				break;
		}
		if( fast == null || fast.next == null) //responding to the upon 'while'
			return null;
		
		slow = head;
		while ( slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	public static void main(String[] args) {

	}
}
