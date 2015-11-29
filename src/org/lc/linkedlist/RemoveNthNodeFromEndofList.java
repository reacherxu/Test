package org.lc.linkedlist;

import org.lc.util.ListNode;
/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass
 * @author Reacher
 *
 */
public class RemoveNthNodeFromEndofList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if( head == null)
			return null;

		ListNode slow = head, fast = head;
		while( n>0 ) {  //Given n will always be valid.
			fast = fast.next;
			n--;
		}
		if(fast == null )
			return slow.next;
		while( fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		//remove the node 
		slow.next = slow.next.next;
		return head;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(5);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
		
		node1.print();
		System.out.println("after process,the list is ");
		removeNthFromEnd(node1,1).print();

	}
}
