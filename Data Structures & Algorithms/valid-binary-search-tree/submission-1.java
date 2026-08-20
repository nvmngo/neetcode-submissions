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
    public boolean isValidBST(TreeNode root) {
        //every node will have a value boundary
        return isValidHelper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidHelper(TreeNode root, double min, double max) {
        if (root == null) return true;
        if (root.val <= min) return false;
        if (root.val >= max) return false;

        if (isValidHelper(root.left, min, root.val) == false) return false;
        if (isValidHelper(root.right, root.val, max) == false) return false;

        return true;
    }
}
