package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 * @author Reacher
 *
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if( head == null || head.next == null)
			return false;
		
		ListNode slow = head, fast = head;
		while( fast != null && fast.next != null) { // if there's a cycle,fast mustn't be null
			fast = fast.next.next;
			slow = slow.next;
			if( fast == slow )
				return true;
		}
		return false;
	}
	public static void main(String[] args) {

	}
}
