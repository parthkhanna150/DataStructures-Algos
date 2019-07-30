package Problems;
import java.util.*;

import datastructures.TreeNode;

public class InOrderTraversal {
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
		TreeNode curr = null;
		if(root!=null)
			curr = root;
		while(!stack.isEmpty() || curr != null) {
			stack.push(curr);
			while(curr.left!=null) {
				curr = curr.left;
				stack.push(curr);
			}
			curr = stack.pop();
			answer.add(curr.val);
			curr = curr.right;
		}		
	}
	
	public static void recursive(TreeNode root, List<Integer> answer) {
		if(root!=null) {
			recursive(root.left, answer);
			answer.add(root.val);
			recursive(root.right, answer);
		}
	}

}
