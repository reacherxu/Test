package org.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import org.lc.util.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author Reacher
 *
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0)
			return null;
		List<ListNode> list = new ArrayList<ListNode>();
		for (ListNode listNode : lists) {
			list.add(listNode);
		}
		return mergeLists(list,0,lists.length-1);
	}
	private ListNode mergeLists(List<ListNode> list , int start, int end) {
		if( end - start == 0) 
			return list.get(start);
		if( end - start == 1) {
			return mergeTwoLists(list.get(start),list.get(end));
		}
		
		int mid = (start + end) / 2;
		ListNode left = mergeLists(list,start,mid);
		ListNode right = mergeLists(list,mid+1,end);
		return mergeTwoLists(left, right);
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeKSortedLists ins = new MergeKSortedLists();
		int a[] = {5 ,6,9};
		int b[] = {3,4,7};
		int c[] = {1,11,16};
		int d[] = {1,14,17};
		int e[] = {2,8,22};
		ListNode node1 = ListNode.init(a);
		ListNode node2 = ListNode.init(b);
		ListNode node3 = ListNode.init(c);
		ListNode node4 = ListNode.init(d);
		ListNode node5 = ListNode.init(e);
		
		ListNode[] lists = {node1,node2,node3,node4,node5};
		ins.mergeKLists(lists).print();
		
	}

}
