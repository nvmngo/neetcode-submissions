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
    public int maxDepth(TreeNode root) {
        //using depth first search

        //for each sub-tree, we will compare the maxDepth of the left and right subtree, then take the larger one, add one to get the max depth

        if (root == null) {
            return 0;
        }

        //using post-order traversal
        int depth1 = maxDepth(root.left);
        int depth2 = maxDepth(root.right);
        return Math.max(depth1 + 1, depth2 + 1);
    }
}