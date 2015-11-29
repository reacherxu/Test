package org.lc.util;

/**
 *Definition for singly-linked list.
 */
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	public static ListNode init(int a[]) {
		ListNode head = new ListNode(Integer.MAX_VALUE);
		ListNode p = head;
		for(int i=0;i<a.length;i++) {
			ListNode tmp = new ListNode(a[i]);
			p.next = tmp;
			p = tmp;
		}
		return head.next;
	}
	
	public void print() {
		ListNode p = this;
		while(p.next != null ) {
				System.out.print(p.val+"->");
				p = p.next;
		}
		System.out.println(p.val);
	}
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		init(a).print();
	}
}