package org.lc.tree;

import java.util.ArrayList;
import java.util.List;

import org.lc.util.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 *  such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22, {5,4,8,11,0,7,4,7,2,2,0,5,1};
 			  5
             / \
            4   8
           /   / \
          11  13  4
         /  \    /  \
        7    2  5    1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author Reacher
 *
 */
public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		dfs(root,sum,list,res);
		return res;
	}
	public void dfs(TreeNode node, int sum,List<Integer> list,
			List<List<Integer>> res) {
		if(node == null)
			return;
		
		list.add(node.val);
		if( node!=null && node.left==null && node.right==null  ) {
			if(node.val==sum) 
				res.add(new ArrayList<Integer>(list));
		} 
		
		dfs(node.left,sum-node.val,list,res);
		dfs(node.right,sum-node.val,list,res);
		
		list.remove(list.size()-1);
	}
	
	public static void main(String[] args) {
		PathSumII ins = new PathSumII();
		int a[] = {5,1,2,3,0,2,4,3,0,3,0,1,0};
		TreeNode root = TreeNode.plant(a);
		System.out.println(ins.pathSum(root,9));
	}
}
