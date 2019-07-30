package Problems;
import java.util.ArrayList;
import java.util.List;

import datastructures.TreeNode;

public class DepthFirstSearch {
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
		iterativeDfs(root, list);
		
		for(int item : list) {
			System.out.println(item);
		}
	}
	
	public static void iterativeDfs(TreeNode root, List<Integer> list) {
		
	}

}
