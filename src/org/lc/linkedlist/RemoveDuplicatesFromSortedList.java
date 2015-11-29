package org.lc.linkedlist;

import org.lc.util.ListNode;


/*Given a sorted linked list, delete all duplicates such that 
 * each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.*/

public class RemoveDuplicatesFromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		//<=1的元素
		if(head==null || head.next==null ) 
			return head;
		//>=2的元素
		ListNode pre = head,p=head.next;
		//end
		while( p != null) { 
			if( p.val == pre.val) {
				p = p.next; //首先保持p存在
				pre.next = p;
			} else {
				p = p.next;
				pre = pre.next;
			}
			
		}
			
		return head;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		System.out.println("original list is ");
		node1.print();
		
		System.out.println("after process,the list is ");
		deleteDuplicates(node1).print();
		
		
	}
}
