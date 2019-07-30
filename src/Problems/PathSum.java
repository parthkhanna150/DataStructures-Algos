package Problems;
import java.util.LinkedList;
import datastructures.TreeNode;
//5
/// \
//4   8
///   / \
//11  13  4
///  \      \
//7    2      1

class TNwithSum{
    TreeNode node;
    TNwithSum left;
    TNwithSum right;
    int sum;
    TNwithSum(TreeNode node, int sum){
        this.node = node;
        this.sum = sum;
    }
}

class PathSum {
	public static void main(String[] args) {
    	TreeNode root = new TreeNode(5);
    	root.left  = new TreeNode(4);
    	root.right  =  new TreeNode(8);
    	root.left.left = new TreeNode(11);
    	root.right.left = new TreeNode(13);
    	root.right.right = new TreeNode(4);
    	root.left.left.left = new TreeNode(7);
    	root.left.left.right = new TreeNode(2);
    	root.right.right.right = new TreeNode(1);
    	System.out.print(hasPathSum(root, 22));

	}
    public static boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null)
    		return false;
    	if(isLeaf(root) && root.val == sum)
    		return  true;
        TNwithSum r = new TNwithSum(root, root.val);
        
//      use one of the following. recursive better
        return hasPathSumSimple(root, sum) || hasPathSum(r, sum);
    }
    
    public static boolean hasPathSum(TNwithSum root, int target){
    	LinkedList<TNwithSum>  ll = new LinkedList<>();
    	ll.push(root);
    	
    	while(!ll.isEmpty()) {
    		TNwithSum t = ll.remove();
    		if(t.node.left != null) {
    			t.left = new TNwithSum(t.node.left, t.node.left.val + t.sum);
    			if(t.left.sum ==  target && isLeaf(t.left.node))
    				return true;
    			ll.add(t.left);
    		}
    		if(t.node.right != null) {
    			t.right = new TNwithSum(t.node.right, t.node.right.val + t.sum);
    			if(t.right.sum ==  target && isLeaf(t.right.node))
    				return true;
    			ll.add(t.right);
    		}
    	}
        return false;
    }
    
    static boolean isLeaf(TreeNode l) {
    	return l.left==null && l.right==null;
    }
    
    public static boolean hasPathSumSimple(TreeNode root, int target){
    	if(root == null)
    		return false;
    	target -= root.val;
    	if(isLeaf(root))
    		return target==0;
    	return hasPathSumSimple(root.left, target)  || hasPathSumSimple(root.right, target);
    }
    
}