package org.lc.tree;

import java.util.ArrayList;
import java.util.List;

import org.lc.util.TreeNode;

/**
 * Maximum Depth of Binary Tree
 * Minimum Depth of Binary Tree
 * 
 *        	  5
             / \
            4   8
           /   / 
          11  13  
         /  \      
        7    2      
 * @author Reacher
 *
 */
public class DepthOfTree {
	public static int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return left > right ? left+1 : right+1;
	}
	
	public static int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		//special case 为 仅一棵子树的情况
		if(root.left == null )  
			return minDepth(root.right) + 1;
		if(root.right == null )
			return minDepth(root.left) + 1;

		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return left < right ? left+1 : right+1;
	}
	
	//preOrder
	//TODO  Recursive solution is trivial, could you do it iteratively?
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		preOrder(root,list);
		return list;
	}
	private static List<Integer>  preOrder(TreeNode node,List<Integer>  list) {
		if(node == null)
			return list;
		
		list.add(node.val);
		preOrder(node.left,list);
		preOrder(node.right,list);
		return list;
	}

	//postOrder	 
	//TODO Note: Recursive solution is trivial, could you do it iteratively?
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postOrder(root,list);
		return list;
	}
	private static List<Integer> postOrder(TreeNode root, List<Integer> list) {
		if(root == null)
			return list;
		
		postOrder(root.left,list);
		postOrder(root.right,list);
		list.add(root.val);
		return list;
	}
	//TODO Recursive solution is trivial, could you do it iteratively
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inOrder(root,list);
		return list;
	}
	private static void inOrder(TreeNode root, List<Integer> list) {
		if(root == null)
			return ;
		
		inOrder(root.left,list);
		list.add(root.val);
		inOrder(root.right,list);
//		return list;
	}
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		TreeNode root = TreeNode.plant(a);
		System.out.println("preOrder:"+preorderTraversal(root));
		System.out.println("postOrder:"+postorderTraversal(root));
		System.out.println("inOrder:"+inorderTraversal(root));
	}
}
