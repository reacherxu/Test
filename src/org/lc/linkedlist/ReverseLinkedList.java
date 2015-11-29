package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively.
 Could you implement both?
 * @author Reacher
 *
 */
public class ReverseLinkedList {
	//iteratively
	public ListNode reverseList(ListNode head) {
		ListNode h = new ListNode(-1);
		while(head != null) {
			ListNode tmp = head;
			head = head.next;
			tmp.next = h.next;
			h.next = tmp;
		}
		return h.next;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseLinkedList ins = new ReverseLinkedList();
		int a[] = {1};
		ListNode head = ListNode.init(a);
		ListNode node = ins.reverseList(head);
		node.print();
	}

}
