package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author Reacher
 *
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}
	
	private ListNode mergeSort(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode fast = head,slow = head;
		while(fast.next != null && fast.next.next != null ) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow;
		slow = slow.next;
		fast.next = null;
		
		fast = mergeSort(head);//前半段
		slow = mergeSort(slow);//后半段
		return merge(fast,slow);
	}

	private ListNode merge(ListNode head, ListNode slow) {
		ListNode h = new ListNode(-1);
		ListNode left = h;
		ListNode p = head,q = slow;
		while ( p != null || q != null) {
			if(p == null) {
				left.next = q;
				break;
			} else if( q == null) {
				left.next = p;
				break;
			} else {
				if( p.val < q.val ) {
					left.next = p;
					p = p.next;
				} else {
					left.next = q;
					q = q.next;
				}
				left = left.next;
			}
		}
		return h.next;
	}

	public static void main(String[] args) {
		SortList ins = new SortList();
		int a[] = {8,9,2,4,6,9};
		ListNode head = ListNode.init(a);
		ListNode newHead = ins.sortList(head);
		newHead.print();
	}
	
}
