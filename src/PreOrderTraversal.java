import java.util.*;

import datastructures.TreeNode;

public class PreOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		List<Integer> answer = new ArrayList<>();
		iterative(root, answer);
		for(int i : answer) {
			System.out.println(i);
		}
	}
	
	public static void iterative(TreeNode root, List<Integer> answer) {
		Stack<TreeNode> stack = new Stack<>();
		
		if(root!=null) {
			stack.push(root);
		}
		
		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			answer.add(curr.val);
			if(root.right!=null) {
				stack.push(root.left);
			}
			
			if(root.left!=null) {
				stack.push(root.right);
			}
		}		
	}
	
	public static void recursive(TreeNode root, List<Integer> answer) {
		if(root!=null) {
			answer.add(root.val);
			recursive(root.left, answer);
			recursive(root.right, answer);
		}
	}

}
