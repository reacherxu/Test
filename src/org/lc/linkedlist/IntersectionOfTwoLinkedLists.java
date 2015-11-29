package org.lc.linkedlist;

import org.lc.util.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   	↘
                     c1 → c2 → c3
             
                   	↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 * @author Reacher
 *
 */
public class IntersectionOfTwoLinkedLists {
	public static ListNode getIntersectionNodeI(ListNode headA, ListNode headB) {
		if( headA == null || headB == null)
			return null;
		
		//locate the tail
		ListNode tail = headA;
		while( tail.next != null ) 
			tail = tail.next;
		tail.next = headB;
		//TODO  retain the original structure
		
		ListNode slow = headA, fast = headA;
		while( fast != null && fast.next != null ) {
			fast = fast.next.next;
			slow = slow.next;
			if( fast == slow )
				break;
		}
		if( fast == null || fast.next == null) //no cycle
			return null;
		
		slow = headA;
		while( slow != null ) {
			slow = slow.next;
			fast = fast.next;
			if( fast == slow)
				break;
		}
		
		tail.next = null;
		return slow;
		
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if( headA == null || headB == null)
			return null;
		
		int lenA = 0, lenB = 0;
		ListNode p = headA;
		while( p != null ) {
			lenA ++;
			p = p.next;
		}
		p = headB;
		while( p != null ) {
			lenB ++;
			p = p.next;
		}
		
		int diff = lenB - lenA;
		if( diff > 0 ) { //lenB > lenA
			ListNode q = headB;
			p = headA;
			while( diff > 0) {
				diff --;
				q = q.next;
			}
			while( p != q) {
				p = p.next;
				q = q.next;
			}
		} else {  //lenA >= lenB
			p = headA;
			ListNode q = headB;
			while( diff < 0 ) {
				diff ++;
				p = p.next;
			}
			while( p != q) {
				p = p.next;
				q = q.next;
			}
		}
		return p;
	}
	public static void main(String[] args) {
		int a[] = {1,3,5,7,9,11,13,15,17,19,21};
		ListNode headA = ListNode.init(a);
		int b[] = {2};
		ListNode headB = ListNode.init(b);
		getIntersectionNode(headA,headB).print();
	}
}
