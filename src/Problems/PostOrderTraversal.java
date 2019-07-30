package Problems;
import java.util.*;

import datastructures.TreeNode;

public class PostOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		List<Integer> answer = new ArrayList<>();
		iterative(root, answer);
		for(int i : answer) {
			System.out.println(i);
		}
	}
	
	public static void iterative(TreeNode root, List<Integer> answer) {
//		TODO
	}
	
	public static void recursive(TreeNode root, List<Integer> answer) {
		if(root!=null) {
			recursive(root.left, answer);
			recursive(root.right, answer);
			answer.add(root.val);
		}
	}

}
