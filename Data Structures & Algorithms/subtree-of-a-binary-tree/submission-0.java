/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //check whether the current root is the same as the subRoot
        //if not, check the other branches

        if (isSameTree(root, subRoot)) { return true; }
        if (root == null) { return false; }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //method to check for similarity
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //traverse through the tree, check whether at a position, the value is different

        if (p == null && q == null) { return true; }
        else if (p == null || q == null) { return false; }

        if (p.val != q.val) {
            return false;
        }

        if (isSameTree(p.left, q.left) == false) return false;
        if (isSameTree(p.right, q.right) == false) return false;

        return true;
    }

}
