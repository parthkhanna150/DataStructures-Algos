import java.util.*;
import datastructures.TreeNode;

public class LevelOrderTraversal {
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
		List<List<Integer>> list = levelOrder(root);
		
		for(List<Integer> level : list) {
			for(int num : level) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	
    	List<List<TreeNode>> outer = new ArrayList<>();
    	
    	if(root == null) { return new ArrayList<List<Integer>>(); }
    	
    	List<TreeNode> parents = new ArrayList<>();
    	List<TreeNode> children;
    	
        parents.add(root);
        
    	outer.add(parents);
        while(parents.size()>0) {
        	
        	children = new ArrayList<>();
        	
        	for(TreeNode parent : parents) {
        		if(parent.left != null) {
        			children.add(parent.left);
        		}

        		if(parent.right != null) {
        			children.add(parent.right);
        		}
        	}
        	if(children.size()>0)
        		outer.add(children);
        	parents = children;
        }
        
    	List<List<Integer>> answer = new ArrayList<>();
    	List<Integer> temp;
    	
		for(List<TreeNode> level : outer) {
			temp = new ArrayList<>();
			for(TreeNode node : level) {
				temp.add(node.val);
			}
			answer.add(temp);
		}
        
        return answer;
    }
    
}
