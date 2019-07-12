import datastructures.TreeNode;

public class MaxDepthBinaryTree {
	public static void main(String[] args) {
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

		System.out.print(height(root));
	}
	
	public static int height(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		return Math.max(height(root.left), height(root.right)) + 1;
	}
}
