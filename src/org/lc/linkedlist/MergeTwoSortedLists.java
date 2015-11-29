package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author Reacher
 *
 */
public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
		if( l1 == null && l2 == null)
			return null;
		if(l1 == null && l2 != null)
			return l2;
		if(l1 != null && l2 == null)
			return l1;
		
		ListNode head = new ListNode(Integer.MAX_VALUE);//indicate the head
		ListNode p = head;
		while(l1!=null || l2!=null ) {
			if(l1 == null && l2 != null) {
				p.next = l2;
				break;
			}
			else if(l1 != null && l2 == null) {
				p.next = l1;
				break;
			}
			else {

				if( l1.val < l2.val ) {
					p.next = l1;
					p = p.next;
					l1 = l1.next;
				} else {
					p.next = l2;
					p = p.next;
					l2 = l2.next;
				}
			}
		}
		
		return head.next;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(Integer.MAX_VALUE);//indicate the head
		ListNode cur = head;
		ListNode p = l1, q = l2;
		
		while(p != null || q != null) {
			if(p == null) {
				cur.next = q;
				break;
			}
			if(q == null) {
				cur.next = p;
				break;
			}
			
			if(p.val < q.val) {
				cur.next = new ListNode(p.val);
				cur = cur.next;
				p = p.next;
			} else {
				cur.next = new ListNode(q.val);
				cur = cur.next;
				q = q.next;
			}
		}
		return head.next;
	}
	public static void main(String[] args) {
//		int a[] = {5 ,6,9};
		int b[] = {3,4,7};
		ListNode node1 = null;
		ListNode node2 = ListNode.init(b);
		
		
		System.out.println("after process,the list is ");
		mergeTwoLists(node1,node2).print();
		
//		node1.print();
//		node2.print();
		
	}
}
