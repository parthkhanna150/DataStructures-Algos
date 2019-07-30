package Problems;
import java.util.*;

import datastructures.TreeNode;

public class BreadthFirstSearch {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		TreeNode root = new TreeNode(0);
		root.right = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(8);
		root.left.right.right.right = new TreeNode(9);
		root.left.right.right.right.left = new TreeNode(10);
		recursiveBfs(root, list);
		
		for(int item : list) {
			System.out.println(item);
		}
	}
	
//	O(n)
	public static void iterativeBfs(TreeNode root, List<Integer> answer) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode p = queue.remove();
			answer.add(p.val);
			
			if(p.left != null)
				queue.add(p.left);

			if(p.right != null)
				queue.add(p.right);
		}
	}
	
//	O(n^2)
	public static void recursiveBfs(TreeNode root, List<Integer> answer) {
		int h = height(root);
		for(int i=1; i<=h; i++) {
			helper(root, answer, i);
		}
	}
	
	public static void helper(TreeNode root, List<Integer> answer, int level) {
		if(root == null ) {
			return;
		}
		
		if(level == 1) {
			answer.add(root.val);
		}
		
		else if(level > 1) {
			helper(root.left, answer, level-1);
			helper(root.right, answer, level-1);
		}
	}
	
	public static int height(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		return Math.max(height(root.left), height(root.right)) + 1;
	}
}
