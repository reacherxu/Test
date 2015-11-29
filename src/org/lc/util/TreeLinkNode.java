package org.lc.util;

import java.util.ArrayList;

public class TreeLinkNode {
	public int val ;
	public TreeLinkNode left;
	public TreeLinkNode right;
	public TreeLinkNode next;

	public TreeLinkNode(int x) {
		val = x;
	}

	public static void preOrder(TreeLinkNode node) {
		System.out.println(node.val);
		if(node.left != null)
			preOrder(node.left);
		if(node.right != null)
			preOrder(node.right);
	}
	//负数代表空
	public static TreeLinkNode plant(int[] tree) {
		TreeLinkNode root = new TreeLinkNode(tree[0]);
		ArrayList<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
		nodes.add(root);

		for(int i=1;i<tree.length;i++) {
			if( tree[i] > 0) {
				TreeLinkNode tmpNode = new TreeLinkNode(tree[i]);
				TreeLinkNode parent = nodes.get((i+1)/2 - 1);
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
}