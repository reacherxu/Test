package org.lc.tree;

import org.lc.util.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal 
if they are structurally identical and the nodes have the same value.
 * @author Reacher
 *
 */
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	if( p==null && q==null)
    		return true;
    	else if(p==null && q!=null)
    		return false;
    	else if( p!=null && q==null)
    		return false;
    	else {

    		if( p.val != q.val )
    			return false;
    		else
    			return isSameTree(p.left,q.left) &&isSameTree(p.right,q.right);
    	}
    }
    
    public static void main(String[] args) {
    	int a[] = {10,5,15};
    	int b[] = {10,5,0,0,15};
		TreeNode rootA = TreeNode.plant(a);
		TreeNode rootB = TreeNode.plant(b);
		
		System.out.println(isSameTree(rootA,rootB));
	}
}
