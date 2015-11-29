package org.lc.util;

import java.util.ArrayList;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	//负数代表空
	public static TreeNode plant(int[] tree) {
		TreeNode root = new TreeNode(tree[0]);
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(root);
		
		for(int i=1;i<tree.length;i++) {
			if( tree[i] > 0) {
				TreeNode tmpNode = new TreeNode(tree[i]);
				TreeNode parent = nodes.get((i+1)/2 - 1);
				if( (i+1) % 2 == 0)
					parent.left = tmpNode;
				else
					parent.right = tmpNode;
				
				nodes.add(tmpNode);
			} else 
				nodes.add(null);
		}
		return root;
	}
	public static void preOrder(TreeNode node) {
		if(node != null) {
			System.out.print(node.val+"->");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(20);
		System.out.println(tree.left);
		
	}
}
