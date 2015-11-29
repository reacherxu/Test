package org.lc.linkedlist;

import java.util.HashMap;
import java.util.Map;

import org.lc.util.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * @author Reacher
 *
 */
public class ReorderList {
	public static void reorderList(ListNode head) {
		if( head == null || head.next == null)
			return ;
		
		Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();
		ListNode p = head;
		int pos  = 0;
		while( p != null ) { //break into every single node and reorder it
			map.put(pos, p);
			p = p.next;
			pos += 1;
		}
		
		int n = pos - 1;
		pos = 0;
		ListNode h = new ListNode(-1);
		p = h;
		while ( pos <= n/2 ) {
			map.get(pos).next = map.get(n - pos);
			p.next = map.get(pos);
			p = map.get(n - pos);
			pos ++;
		}
		p.next = null;
		
		head = h.next;
	}
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		ListNode head = ListNode.init(a);
		head.print();
		
		System.out.print("after the process, the list is : ");
//		reorderList(head).print();
	}
}
