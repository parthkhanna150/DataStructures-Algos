package Problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import datastructures.TreeNode;

public class BuildTreeFromPO_IO {
	
	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode root  =  buildTree(inorder, postorder);
		List<Integer> list = new ArrayList<>();
		BreadthFirstSearch.iterativeBfs(root, list);
		for(int item : list) {
			System.out.println(item);
		}

	}
	
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length<=0 || postorder.length<=0)
            return null;

        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int inorderIndex = indexOf(inorder, postorder[postorder.length-1]);
        if(inorderIndex==-1)
            return null;

        postorder = Arrays.copyOfRange(postorder, 0, postorder.length-1);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, inorderIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, inorderIndex+1, inorder.length);
        
        TreeNode left = buildTree(inorderLeft, postorder);
        TreeNode right = buildTree(inorderRight, postorder);
        root.left = left;
        root.right = right;
        return root;
    }
    
    public static int indexOf(int[] arr, int val) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==val){
                return i;
            }
        }
        return -1;
    }
}