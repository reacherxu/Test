package org.lc.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.lc.util.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
 * @author Reacher
 *
 */
public class BinaryTreeIterativeTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while( root!=null || !stack.isEmpty()) {
			while( root != null ) {
				res.add(root.val);
				stack.add(root);
				root = root.left;
			}
			if(!stack.isEmpty()) {
				root = stack.pop();
				root = root.right;
			}
		}
		
		return res;
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(root!=null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			if( !stack.isEmpty() ) {
				root = stack.pop();
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}
	
	//false表示右子树未遍历，true则表示右子树已遍历
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> visited = new Stack<Boolean>();
		
		while( root!=null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				visited.push(false);
				root = root.left;
			}
			while(!stack.isEmpty() && visited.peek().equals(true)) {
				visited.pop();
				res.add(stack.pop().val);
			}
			if( !stack.isEmpty()) {
				visited.pop();
				visited.push(true);
				root = stack.peek();
				root = root.right;
			}
		}
		return res;
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root); 
		queue.add(null);
		
		while( !queue.isEmpty()) {
			
			root =  queue.remove();
			
			if(root != null) {
				list.add(root.val);
				if( root.left != null)
					queue.add(root.left);
				if( root.right != null)
					queue.add(root.right);
			} else {
				res.add(new ArrayList<Integer>(list));
				//队列辅助层序遍历，队列中插入NULL作为层与层之间的间隔，这里遇到NULL的时候在加NULL
				/*注意处理队列里最后的NULL时，不能再把它入队列以免形成死循环*/
				if(!queue.isEmpty()) {
					list.clear();
					queue.add(null);  
				}
			}
			
		}
		return res;
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();

		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root); 
		queue.add(null);

		while( !queue.isEmpty()) {

			root =  queue.remove();

			if(root != null) {
				list.add(root.val);
				if( root.left != null)
					queue.add(root.left);
				if( root.right != null)
					queue.add(root.right);
			} else {
				res.add(new ArrayList<Integer>(list));
				//队列辅助层序遍历，队列中插入NULL作为层与层之间的间隔，这里遇到NULL的时候在加NULL
				/*注意处理队列里最后的NULL时，不能再把它入队列以免形成死循环*/
				if(!queue.isEmpty()) {
					list.clear();
					queue.add(null);  
				}
			}

		}
		Collections.reverse(res);
		return res;
	}
	
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
	 */
	public static void main(String[] args) {
		BinaryTreeIterativeTraversal ins = new BinaryTreeIterativeTraversal();
		int a[] = {1,2,3,4,5,6};
		TreeNode root = TreeNode.plant(a);
		System.out.println(ins.preorderTraversal(root));
		System.out.println(ins.inorderTraversal(root));
		System.out.println(ins.postorderTraversal(root));
		System.out.println(ins.levelOrder(root));
		System.out.println(ins.levelOrderBottom(root));
	}
	
}
