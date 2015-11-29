package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Given a linked list and a value x, partition it such that
 *  all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 * @author Reacher
 *
 */
public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null)
			return head;
		
		ListNode less = new ListNode(-1);
		ListNode p = less;
		
		ListNode greater = new ListNode(-1);
		greater.next = head;
		ListNode q = greater;
		
		while( q.next != null ) {
			if( q.next.val < x) {
				ListNode tmp = q.next;
				q.next = q.next.next;
				p.next = tmp;
				p = tmp;
			} else {
				q = q.next;
			}
		}
		p.next = greater.next;
		return less.next;
	}

	public static void main(String[] args) {
		int a[] = {2,1};
		ListNode head = ListNode.init(a);
		head.print();
		partition(head,2).print();
		
	}
}
