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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //traverse through the trees, check in each node
        if (p != null && q == null) return false;
        else if (p == null && q != null) return false;

        if (p == null && q == null) return true;
        if (p.val != q.val) return false;

        if (isSameTree(p.left, q.left) == false) { return false; }
        if (isSameTree(p.right, q.right) == false) { return false; }

        return true;        
    }
}
