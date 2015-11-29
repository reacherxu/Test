package org.xzt.test;

import org.lc.util.TreeNode;

public class TestBinaryTree {
	/**
	 * 获得二叉树的深度
	 * @param node
	 * @return
	 */
	public static int getDepth(TreeNode node) {
		if( node == null )
			return 0;
		
		int lDepth = 1, rDepth = 1;
		lDepth = getDepth(node.left);	
		rDepth = getDepth(node.right);
		return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
	}
	
	/**
	 * 先序遍历
	 * @param node
	 */
	public static void preOrder(TreeNode node) {
		if( node == null)
			return ;
		
		System.out.print(node.val+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	/**
	 * 中序遍历
	 * @param node
	 */
	public static void inOrder(TreeNode node) {
		if( node == null )
			return ;
		
		inOrder(node.left);
		System.out.print(node.val+" ");
		inOrder(node.right);
	}
	/**
	 * 后序遍历
	 * @param node
	 */
	public static void postOrder(TreeNode node) {
		if( node == null )
			return ;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val+" ");
	}
	
	/*public static TreeNode getParent(TreeNode root,TreeNode node) {
		if( )
	}*/
	/**
	 * 创建一棵二叉树
	 *           A
	 *     B          C
	 *  D     E            F
	 *  
	 ********(前序遍历)[ABDECF]遍历*****************
key:1--name:rootNode(A)
key:2--name:B
key:4--name:D
key:5--name:E
key:3--name:C
key:6--name:F
*******(中序遍历)[DBEACF]遍历*****************
key:4--name:D
key:2--name:B
key:5--name:E
key:1--name:rootNode(A)
key:3--name:C
key:6--name:F
*******(后序遍历)[DEBFCA]遍历*****************
key:4--name:D
key:5--name:E
key:2--name:B
key:6--name:F
key:3--name:C
key:1--name:rootNode(A) 
	 * @param root
	 * @author WWX
	 */
	public static void main(String[] args) {

//		TreeNode root = new TreeNode(1);
//		TreeNode newNodeB = new TreeNode(2);
//        TreeNode newNodeC = new TreeNode(3);
//        TreeNode newNodeD = new TreeNode(4);
//        TreeNode newNodeE = new TreeNode(5);
//        TreeNode newNodeF = new TreeNode(6);
//        root.left=newNodeB;
//        root.right=newNodeC;
//        root.left.left=newNodeD;
//        root.left.right=newNodeE;
//        root.right.right=newNodeF;
		int a[] = {1,2,3,4,5,6};
		TreeNode root = TreeNode.plant(a);
        
        System.out.println("the depth is :" + getDepth(root));
        
        System.out.println("preOrder process :");
        preOrder(root);
        
        System.out.println("\n"+"inOrder process :");
        inOrder(root);
        
        System.out.println("\n"+"postOrder process :");
        postOrder(root);
        

	}
}
