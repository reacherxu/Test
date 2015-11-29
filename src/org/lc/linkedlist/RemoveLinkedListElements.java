package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author Reacher
 *
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if(head == null)
			return null;
		head.next = removeElements(head.next,val);
		return head.val == val ? head.next : head;
	}

	public ListNode removeElementsII(ListNode head, int val) {
		if(head == null)
			return null;

		ListNode h = new ListNode(-1);
		h.next = head;

		ListNode pre = h,p = h.next;
		while(p != null) {
			if( p.val == val) {
				pre.next = p.next;
				p = pre.next;
			} else {
				pre = p;
				p = p.next;
			}
		}
		return h.next;
	}
	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		 RemoveLinkedListElements ins = new RemoveLinkedListElements();
		 int a[] = {6,6,6};
		 ListNode head = ListNode.init(a);
		 head.print();
		 ListNode h = ins.removeElements(head, 6);
		 h.print();
	 }

}
