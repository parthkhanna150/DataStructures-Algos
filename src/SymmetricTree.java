//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;

import datastructures.TreeNode;

public class SymmetricTree {
	public static void main(String[] args) {		
		TreeNode root = new TreeNode(0);
		root.right = new TreeNode(2);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		root.left.left.right = new TreeNode(7);
//		root.right.left.left = new TreeNode(7);
		System.out.println(isSymmetry(root));
		
	}

	public static boolean isSymmetry(TreeNode root) {
		if(root == null || (root.right == null && root.left == null)) {
			return true;
		}
		if((root.left == null && root.right != null) || (root.right == null && root.left != null) || (root.right.val != root.left.val) ) {
			return false;
		}
		return isSymmetry(root.left, root.right);
//		return isSymmetric(root.left, root.right);
	}
	
	public static boolean isSymmetry(TreeNode left, TreeNode right) {
		if((left == null && right == null) || (left.left == null && right.right == null) && (left.right == null && right.left == null)) {
			return true;
		}
		if((left.left == null && right.right != null) || (left.right == null && right.left != null)) {
			return false;
		}
		
		else if((left.left == null && right.right == null) && (left.right != null && right.left != null)) {
			if(left.right.val == right.left.val) {
				return isSymmetry(left.left, right.right) && isSymmetry(left.right, right.left);
			}
			return false;
		}
		else if((left.left != null && right.right != null) && (left.right == null && right.left == null)) {
			if(left.left.val == right.right.val) {
				return isSymmetry(left.left, right.right) && isSymmetry(left.right, right.left);
			}
			return false;
		}
		else if((left.left != null && right.right != null) && (left.right != null && right.left != null) && (left.left.val == right.right.val && left.right.val == right.left.val)) {
			return isSymmetry(left.left, right.right) && isSymmetry(left.right, right.left);
		}
		return false;
	}
	
	public static boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		return left.val==right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.right);
	}


}

