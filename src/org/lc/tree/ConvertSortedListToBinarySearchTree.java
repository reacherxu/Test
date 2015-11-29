package org.lc.tree;

import java.util.ArrayList;
import java.util.List;

import org.lc.util.ListNode;
import org.lc.util.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author Reacher
 *
 */
public class ConvertSortedListToBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null )
			return null;
		
		ListNode p = head;
		int count = 1;
		while( p.next != null ) {
			count ++;
			p = p.next;
		}
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(head);
		return dfs(list,0,count-1);
	}
	

	//整体过程就是一次中序遍历，时间复杂度是O(n)，空间复杂度是栈空间O(logn)
	//思路就是先对左子树进行递归，然后将当前结点作为根，迭代到下一个链表结点，最后在递归求出右子树即可
	private TreeNode dfs(List<ListNode> list, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end) / 2;
		
		TreeNode left = dfs(list,start,mid-1);
		TreeNode root = new TreeNode(list.get(0).val);
		root.left = left;
		
		list.set(0, list.get(0).next);
		TreeNode right = dfs(list,mid+1,end);
		root.right = right;
		return root;
	}


	@SuppressWarnings("unused")
	private TreeNode dfs_1(ListNode head,ListNode tail) {
		if(head == tail)
			return null;
		
		ListNode fast = head,slow = head;
		while(fast != tail && fast.next != tail ) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		TreeNode root = new TreeNode(slow.val);
		root.left = dfs_1(head,slow);
		root.right = dfs_1(slow.next,tail);
		
		return root;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConvertSortedListToBinarySearchTree ins = new ConvertSortedListToBinarySearchTree();
		int a[] = {1,2,3};
		ListNode head = ListNode.init(a);
		TreeNode root = ins.sortedListToBST(head);
		TreeNode.preOrder(root);
	}

}
